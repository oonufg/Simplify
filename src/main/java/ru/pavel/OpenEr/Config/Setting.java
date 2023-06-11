package ru.pavel.OpenEr.Config;

import java.io.File;

public class Setting {
    private static Setting setting;
    private int activationKeyVirtualCode;
    private File configFile;
    private File shortcutsFile;

    private Setting(){
    }

    public static Setting getSetting(){
        if (setting == null){
            synchronized (Setting.class){
                if (setting == null){
                    setting = new Setting();
                }
            }
        }
        return setting;
    }

    public File getShortcutsFile(){
        return this.configFile;
    }
    public void setShortcutsFile(File shortcutsFile){
        this.shortcutsFile = shortcutsFile;
    }

    public File getConfigFile(){
        return this.configFile;
    }
    public void setConfigFile(File configFile){
        this.configFile = configFile;
    }

    public int getActivationKeyVirtualCode(){
        return this.activationKeyVirtualCode;
    }
    public void setActivationKeyVirtualCode(int virtualCode){
        this.activationKeyVirtualCode = virtualCode;
    }

}
