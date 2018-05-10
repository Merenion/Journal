package ru.school;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;

public class Tui {


    private final String ANSI_YELLOW = "\u001B[33m";
    private final String ANSI_RESET = "\u001B[0m";

    ICreator creator = new CreatorDefault();
    ISchool school = creator.createSchool();


    void mainSelect() {
        String line = (new Scanner(System.in)).nextLine();
        String[] arrayLine = line.split("\"");
        switch (arrayLine[0]) {
            case "create new school":
                school = creator.createSchool();
                break;
            case "control classes":
                controlClasses();
                break;
            case "control persons ":
                controlPersons(arrayLine[1], Integer.parseInt(arrayLine[2]));
                break;
            case "control journals ":
                controlJournals(arrayLine[1], Integer.parseInt(arrayLine[2]));
                break;
            case "control rating ":
                controlRating(arrayLine[1], Integer.parseInt(arrayLine[2]),arrayLine[3]);
                break;
            case "help":
                System.out.println(getHelpFromFile(new File("src/main/resources/helpMainSelect.txt")));
            default:
                System.out.println(ANSI_YELLOW + "Неверная команда!" + ANSI_RESET);
                mainSelect();
                break;
        }
        mainSelect();
    }

    void controlClasses() {
        String line = (new Scanner(System.in)).nextLine();
        String[] arrayLine = line.split("\"");
        switch (arrayLine[0]) {
            case "add class ":
                school.addClass(creator.createClass(arrayLine[1], Integer.parseInt(arrayLine[2])));
                break;
            case "remove class ":
                school.removeClass(arrayLine[1], Integer.parseInt(arrayLine[2]));
                break;
            case "show list classes":
                System.out.println(school.getListClasses());
                break;
            case "back":
                System.out.println("Done (return)");
                return;
            default:
                System.out.println(ANSI_YELLOW + "Неверная команда!" + ANSI_RESET);
                controlClasses();
                break;
        }
        controlClasses();
    }

    void controlPersons(String letter, int level) {
        if (school.getClass(letter, level) == null) return;
        IClass aClass = school.getClass(letter, level);
        String line = (new Scanner(System.in)).nextLine();
        String[] arrayLine = line.split("\"");
        switch (arrayLine[0]) {
            case "add student ":
                aClass.addStudent(creator.createStudent(arrayLine[1],aClass));
                break;
            case "remove student ":
                aClass.removeStudent(arrayLine[1]);
                break;
            case "set boss ":
                aClass.setBoss(creator.createBoss(arrayLine[1],aClass));
                break;
            case "show list persons":
                System.out.println(aClass);
                System.out.println(aClass.getListPerson());
                break;
            case "back":
                System.out.println("Done (return)");
                return;
            default:
                System.out.println(ANSI_YELLOW + "Неверная команда!" + ANSI_RESET);
                controlPersons(letter, level);
                break;
        }
        controlPersons(letter, level);
    }

    void controlJournals(String letter, int level) {
        if (school.getClass(letter, level) == null) return;
        IClass aClass = school.getClass(letter, level);
        String line = (new Scanner(System.in)).nextLine();
        String[] arrayLine = line.split("\"");
        switch (arrayLine[0]) {
            case "add journal ":
                aClass.addJournal(creator.createJournal(arrayLine[1],aClass));
                break;
            case "remove journal ":
                aClass.removeJournal(arrayLine[1]);
                break;
            case "show list journal":
                System.out.println(aClass);
                System.out.println(aClass.getListJournal());
                break;
            case "back":
                System.out.println("Done (return)");
                return;
            default:
                System.out.println(ANSI_YELLOW + "Неверный команда!" + ANSI_RESET);
                controlJournals(letter, level);
                break;
        }
        controlPersons(letter, level);
    }

    void controlRating(String letter, int level, String nameSubject) {
        if (school.getClass(letter, level) == null) return;
        if (school.getClass(letter, level).getJournal(nameSubject) == null) return;
        String line = (new Scanner(System.in)).nextLine();
        String[] arrayLine = line.split("\"");
        IClass aClass = school.getClass(letter, level);
        IJournal journal = aClass.getJournal(nameSubject);
        switch (arrayLine[0]) {
            case "add rating ":
                Calendar calendar = Calendar.getInstance();
                calendar.set(Integer.parseInt(arrayLine[3]),Integer.parseInt(arrayLine[4]),Integer.parseInt(arrayLine[5]));
                journal.addRating(aClass.getPerson(arrayLine[1]),Integer.parseInt(arrayLine[2]),calendar.getTime());
                break;
            case "remove rating ":
                break;
            case "show list rating ":
                break;
            case "back":
                return;
            default:
                System.out.println(ANSI_YELLOW + "Неверный команда!" + ANSI_RESET);
                controlRating(letter, level, nameSubject);
                break;
        }
        controlRating(letter, level, nameSubject);
    }

    private String getHelpFromFile(File file){
        StringBuilder text= new StringBuilder("");
        try {
            Scanner scanner = new Scanner(file);
            do {
                text.append(scanner.nextLine()).append("\n");
            }while (scanner.hasNext());
        } catch (FileNotFoundException e) {
            System.out.println("файл с информацией пуст");
            //e.printStackTrace();
        }
        return text.toString();
    }


}

