package ru.pavel.OpenEr.Domain.Shortcut;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.IOException;
public class ProgramShortcut extends AbstractShortcut{

    public ProgramShortcut(){
        super();
    }
    public ProgramShortcut(String name, String discription ,String programAddress){
        this.name = name;
        this.discription = discription;
        this.programAddress = programAddress;
    }
    public void execute() throws IOException {
        Runtime.getRuntime().exec(this.programAddress);
    }
}