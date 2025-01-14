# Terminal Craft Launcher

[![](https://img.shields.io/badge/License-GPL%20v3-green)](https://www.gnu.org/licenses/gpl-3.0.html#license-text)
[![](https://img.shields.io/github/languages/top/lucheshidi/TerminalCraftLauncher?link=https%3A%2F%2Fgithub.com%2Flucheshidi%2FTerminalCraftLauncher)]()
[![](https://img.shields.io/badge/Follow-GitHub-black?logo=github&link=https%3A%2F%2Fgithub.com%2Flucheshidi%2FTerminalCraftLauncher.git)](https://github.com/lucheshidi)

[English](README.md) | ***简体中文*** | [繁体中文](README_zh-tw.md)

## 简介
终端工艺启动器(Terminal Craft Launcher, TCL) 是一个开源的、跨平台的 Minecraft 启动器，即将支持模组管理、游戏自定义、ModLoader（例如 Forge、NeoForge、Fabric、Quilt、LiteLoader 和 OptiFine）的安装、模组包创建、界面自定义等功能

TCL 拥有极强的跨平台能力。不仅能够运行于 Windows、Linux 和 macOS 等操作系统，还支持 x86、ARM、MIPS 和 LoongArch 等多种 CPU 架构。通过 TCL，您可以轻松跨平台畅玩 Minecraft（即使系统没有 GUI 也可以）

关于跨平台支持，请点击[这里](PLATFORM.md)

## 下载
如果你使用 Windows 操作系统，请下载 EXE 文件；如果你使用 FreeBSD、Linux 或类 Unix 系统，请下载无后缀的可执行文件
前往[此页面](https://github.com/lucheshidi/TerminalCraftLauncher/releases)下载发布版本（但目前还没有版本发布\[哭泣\]）

有时候（我猜），我会搭建一个网站，你可以通过网站下载启动器

## 手动编译
如果您看到[这里]()，请确保自己是开发人员或具备一定的计算机相关知识

准备好了吗？我将分为两部分（或两种情况）引导您完成构建

### 第一部分 ***我有 IntelliJ IDEA***
在终端中输入以下命令(适用于 bash(Linux)、zsh(macOS)、cmd(Windows))：
```bash
git clone https://github.com/lucheshidi/TerminalCraftLauncher.git
```
然后在 IntelliJ IDEA 中打开这个文件夹，你会看到 4 个运行配置。这些配置的功能各不相同：

| 配置名          | 功能                 |
|--------------|--------------------|
| :app:bootRun | 直接运行程序，不进行编译       |
| app:build    | 构建 Jar 文件（我们需要用到它) |
| app:install  | 为开发人员安装插件          |
| Main         | TCL 的主程序           |

选择 `app:build` 并运行。如果出现绿色的 `SUCCESS`，那么您已经成功构建了 Jar 文件
进入 `./target/` 文件夹，Jar 文件正等待你打开！

### 第二部分 ***我只有一个终端***
在终端(适用于 bash(Linux)、zsh(macOS)、cmd(Windows))中输入以下命令：
```bash
git clone https://github.com/lucheshidi/TerminalCraftLauncher.git # 克隆此仓库
cd TerminalCraftLauncher # 进入仓库目录
./mvnw clean package # 构建 Jar 文件 (Windows 系统无需输入"./")
cd target # 进入 Jar 文件所在目录
ls # 显示该目录下的所有文件 (Windows 系统请用 "dir")
```
现在，你可以在这个文件夹中看到名为 `TerminalCraftLauncher-1.0-SNAPSHOT.jar` 的文件
我想您应该知道如何使用这个 Jar 文件了。如果你想构建适用于 Linux 的可执行文件或 Windows 的 EXE 文件，请点击[这里](BUILD.md)

##