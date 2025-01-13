# Terminal Craft Launcher TCL

**English** | [简体中文](#zh-cn) | [繁体中文](#zh-tw)

## Introduction

TCL is an open-source, cross-platform Minecraft launcher that supports Mod Management, Game Customizing, ModLoader Installing (Forge, NeoForge, Fabric, Quilt, LiteLoader, and OptiFine), Modpack Creating, UI Customization, and more.

HMCL has amazing cross-platform capabilities. Not only does it run on different operating systems like Windows, Linux, and macOS, but it also supports various CPU architectures such as x86, ARM, MIPS, and LoongArch. You can easily enjoy Minecraft across different platforms through TCL.

## Download

Download the latest version in: [GitHub Releases](https://github.com/lucheshidi/TerminalCraftLauncher/releases).

Although not necessary, it is recommended only to download releases from the official websites listed above.

## License

The software is distributed under [GPLv3](https://www.gnu.org/licenses/gpl-3.0.html) license with the following additional terms:

### Additional terms under GPLv3 Section 7

1. When you distribute a modified version of the software, you must change the software name or the version number in a reasonable way in order to distinguish it from the original version. (Under [GPLv3, 7(c)](https://github.com/lucheshidi/TerminalCraftLauncher/tree/master/LICENSE))

   The software name and the version number can be edited [here](https://github.com/HMCL-dev/HMCL/blob/javafx/HMCL/src/main/java/org/jackhuang/hmcl/Metadata.java#L33-L35).

2. You must not remove the copyright declaration displayed in the software. (Under [GPLv3, 7(b)](https://github.com/HMCL-dev/HMCL/blob/11820e31a85d8989e41d97476712b07e7094b190/LICENSE#L368-L370))

## Contribution

If you want to submit a pull request, here are some requirements:

* IDE: IntelliJ IDEA
* Compiler: Java 1.8 or Java 11+
* Do NOT modify `gradle` files

### Compilation

Simply execute the following command in the project root directory:

```bash
./gradlew clean build
```

Make sure you have at least JavaFX 8 installed. Liberica Full JDK 8 or later is recommended.
