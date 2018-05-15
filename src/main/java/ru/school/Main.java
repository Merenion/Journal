package ru.school;

import ru.school.log.FormatterForFiner;
import ru.school.log.FormatterUsers;

import java.io.IOException;
import java.util.logging.*;

public class Main {

    public static final Logger log = Logger.getLogger("Param Pam Pam");

    static {
        propertiesLoad();
        initFileConfig();
        initFileFiner();
        initConsFiner();
        log.setUseParentHandlers(false);
    }

    public static void main(String[] args) {
        Main.log.info("init program");
        ITui tui = new Tui(new School());
        tui.mainSelect();
    }


    private static void propertiesLoad() {
        try {
            LogManager.getLogManager().readConfiguration();
            System.out.println("Logging Configuration File:\n" + System.getProperty("java.util.logging.config.file"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void initFileConfig() {
        try {
            Handler handler = new FileHandler("%h/desktop/logJournal/LogUse.log");
            handler.setFormatter(new FormatterUsers());
            handler.setLevel(Level.CONFIG);
            log.addHandler(handler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void initFileFiner() {
        Handler handler = null;
        try {
            handler= new FileHandler("%h/desktop/logJournal/LogFiner.log");
            handler.setFormatter(new FormatterForFiner());
            handler.setLevel(Level.FINER);
            log.addHandler(handler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void initConsFiner() {
            Handler handler = new ConsoleHandler();
            handler.setFormatter(new FormatterForFiner());
            handler.setLevel(Level.FINER);
            log.addHandler(handler);
    }
}

