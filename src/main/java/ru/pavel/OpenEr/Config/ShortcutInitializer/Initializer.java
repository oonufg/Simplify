package ru.pavel.OpenEr.Config.ShortcutInitializer;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import ru.pavel.OpenEr.Config.Setting;
import ru.pavel.OpenEr.Core.ManagementStructures.EventListener.KeyListener;
import ru.pavel.OpenEr.Core.ManagementStructures.ShortcutManager.HashtableShortcutManager;
import ru.pavel.OpenEr.Core.ManagementStructures.ShortcutManager.ShortcutManager;
import ru.pavel.OpenEr.Core.Persistance.ShortcutDAO.ShortcutDAO;
import ru.pavel.OpenEr.Core.Persistance.ShortcutDAO.ShortcutJSONFormat;
import ru.pavel.OpenEr.Domain.Shortcut.AbstractShortcut;
import ru.pavel.OpenEr.Multithreading.KeyListenerThread;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Initializer {
    public static void initialize() throws  FileNotFoundException{
        initializeSetting();
        initializeShortcut();
        initializeService();
    }
    private static void initializeShortcut() throws FileNotFoundException {
        ShortcutDAO shortcutDAO = new ShortcutJSONFormat();
        ShortcutManager manager = HashtableShortcutManager.getShortcutManager();
        ArrayList<AbstractShortcut> shortcuts = shortcutDAO.load();
        for(AbstractShortcut shortcut: shortcuts){
            manager.addShortcut(shortcut.getCommand(),shortcut);
        }

    }
    private static void initializeSetting(){
        
        Setting setting = Setting.getSetting();
        setting.setActivationKeyVirtualCode(56);
        setting.setShortcutsFile(new File("C:\\Users\\pyumi\\IdeaProjects\\OpenEr\\src\\main\\resources\\shortcuts.json"));
    }

    private static void initializeService(){
        Thread keyListenerThread = new Thread(new KeyListenerThread());
        keyListenerThread.start();
    }
    private static void initializeKeyListener(){
        try {
            GlobalScreen.registerNativeHook();
        } catch(NativeHookException e){
            System.out.println(e.getMessage());
        }
        GlobalScreen.addNativeKeyListener(new KeyListener());
    }

}
