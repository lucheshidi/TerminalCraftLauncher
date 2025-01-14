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
    > choose `org.springframework.boot.loader.launch.JarLauncher`. ***DON'T CHOOSE `BOOT-INF.classes.org.lucheshidi.tcl.Main`, BECAUSE IT CAN'T LAUNCH!!!***

## Linux