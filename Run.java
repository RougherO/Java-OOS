import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.io.File;
import java.io.IOException;

public class Run {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println(helpMessage);
            System.exit(64);
        }
        for (int i = 0; i < args.length; ++i) {
            switch (args[i]) {
                case "-h":
                    System.out.println(helpMessage);
                    System.exit(0);
                case "-c":
                    ++i;
                    if (i == args.length) {
                        System.err.println("No compile arguements found");
                        System.exit(64);
                    }
                    compileArgs = args[i];
                    break;
                case "-e":
                    ++i;
                    if (i == args.length) {
                        System.err.println("No runtime arguements found");
                        System.exit(64);
                    }
                    executeArgs = args[i];
                    break;
                case "-r":
                    removeClassFiles = true;
                    break;
                case "-m":
                    ++i;
                    if (mainFile != null) {
                        System.err.println("Main file is specified more than once. Only one file can be specified.");
                        System.exit(64);
                    }
                    if (i == args.length) {
                        System.err.println("No main file found.");
                        System.exit(64);
                    }
                    mainFile = args[i].trim();
                    break;
                case "-o":
                    ++i;
                    if (i == args.length) {
                        System.err.println("No output directory specified.");
                        System.exit(64);
                    }
                    classFileDir = args[i].trim();
                    break;
                case "-s":
                    ++i;
                    if (i == args.length) {
                        System.err.println("No source directory specified.");
                        System.exit(64);
                    }
                    sourceFileDir = args[i].trim();
                    break;
                default:
                    if (compileFiles == null) {
                        compileFiles = new ArrayList<String>();
                    }
                    compileFiles.add(args[i].trim());
            }
        }

        if (compileFiles == null) {
            System.err.println("No files specified.");
            System.exit(64);
        }

        if (mainFile == null) {
            System.err.println("No main file specified.");
            System.exit(64);
        }

        compile = Compile.create(compileFiles, compileArgs, sourceFileDir, classFileDir);
        try {
            compile.run();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        execute = Execute.create(mainFile, executeArgs, classFileDir);
        try {
            execute.run();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        if (removeClassFiles) {
            cleanup = Cleanup.create(classFileDir);
            try {
                cleanup.run();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static {
        helpMessage = "Usage: Run -m <mainfile> [OPTIONS...] <file1.java> [<file2.java>...]\n" +
                "Options:\n" +
                "  -h                    Show this help\n" +
                "  -c \"<compile args>\"   Compile arguments passed to java compiler as-is\n" +
                "  -e \"<execute args>\"   Execute arguments passed to JVM as-is\n" +
                "  -r                    Remove all generated .class files after program execution\n" +
                "  -m <main file>        Main class file (which contains the main method)\n" +
                "  -o <output dir>       Output directory of .class files relative to current dir. Defaults to current directory.\n"
                +
                "  -s <source dir>       Source directory of .java files to compile relative to current dir. Defaults to current directory.\n";
    }

    static private Compile compile;
    static private Execute execute;
    static private Cleanup cleanup;
    static private boolean removeClassFiles = false;
    static private String compileArgs = "";
    static private String executeArgs = "";
    static private List<String> compileFiles;
    static private String mainFile;
    static private String sourceFileDir = ".";
    static private String classFileDir = ".";
    static private String helpMessage;
}

class Compile {
    private Compile(List<String> files, String compileArgs, String sourceFileDir,
            String classFileDir) {
        compileCmd.add("javac");
        if (!compileArgs.isEmpty()) {
            compileCmd.add(compileArgs);
        }
        files.parallelStream().forEach((String fileName) -> compileCmd.add("./" + sourceFileDir + "/" + fileName));
        compileCmd.addAll(List.of("-d", "./" + classFileDir + "/"));
    }

    static Compile create(List<String> files, String compileArgs,
            String sourceFileDir, String classFileDir) throws IllegalStateException {
        if (count == 0) {
            ++count;
            return new Compile(files, compileArgs, sourceFileDir, classFileDir);
        }
        throw new IllegalStateException("Cannot create more than one instance of Compile");
    }

    void run() throws IOException, InterruptedException {
        int exitCode = new ProcessBuilder(compileCmd)
                .inheritIO()
                .start()
                .waitFor();
        if (exitCode != 0) {
            System.err.println("Compilation failed.");
            System.exit(exitCode);
        }
    }

    static {
        compileCmd = new ArrayList<>();
    }

    static private int count = 0;
    static private final List<String> compileCmd;
}

class Execute {
    private Execute(String mainFile, String executeArgs, String classFileDir) {
        executeCmd.add("java");
        if (!executeArgs.isEmpty()) {
            executeCmd.add(executeArgs);
        }
        executeCmd.addAll(List.of("-classpath", "./" + classFileDir + "/"));
        executeCmd.add(mainFile);
    }

    static Execute create(String mainFile, String executeArgs, String classFileDir) throws IllegalStateException {
        if (count == 0) {
            ++count;
            return new Execute(mainFile, executeArgs, classFileDir);
        }
        throw new IllegalStateException("Cannot create more than one instance of Execute");
    }

    void run() throws IOException, InterruptedException {
        int exitCode = new ProcessBuilder(executeCmd)
                .inheritIO()
                .start()
                .waitFor();

        if (exitCode != 0) {
            System.err.println("Execution failed.");
            System.exit(exitCode);
        }
    }

    static {
        executeCmd = new ArrayList<String>();
    }

    static private int count = 0;
    static private final List<String> executeCmd;
}

class Cleanup {
    private Cleanup(String classFileDir) {
        cleanDirectory = new File("./" + classFileDir);
    }

    static Cleanup create(String classFileDir) throws IllegalStateException {
        if (count == 0) {
            ++count;
            return new Cleanup(classFileDir);
        }
        throw new IllegalStateException("Cannot create more than one instance of Clean");
    }

    void run() throws IOException, InterruptedException {
        Stream.of(cleanDirectory.listFiles()).parallel().forEach((File file) -> {
            if (file.getName().endsWith(".class"))
                file.delete();
        });
    }

    static private int count = 0;
    static private File cleanDirectory;
}