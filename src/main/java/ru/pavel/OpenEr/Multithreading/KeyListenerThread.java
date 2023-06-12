package ru.pavel.OpenEr.Multithreading;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import ru.pavel.OpenEr.Core.ManagementStructures.EventListener.KeyListener;

public class KeyListenerThread implements Runnable{
    @Override
    public void run() {
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException e) {
            System.out.println(e.getMessage());
        }
        GlobalScreen.addNativeKeyListener(new KeyListener());
    }
}
