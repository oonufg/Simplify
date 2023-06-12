package ru.pavel.OpenEr.Domain.Shortcut;

public abstract class AbstractShortcut implements Shortcut{
    protected String name;
    protected String discription;
    protected String command;

    protected String programAddress;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getProgramAddress() {
        return programAddress;
    }

    public void setProgramAddress(String programAddress) {
        this.programAddress = programAddress;
    }
}
