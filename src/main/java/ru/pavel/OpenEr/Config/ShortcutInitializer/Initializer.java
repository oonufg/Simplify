package ru.pavel.OpenEr.Config.ShortcutInitializer;

import ru.pavel.OpenEr.Config.Setting;
import ru.pavel.OpenEr.Core.ManagementStructures.ShortcutManager.HashtableShortcutManager;
import ru.pavel.OpenEr.Core.ManagementStructures.ShortcutManager.ShortcutManager;
import ru.pavel.OpenEr.Domain.Shortcut.ProgramShortcut;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Initializer {
    public static void initialize() throws  FileNotFoundException{
        initializeSetting();
        initializeShortcut();
    }
    private static void initializeShortcut() throws FileNotFoundException {
        File file = new File("C:\\Users\\pyumi\\IdeaProjects\\OpenEr\\src\\main\\resources\\user.txt");
        Scanner scanner = new Scanner(file);
        ShortcutManager manager = HashtableShortcutManager.getShortcutManager();
        while(scanner.hasNextLine()){
            String[] words = scanner.nextLine().split("'");
            manager.addShortcut(words[0],new ProgramShortcut(words[1]));
        }
    }
    private static void initializeSetting(){
        Setting.getSetting().setActivationKeyVirtualCode(56);
    }
}
