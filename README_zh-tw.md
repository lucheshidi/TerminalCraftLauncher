# Terminal Craft Launcher

[![](https://img.shields.io/badge/License-GPL%20v3-green)](https://www.gnu.org/licenses/gpl-3.0.html#license-text)
[![](https://img.shields.io/github/languages/top/lucheshidi/TerminalCraftLauncher?link=https%3A%2F%2Fgithub.com%2Flucheshidi%2FTerminalCraftLauncher)]()
[![](https://img.shields.io/badge/Follow-GitHub-black?logo=github&link=https%3A%2F%2Fgithub.com%2Flucheshidi%2FTerminalCraftLauncher.git)](https://github.com/lucheshidi)

[English](README.md) | [簡體中文](README_zh-cn.md) | ***繁體中文***

## 簡介
終端工藝啟動器(Terminal Craft Launcher, TCL) 是一個開源的、跨平台的 Minecraft 啟動器，即将支持模組管理、遊戲自定義、ModLoader（例如 Forge、NeoForge、Fabric、Quilt、LiteLoader 和 OptiFine）的安裝、模組包創建、界面自定義等功能。

TCL 擁有極強的跨平台能力。不僅能夠運行於 Windows、Linux 和 macOS 等操作系統，還支持 x86、ARM、MIPS 和 LoongArch 等多種 CPU 架構。通過 TCL，您可以輕鬆跨平台暢玩 Minecraft（即使系統沒有 GUI 也可以）。

關於跨平台支持，請點擊[這裡](PLATFORM.md)。

## 下載
如果比使用 Windows 操作系統，請下載 EXE 文件；如果你使用 FreeBSD、Linux 或類 Unix 系統，請下載無後綴的可執行文件。
前往[此頁面](https://github.com/lucheshidi/TerminalCraftLauncher/releases)下載發布版本（但目前還沒有版本發布\[哭泣\]）。

有時候（我猜），我會搭建一個網站，您可以通過網站下載啟動器。

## 手動編譯
如果你看到[這裡]()，請確保自己是開發人員或具備一定的計算机相關知識。

準備好了嗎？我將分為兩個部分（或兩種情況）引導您完成構建。

### 第一部分 ***我有 IntelliJ IDEA***
在終端中輸入以下命令(適用於 bash(Linux)、zsh(macOS)、cmd(Windows))：
```bash
git clone https://github.com/lucheshidi/TerminalCraftLauncher.git
```
然後在 IntelliJ IDEA 中打開這個文件夾，你將看到 4 個運行配置。這些配置的功能各不相同：

| 配置名          | 功能                 |
|--------------|--------------------|
| :app:bootRun | 直接運行程序，不進行編譯       |
| app:build    | 構建 Jar 文件（我們需要用到它） |
| app:install  | 為開發人員安裝插件          |
| Main         | TCL 的主程序           |

選擇 `app:build` 並運行。如果出現綠色的 `SUCCESS`，那麼您已經成功構建了 Jar 文件。
前往 `./target/` 文件夾，Jar 文件正等待您開啟！

### 第二部分 ***我只有一個終端***
在終端(適用於 bash(Linux)、zsh(macOS)、cmd(Windows))中輸入以下命令：
```bash
git clone https://github.com/lucheshidi/TerminalCraftLauncher.git # 克隆此倉庫
cd TerminalCraftLauncher # 進入倉庫目錄
./mvnw clean package # 構建 Jar 文件 (Windows 系統無需輸入"./")
cd target # 進入 Jar 文件所在目錄
ls # 顯示該目錄下的所有文件 (Windows 系統請用 "dir")
```
現在，你可以在這個文件夾中看到名為 `TerminalCraftLauncher-1.0-SNAPSHOT.jar` 的文件。
我想您應該知道如何使用這個 Jar 文件了。如果你想構建適用於 Linux 的可執行文件或 Windows 的 EXE 文件，請點擊[這裡](BUILD.md)。

##