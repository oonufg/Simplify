package ru.pavel.OpenEr.Core.Persistance.ShortcutDAO;

import ru.pavel.OpenEr.Domain.Shortcut.AbstractShortcut;
import ru.pavel.OpenEr.Domain.Shortcut.Shortcut;
import java.util.ArrayList;

public interface ShortcutDAO {
    void save(Shortcut shortcut);

    ArrayList<AbstractShortcut> load();
}
