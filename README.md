# Terminal Craft Launcher

![Static Badge](https://img.shields.io/badge/License-GPL%20v3-green)
![GitHub top language](https://img.shields.io/github/languages/top/lucheshidi/TerminalCraftLauncher)
![Static Badge](https://img.shields.io/badge/Follow%20on-GitHub-black?logo=github&link=https%3A%2F%2Fgithub.com%2Flucheshidi)


**English** | [简体中文](README_zh-cn.md) | [繁体中文](README_zh-tw.md)

## Introduction
Terminal Craft Launcher(TCL) is an open-source, cross-platform Minecraft launcher that will support Mod Management, Game Customizing, ModLoader Installing (Forge, NeoForge, Fabric, Quilt, LiteLoader, and OptiFine), Modpack Creating, UI Customization, and more.

TCL has amazing cross-platform capabilities. Not only does it run on different operating systems like Windows, Linux, and macOS, but it also supports various CPU architectures such as x86, ARM, MIPS, and LoongArch. You can easily enjoy Minecraft across different platforms through TCL(even if the system has GUI).

About the crossed-platform, click on [here](PLATFORM.md)

## Download
If you are Windows, Please download the EXE file, if you are FreeBSD, Linux or like-unix system you can download the No-suffix executable file.
Now you can go to [this page](https://github.com/lucheshidi/TerminalCraftLauncher/releases) to download the release(But it's empty yet\[Crying\]).

Sometimes(I think) I will get a website and I can open the website download.

## compile manually
If you see [this](), then you need to make sure you are the development people, or you know about some computer knowledge.

Ok, are you ready? I will divide this tutorial into 2 parts (or 2 different situations) to walk you through the construction.

### part 1. ***I have Intellij IDEA***
Now you type in your terminal(bash(Linux), zsh(macOS), cmd(Windows)) and type:
```bash
git clone https://github.com/lucheshidi/TerminalCraftLauncher.git
```
Now open your idea to this folder, you'll see 4 running configuration. The 4 configuration do the not same thing:

 | Configuration name   | do                                        |
 |----------------------|-------------------------------------------|
 | :app:bootRun         | just run the program, but not compile.    |
 | app:build            | build Jar file, we will use it.           |
 | app:install          | for developers to install plugins.        |
 | Main                 | the Main program for TCL.                 |

Select `app:build` and running it. If it appears a green `SUCCESS`, you are successful build the Jar.
Go to the `./target/` folder it is a Jar file waiting for you!

### part 2. ***I just have a terminal***
You just need to type in the terminal(bash(Linux), zsh(macOS), cmd(Windows)):
```bash
git clone https://github.com/lucheshidi/TerminalCraftLauncher.git # clone this repository
cd TerminalCraftLauncher # go in the repository
./mvnw clean package # build Jar(Windows type no "./")
cd target # go to where the Jar file is
ls # show all the folder and file(Windows type "dir")
```
Now in this folder you can see a file named `TerminalCraftLauncher-1.0-SNAPSHOT.jar`.
I think you know how to do with the Jar file. or if you want to build Linux executable file or Windows EXE file, go [here](BUILD.md).

## 