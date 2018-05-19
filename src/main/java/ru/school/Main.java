package ru.school;

import ru.school.log.FormatterForFiner;
import ru.school.log.FormatterUsers;

import java.io.File;
import java.io.IOException;
import java.util.logging.*;

public class Main {

    public static final Logger log = Logger.getLogger("Param Pam Pam");

    static {
        //обязательно добавить файл конфигурации log.properties
        //  -Djava.util.logging.config.file=........

        propertiesLoad();
        //добавление хэндлеров
        initFileConfig();
        initFileFiner();
        initConsInfo();
        log.setUseParentHandlers(false);
    }

    public static void main(String[] args) {
        School school = Serializer.getSerializer().reader(); //загружием сохранение
        Main.log.info("init program");
        ITui tui = new Tui(school);
        tui.mainSelect();
    }

    /**Загрузка файла конфигураций логера*/
    private static void propertiesLoad() {
        try {
            LogManager.getLogManager().readConfiguration();
            System.out.println("Logging Configuration File:\n" + System.getProperty("java.util.logging.config.file"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**добавление хэндлера для сохранения логов в файл с уровня Config
     * В ЭТОТ ФАЙЛ БУДУТ ЗАПИСЫВАТЬСЯ ВСЕ ДЕЙСТВЯ ПОЛЬЗОВАТЕЛЯ*/
    private static void initFileConfig() {
        try {
            Handler handler = new FileHandler("%h/desktop/LogUse.log");
            handler.setFormatter(new FormatterUsers());
            handler.setLevel(Level.CONFIG);
            log.addHandler(handler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**добавление хэндлера для сохранения логов в файл с уровня FINER
     * В ЭТОТ ФАЙЛ записывается все что только можно...*/
    private static void initFileFiner() {
        Handler handler = null;
        try {
            handler= new FileHandler("%h/desktop/LogFiner.log");
            handler.setFormatter(new FormatterForFiner());
            handler.setLevel(Level.FINER);
            log.addHandler(handler);
        } catch (IOException e) {
        }
    }

    /**вывод в консоль логи начиная с уровня finer*/
    private static void initConsFiner() {
            Handler handler = new ConsoleHandler();
            handler.setFormatter(new FormatterForFiner());
            handler.setLevel(Level.FINER);
            log.addHandler(handler);
    }

    /**вывод в консоль логи начиная с уровня info*/
    private static void initConsInfo() {
        Handler handler = new ConsoleHandler();
        handler.setFormatter(new FormatterForFiner());
        handler.setLevel(Level.INFO);
        log.addHandler(handler);
    }
}

