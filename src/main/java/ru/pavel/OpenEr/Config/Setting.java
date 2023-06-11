package ru.pavel.OpenEr.Config;

public class Setting {
    private int activationKeyVirtualCode;
    private Setting setting;

    private Setting(){

    }
    public Setting getSetting(){
        if (this.setting == null){
            synchronized (Setting.class){
                if (this.setting == null){
                    this.setting = new Setting();
                }
            }
        }
        return this.setting;
    }
    public int getActivationKeyVirtualCode(){
        return this.activationKeyVirtualCode;
    }
    public void setActivationKeyVirtualCode(int virtualCode){
        this.activationKeyVirtualCode = virtualCode;
    }

}
