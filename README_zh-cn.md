# Terminal Craft Launcher

[![Static Badge](https://img.shields.io/badge/License-GPL%20v3-green)](https://www.gnu.org/licenses/gpl-3.0.html#license-text)
[![GitHub top language](https://img.shields.io/github/languages/top/lucheshidi/TerminalCraftLauncher?link=https%3A%2F%2Fgithub.com%2Flucheshidi%2FTerminalCraftLauncher)]()
[![Static Badge](https://img.shields.io/badge/Follow%20On-GitHub-black?logo=github&link=https%3A%2F%2Fgithub.com%2Flucheshidi%2FTerminalCraftLauncher.git)](https://github.com/lucheshidi)

[English](README.md) | ***简体中文*** | [繁體中文](README_zh-tw.md)

## 目录
- [简介](#简介)
- [下载](#下载)
- [手动编译](#手动编译)
    - [第一部分：我有 IntelliJ IDEA](#第一部分我有-intellij-idea)
    - [第二部分：我只有一个终端](#第二部分我只有一个终端)
- [维护者](#维护者)
- [贡献](#贡献)
- [再见！(~~搞笑~~)](#感谢-我们认为终有一天你无需在树莓派上安装-openjfx-也能畅玩-minecraft)
- [再见！](#感谢-我们相信-tcl-将成为畅玩-minecraft-的另一种方式)

## 简介
终端工艺启动器 (Terminal Craft Launcher, TCL) 是一个开源且跨平台的 Minecraft 启动器 支持模组管理 游戏自定义 Mod 加载器安装（Forge NeoForge Fabric Quilt LiteLoader 和 OptiFine 等） 模组包创建 以及用户界面自定义等功能

TCL 拥有强大的跨平台支持能力 不仅可以运行于 Windows Linux 和 macOS 系统 还支持 x86 ARM MIPS 和 LoongArch 等多种 CPU 架构 你可以使用 TCL 在不同平台上畅玩 Minecraft（前提是系统必须有图形界面）

关于跨平台支持 点击[这里](PLATFORM.md)

## 下载
如果你使用 Windows 请下载 EXE 文件 如果你使用 FreeBSD Linux 或类 Unix 系统 请下载无后缀的可执行文件  
前往[此页面](https://github.com/lucheshidi/TerminalCraftLauncher/releases)下载最新发布版本（但目前还没有发布内容哦\[哭泣\]）

有时 我可能会搭建一个网站 你可以直接通过网站下载

## 手动编译
如果你看到[这里]() 请确认自己是开发人员 或熟悉一些计算机相关知识

现在 我将分两部分（或两种情况）引导你完成构建

### 第一部分：***我有 IntelliJ IDEA***
在终端中输入以下命令（适用 bash(Linux) zsh(macOS) cmd(Windows)）：
```bash
git clone https://github.com/lucheshidi/TerminalCraftLauncher.git
```
接着用 IntelliJ IDEA 打开这个文件夹 你会看到 4 个运行配置：

| 配置名称         | 功能                |
|--------------|-------------------|
| :app:bootRun | 直接运行程序而不进行编译      |
| app:build    | 编译 Jar 文件（我们需要用它） |
| app:install  | 为开发人员安装插件         |
| Main         | TCL 的主程序          |

选择 `app:build` 并运行 如果显示绿色的 `SUCCESS` 说明你成功构建了 Jar 文件  
进入 `./target/` 文件夹 Jar 文件就在这里等着你啦

### 第二部分：***我只有一个终端***
在终端中输入以下命令（适用 bash(Linux) zsh(macOS) cmd(Windows)）：
```bash
git clone https://github.com/lucheshidi/TerminalCraftLauncher.git # 克隆这个仓库
cd TerminalCraftLauncher # 进入仓库目录
./mvnw clean package # 构建 Jar 文件（Windows 用户可移除 `./`）
cd target # 进入 Jar 文件所在目录
ls # 列出当前目录下的文件（Windows 用户使用 `dir`）
```
现在 你可以在当前目录里找到名为 `TerminalCraftLauncher-1.0-SNAPSHOT.jar` 的文件  
如果需要构建适用于 Linux 的可执行文件或 Windows 的 EXE 文件 请点击[这里](BUILD.md)

## 维护者
[@lucheshidi](https://github.com/lucheshidi)

## 贡献
如果你有任何问题 或者也想参与 TCL 的开发 欢迎通过[这里](https://github.com/lucheshidi/TerminalCraftLauncher/issues)提交 issue  
这个项目基于[GNU 通用公共许可证 (GPL)](https://www.gnu.org/licenses/gpl-3.0.html)开源 你可以查看[许可证说明](LICENSE)

## ~~感谢 我们认为终有一天你无需在树莓派上安装 `openjfx` 也能畅玩 Minecraft~~
## 感谢 我们相信 TCL 将成为畅玩 Minecraft 的另一种方式