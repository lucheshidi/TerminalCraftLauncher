package org.lucheshidi.tcl.json;

// 主类，对应整个JSON结构
class Config {
    private Dirs dirs;
    private GameConfig gameConfig;

    // 构造器
    public Config(Dirs dirs, GameConfig gameConfig) {
        this.dirs = dirs;
        this.gameConfig = gameConfig;
    }

    // Getters 和 Setters
    public Dirs getDirs() {
        return dirs;
    }

    public void setDirs(Dirs dirs) {
        this.dirs = dirs;
    }

    public GameConfig getGameConfig() {
        return gameConfig;
    }

    public void setGameConfig(GameConfig gameConfig) {
        this.gameConfig = gameConfig;
    }
}

// 嵌套类，对应JSON中的"Dirs"
class Dirs {
    private String minecraftDir;
    private String javaDir;

    // 构造器
    public Dirs(String minecraftDir, String javaDir) {
        this.minecraftDir = minecraftDir;
        this.javaDir = javaDir;
    }

    // Getters 和 Setters
    public String getMinecraftDir() {
        return minecraftDir;
    }

    public void setMinecraftDir(String minecraftDir) {
        this.minecraftDir = minecraftDir;
    }

    public String getJavaDir() {
        return javaDir;
    }

    public void setJavaDir(String javaDir) {
        this.javaDir = javaDir;
    }
}

// 嵌套类，对应JSON中的"gameConfig" (目前为空，可以根据实际需求补充)
class GameConfig {
    private boolean isOpenVersionIsolation;
    private String javaLaunchArguments;

    // 构造器
    public GameConfig(boolean isOpenVersionIsolation, String javaLaunchArguments) {
        this.isOpenVersionIsolation = false;
        this.javaLaunchArguments = "";
    }

    // getters 和 setters
    public String getJavaLaunchArguments() {
        return javaLaunchArguments;
    }

    public void setJavaLaunchArguments(String javaLaunchArguments) {
        this.javaLaunchArguments = javaLaunchArguments;
    }

    public boolean getIsOpenVersionIsolation() {
        return isOpenVersionIsolation;
    }

    public void setIsOpenVersionIsolation(boolean isOpenVersionIsolation) {
        this.isOpenVersionIsolation = isOpenVersionIsolation;
    }
}