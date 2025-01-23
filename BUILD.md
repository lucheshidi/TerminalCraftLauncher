# Build executable file for Linux(unix) and Windows
Now you need to know about what is your system type(Windows, Linux, macOS(unix))
If you are Linux(or macOS, unix), go [here](#Linux)
If you are Windows, go [here](#Windows)

## Windows
You need to [install exe4j](https://download.ej-technologies.com/exe4j/exe4j_unix_9_0.tar.gz)
Then open exe4j,

1. Click on `next`
2. Choose `"JAR in EXE" mode` and click `next`
3. The first one is the short name, you can write tcl, second one is where the EXE output.
4. This page is too big, I'll be some steps:
    > The first one is ***show console(Terminal)***, here must be `Console application`. If else, you can't see the whole tcl.
    > The second one is what the out EXE filename.
    > And click on `Advanced options`, choose `Architecture (32/64/ARM)`.
    > Choose your computer's architecture. (example my computer is `x86_64`, so I choose `x64`).
    > And just click `next`.
5. When you see the title is `Configure Java invocation` you click on the green +, you don't need to another things, follow me:
    > in `Archive`, you can write where is your built Jar file. If you haven't, go [here](README.md).
    > click on `next`. 
    > in the line of `Main class from[Class path], click on ...`.
    > choose `org.springframework.boot.loader.launch.JarLauncher`. ***DON'T CHOOSE `BOOT-INF.classes.org.lucheshidi.tcl.Main`, 'CAUSE IT CAN'T LAUNCH!!!***.
    > And click `next`.
6. write your Java's version in `Minimum version`. If you don't know, you can open cmd and type:
    > ```cmd
    > java -version
    > ```
    > if it said `"java" is not a executable file, cmdlet` or something, that you haven't installed java.
    > if the output have `openjdk version`, that you can write the number behind `version`.
7. Then just click `next` and when you show `exe4j has finished`. Now you can go to where you write the output folder and try!

## Linux
Linux is easier than Windows. because we already have the script.
Ok, let's start.
1. In where the jar file is, open the terminal in the parent directory.
2. type:
    ```bash
    cp stub.sh ./target/ # copy the script in the "target" folder(where the jar file is)
    cd target # back to "target" folder
    cat ./stub.sh [JAR] > [FILE] && chmod 777 [FILE] # create executable file("[JAR]" must be your jar file name, "[FILE]" must be the output file name).
    ```
3. Now you may have a executable file in this folder. Now you can use `./[FILENAME]` to run the program!

----
I think you may already have your executable file. click [here](README.md) to go back to the readme.