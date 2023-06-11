package ru.pavel.OpenEr.Config;

public class Setting {
    private int activationKeyVirtualCode;
    private static Setting setting;

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
    public int getActivationKeyVirtualCode(){
        return this.activationKeyVirtualCode;
    }
    public void setActivationKeyVirtualCode(int virtualCode){
        this.activationKeyVirtualCode = virtualCode;
    }

}
