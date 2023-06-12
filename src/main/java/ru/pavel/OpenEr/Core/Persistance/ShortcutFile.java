package ru.pavel.OpenEr.Core.Persistance;


import ru.pavel.OpenEr.Config.Setting;

import java.io.*;
import java.util.ArrayList;

public class ShortcutFile {

    private static ShortcutFile shortcutFile;
    private File file;

    public static ShortcutFile getShortcutFile(){
        if (shortcutFile == null){
            synchronized (ShortcutFile.class){
                if(shortcutFile == null){
                    shortcutFile = new ShortcutFile();
                }
            }
        }
        return shortcutFile;
    }

    private ShortcutFile(){
        this.file = Setting.getSetting().getShortcutsFile();
    }

    public void save(String stringToSave){
        try {
            FileWriter writer = new FileWriter(this.file,true);
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
            BufferedReader reader = new BufferedReader(new FileReader(this.file));
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
