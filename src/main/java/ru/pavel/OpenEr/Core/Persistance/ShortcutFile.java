package ru.pavel.OpenEr.Core.Persistance;


import ru.pavel.OpenEr.Config.Setting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ShortcutFile {
    public void save(String stringToSave){
        try {
            FileWriter writer = new FileWriter(Setting.getSetting().getShortcutsFile(),true);
            writer.write("\n" + stringToSave);
            writer.flush();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    public ArrayList<String> getStringsFromFile(){
        ArrayList<String> strings = new ArrayList<String>();
        try{
            String line;
            BufferedReader reader = new BufferedReader(new FileReader(Setting.getSetting().getShortcutsFile()));
            while((line = reader.readLine()) != null){
                System.out.println(line);
                strings.add(line);
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        return strings;
    }
}
