package ru.pavel.OpenEr.Core.Persistance.ShortcutDAO;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.pavel.OpenEr.Core.Persistance.ShortcutFile;
import ru.pavel.OpenEr.Domain.Shortcut.AbstractShortcut;
import ru.pavel.OpenEr.Domain.Shortcut.ProgramShortcut;
import ru.pavel.OpenEr.Domain.Shortcut.Shortcut;
import java.io.IOException;
import java.util.ArrayList;

public class ShortcutJSONFormat implements ShortcutDAO{
    private ShortcutFile shortcutFile;
    private ObjectMapper objectMapper;

    public ShortcutJSONFormat(){
        this.shortcutFile = ShortcutFile.getShortcutFile();
        this.objectMapper = new ObjectMapper();
        this.objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    }
    @Override
    public void save(Shortcut shortcut) {
        try {
            this.shortcutFile.save(this.objectMapper.writeValueAsString(shortcut));
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public ArrayList<AbstractShortcut> load() {
        ArrayList<AbstractShortcut> shortcuts = new ArrayList<AbstractShortcut>();
        ArrayList<String> shortcutStrings = this.shortcutFile.getStringsFromFile();
        for(String shortcutStr: shortcutStrings){
            try {
                AbstractShortcut shortcut = this.objectMapper.readValue(shortcutStr, ProgramShortcut.class);
                shortcuts.add(shortcut);
            }catch(JsonProcessingException e){
                System.out.println(e.getMessage());
            }

        }
        return shortcuts;
    }
}
