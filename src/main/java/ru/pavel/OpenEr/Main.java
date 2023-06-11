package ru.pavel.OpenEr;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import ru.pavel.OpenEr.Core.ManagementStructures.EventListener.KeyListener;
import ru.pavel.OpenEr.Core.ManagementStructures.ShortcutManager.HashtableShortcutManager;
import ru.pavel.OpenEr.Core.ManagementStructures.ShortcutManager.ShortcutManager;
import ru.pavel.OpenEr.Config.ShortcutInitializer.Initializer;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        Initializer.initialize();
        ShortcutManager manager = HashtableShortcutManager.getShortcutManager();
         try {
            GlobalScreen.registerNativeHook();
        } catch(NativeHookException e){
            System.out.println(e.getMessage());
        }
        GlobalScreen.addNativeKeyListener(new KeyListener());

    }

}