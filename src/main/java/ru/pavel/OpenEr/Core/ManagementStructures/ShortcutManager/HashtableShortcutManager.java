package ru.pavel.OpenEr.Core.ManagementStructures.ShortcutManager;

import ru.pavel.OpenEr.Domain.Shortcut.Shortcut;
import java.util.Hashtable;

public class HashtableShortcutManager implements ShortcutManager{
    private Hashtable<String, Shortcut> shortcuts;
    private static  ShortcutManager manager;
    private HashtableShortcutManager(){
        this.shortcuts = new Hashtable<>();
    }


    public static ShortcutManager getShortcutManager() {
        if (manager == null) {
            synchronized (HashtableShortcutManager.class) {
                if (manager == null) {
                    manager = new HashtableShortcutManager();
                }
            }
        }
        return manager;
    }

    @Override
    public boolean isExist(String command){
        return this.shortcuts.containsKey(command);
    }
    @Override
    public Shortcut getShortcut(String command){
        return this.shortcuts.get(command);
    }
    @Override
    public void addShortcut(String command,Shortcut shortcut){
        this.shortcuts.put(command,shortcut);
    }

    @Override
    public void deleteShortcut(String command) {
        this.shortcuts.remove(command);
    }
}
