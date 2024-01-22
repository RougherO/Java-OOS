# Java OOS

All Java OOS assignments.

### Run.jar

`Run.java` and `Run.jar` are CLI apps made to quickly compile and execute all assignment questions. 

`Run.jar`/`Run.java` compiles all `.java` files passed to it and creates the corresponding `.class` files and also runs the JVM with the corresponding `.class` file.

Simply execute jar file to use Run.jar
```bash
$ java -jar Run.jar -m <mainfile> [OPTIONS...] <filename1.java> [<filename2.java>...]
```
Note that a main class needs to be specified explicitly by passing it in the `-m` flag -> the class with `public static void main(String[] args)` and then passing the `.java` files after that.

Example:
```bash
$ java -jar Run.jar BigProject1.java BigProject2.java -m BigProjectMain
```
By default it looks for the specified `.java` files in the current directory and produces the `.class` files in the current directory. To look for the `.java` files in a different directory specify it using `-s` flag and to change the output directory of `.class` files use `-o` flag.

Example:
```bash
$ java -jar Run.jar BigProject1.java BigProject2.java -m BigProjectMain -s JavaFiles -o CLassFiles
```
> Both source and output directories need to be present.

To clean the output directory which contains all temporary `.class` files simply pass `-r`. Be careful with this as it removes all `.class` files from the output directory passed through `-o` so important `.class` files might unintentionally get deleted too.

> Will probably fix this later using `java.nio.WatchService` if anyone else can work this out in the meantime and create a PR, I will be more than happy to merge it.

To check how to use Run.jar file use the -h option
```bash
$ java -jar Run.jar -h
```

To create the jar file from scratch compile Run.java and then build a jar file with the created .class files

```bash
$ jar cvfe Run.jar Run <location of .class files>
```

- `c` flag to create a new jar file
- `v` flag to get a verbose output [can skip if verbosity is not required]
- `f` flag to mention the filename of the jar file
- `e` flag to specify the main class

###### Pro tip: Use Chat-GPT and Tabnine for generating assignment code. Most of them are too repitetive to write with hand.
