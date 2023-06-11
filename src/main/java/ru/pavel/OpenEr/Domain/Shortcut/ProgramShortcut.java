package ru.pavel.OpenEr.Domain.Shortcut;

import java.io.IOException;

public class ProgramShortcut implements Shortcut{
    String programAddress;
    public ProgramShortcut(String programAddress){
        this.programAddress = programAddress;
    }
    public void execute() throws IOException {
        Runtime.getRuntime().exec(this.programAddress);
    }
}