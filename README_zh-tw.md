# Terminal Craft Launcher

[![Static Badge](https://img.shields.io/badge/License-GPL%20v3-green)](https://www.gnu.org/licenses/gpl-3.0.html#license-text)
[![GitHub top language](https://img.shields.io/github/languages/top/lucheshidi/TerminalCraftLauncher?link=https%3A%2F%2Fgithub.com%2Flucheshidi%2FTerminalCraftLauncher)]()
[![Static Badge](https://img.shields.io/badge/Follow%20On-GitHub-black?logo=github&link=https%3A%2F%2Fgithub.com%2Flucheshidi%2FTerminalCraftLauncher.git)](https://github.com/lucheshidi)

[English](README.md) | [简体中文](README_zh-cn.md) | ***繁體中文***

> [!CAUTION]
> # 項目已停止維修！
> TCL因為太落後已經停止維護！請關注後續版本[PMCL](https://github.com/lucheshidi/pixelmclauncher)

## 目錄
- [簡介](#簡介)
- [下載](#下載)
- [手動編譯](#手動編譯)
    - [第一部分：我有 IntelliJ IDEA](#第一部分我有-intellij-idea)
    - [第二部分：我只有一個終端](#第二部分我只有一個終端)
- [維護者](#維護者)
- [貢獻](#貢獻)
- [再見！(~~搞笑~~)](#感謝-我們認為終有一天你無需在樹莓派上安裝-openjfx-也能暢玩-minecraft)
- [再見！](#感謝-我們相信-tcl-將成為暢玩-minecraft-的另一種方式)

## 簡介
終端工藝啟動器 (Terminal Craft Launcher, TCL) 是一個開源且跨平台的 Minecraft 啟動器 支持模組管理 遊戲自定義 Mod 加載器安裝（Forge NeoForge Fabric Quilt LiteLoader 和 OptiFine 等） 模組包創建 以及用戶界面自定義等功能

TCL 擁有強大的跨平台支持能力 不僅可以運行於 Windows Linux 和 macOS 系統 還支持 x86 ARM MIPS 和 LoongArch 等多種 CPU 架構 你可以使用 TCL 在不同平台上暢玩 Minecraft（前提是系統必須有圖形界面）

關於跨平台支持 點擊[這裡](PLATFORM.md)

## 下載
如果你使用 Windows 請下載 EXE 文件 如果你使用 FreeBSD Linux 或類 Unix 系統 請下載無後綴的可執行文件  
前往[此頁面](https://github.com/lucheshidi/TerminalCraftLauncher/releases)下載最新發佈版本（但目前還沒有發佈內容哦\[哭泣\]）

有時 我可能會搭建一個網站 你可以直接通過網站下載

## 手動編譯
如果你看到[這裡]() 請確認自己是開發人員 或熟悉一些計算機相關知識

接下來 我將分兩部分（或兩種情況）引導你完成構建

### 第一部分：***我有 IntelliJ IDEA***
在終端中輸入以下指令（適用 bash(Linux) zsh(macOS) cmd(Windows)）：
```bash
git clone https://github.com/lucheshidi/TerminalCraftLauncher.git
```
然後用 IntelliJ IDEA 打開這個資料夾 你會看到 4 個執行設定：

| 設定名稱         | 功能                |
|--------------|-------------------|
| :app:bootRun | 直接執行程式而不進行編譯      |
| app:build    | 編譯 Jar 檔案（我們需要用它） |
| app:install  | 為開發人員安裝插件         |
| Main         | TCL 的主程式          |

選擇 `app:build` 並執行 如果顯示綠色的 `SUCCESS` 說明你成功編譯了 Jar 檔案  
進入 `./target/` 資料夾 Jar 檔案正在這裡等著你

### 第二部分：***我只有一個終端***
在終端中輸入以下指令（適用 bash(Linux) zsh(macOS) cmd(Windows)）：
```bash
git clone https://github.com/lucheshidi/TerminalCraftLauncher.git # 克隆這個倉庫
cd TerminalCraftLauncher # 進入倉庫目錄
./mvnw clean package # 編譯 Jar 檔案（Windows 使用者可移除 `./`）
cd target # 進入 Jar 檔案所在目錄
ls # 列出當前目錄下的檔案（Windows 使用者使用 `dir`）
```
現在 你可以在當前目錄裡找到名為 `TerminalCraftLauncher-1.0-SNAPSHOT.jar` 的檔案  
如果需要編譯適用於 Linux 的可執行檔案或 Windows 的 EXE 檔案 請點擊[這裡](BUILD.md)

## 維護者
[@lucheshidi](https://github.com/lucheshidi)

## 貢獻
如果你有任何問題 或者也想參與 TCL 的開發 歡迎通過[這裡](https://github.com/lucheshidi/TerminalCraftLauncher/issues)提交 issue  
這個項目基於[GNU 通用公共許可證 (GPL)](https://www.gnu.org/licenses/gpl-3.0.html)開源 你可以查看[許可證說明](LICENSE)

## ~~感謝 我們認為終有一天你無需在樹莓派上安裝 `openjfx` 也能暢玩 Minecraft~~
## 感謝 我們相信 TCL 將成為暢玩 Minecraft 的另一種方式
