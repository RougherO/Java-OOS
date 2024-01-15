# Java OOS

All Java OOS assignments.

### Run.jar

`Run.java` and `Run.jar` are CLI apps made to quickly compile and execute all assignment questions. 

JavaFiles contains all the `.java` files for `Run.jar`/`Run.java` to compile and create the corresponding `.class` files which are put in the ClassFiles directory.

Simply execute jar file to use Run.jar
```bash
$ java -jar Run.jar -m <mainfile> [OPTIONS...] <filename1.java> [<filename2.java>...]
```

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
