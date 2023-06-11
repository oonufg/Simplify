package ru.pavel.OpenEr.Core.ManagementStructures.ShortcutManager;

import ru.pavel.OpenEr.Domain.Shortcut.Shortcut;

public interface ShortcutManager {

    boolean isExist(String command);
    Shortcut getShortcut(String command);
    void addShortcut(String command, Shortcut shortcut);
    void deleteShortcut(String command);

}
