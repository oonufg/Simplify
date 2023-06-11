package ru.pavel.OpenEr.Core.ManagementStructures.EventListener;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import ru.pavel.OpenEr.Core.ManagementStructures.ShortcutManager.HashtableShortcutManager;
import ru.pavel.OpenEr.Core.ManagementStructures.ShortcutManager.ShortcutManager;

import java.io.IOException;

public class KeyListener implements NativeKeyListener{
    ShortcutManager manager = HashtableShortcutManager.getShortcutManager();
    private String word = "";
    private boolean readyToRead = false;
    @Override
    public void nativeKeyTyped(NativeKeyEvent event) {

    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent event) {
        if(this.readyToRead){
            this.word += NativeKeyEvent.getKeyText(event.getKeyCode());
        }
        if(event.getKeyCode() == 56){
            this.readyToRead = true;
        }
    }


    @Override
    public void nativeKeyReleased(NativeKeyEvent event)  {
        if (event.getKeyCode() == 56) {
            this.readyToRead = false;
            if (this.manager.isExist(this.word.toLowerCase())) {
                try {

                    this.manager.getShortcut(this.word.toLowerCase()).execute();
                }catch(IOException e){
                }
            }
            this.word = "";
        }
    }
}
