package ru.school;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Tui implements ITui {

    private final String ANSI_YELLOW = "\u001B[33m";
    private final String ANSI_RESET = "\u001B[0m";

    private ICreator creator = new CreatorDefault();
    private ISchool school;

    public Tui(ISchool school) {
        this.school = school;
    }

    @Override
    public ISchool getSchool() {
        return school;
    }

    @Override
    public void setSchool(ISchool school) {
        this.school = school;
    }

    @Override
    public synchronized void mainSelect() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] arrayLine = line.split("\"");
        switch (arrayLine[0]) {
            case "create new school":
                Main.log.config("User создает новую школу");
                school = creator.createSchool();
                System.out.println("!Done");
                break;
            case "control classes":
                System.out.println("!Done");
                controlClasses();
                scanner.close();
                break;
            case "control persons ":
                System.out.println("!Done");
                controlPersons(arrayLine[1], parseInt(arrayLine[2]));
                break;
            case "control journals ":
                System.out.println("!Done");
                controlJournals(arrayLine[1], parseInt(arrayLine[2]));
                break;
            case "control rating ":
                System.out.println("!Done");
                controlRating(arrayLine[1], parseInt(arrayLine[2]), arrayLine[3]);
                break;
            case "help":
                System.out.println(ANSI_YELLOW + getHelpFromFile(new File("src/main/resources/helpMainSelect.txt")) + ANSI_RESET);
                break;
            default:
                System.out.println(ANSI_YELLOW + "Неверная команда!" + ANSI_RESET);
                mainSelect();
                break;
        }
        mainSelect();
    }

    @Override
    public synchronized void controlClasses() {
        Scanner scanner = new Scanner(System.in);
        scanner.
        String line = scanner.nextLine();
        String[] arrayLine = line.split("\"");
        switch (arrayLine[0]) {
            case "add class ":
                Main.log.config("User добавляет новый класс - " + arrayLine[2] + arrayLine[1]);
                school.addClass(creator.createClass(arrayLine[1], parseInt(arrayLine[2])));
                break;
            case "remove class ":
                Main.log.config("User удаляет класс " + arrayLine[2] + arrayLine[1]);
                school.removeClass(arrayLine[1], parseInt(arrayLine[2]));
                break;
            case "show list classes":
                Main.log.config("User просматривает список классов");
                System.out.println(school.getListClasses());
                break;
            case "back":
                System.out.println("Done (return)");
                scanner.close();
                return;
            case "help":
                System.out.println(ANSI_YELLOW + getHelpFromFile(new File("src/main/resources/helpControlClasses.txt")) + ANSI_RESET);
                break;
            default:
                System.out.println(ANSI_YELLOW + "Неверная команда!" + ANSI_RESET);
                controlClasses();
                break;
        }
        controlClasses();
    }

    @Override
    public void controlPersons(String letter, int level) {
        if (school.getClass(letter, level) == null) {
            Main.log.warning("Класс с заданной буквой и уровнем не найден.");
            return;
        }
        IClass aClass = school.getClass(letter, level);
        String line = (new Scanner(System.in)).nextLine();
        String[] arrayLine = line.split("\"");
        switch (arrayLine[0]) {
            case "add student ":
                Main.log.config("User добавляет нового студента - " + arrayLine[1] + " " + aClass);
                aClass.addStudent(creator.createStudent(arrayLine[1], aClass));
                break;
            case "remove student ":
                Main.log.config("User удаляет студента - " + arrayLine[1] + " " + aClass);
                aClass.removeStudent(arrayLine[1]);
                break;
            case "set boss ":
                Main.log.config("User задает классного руководителя - " + arrayLine[1] + " " + aClass);
                aClass.setBoss(creator.createBoss(arrayLine[1], aClass));
                break;
            case "show list persons":
                Main.log.config("User просматривает список студентов и классного руководителя." + " " + aClass);
                System.out.println(aClass);
                System.out.println(aClass.getListPerson());
                break;
            case "help":
                System.out.println(ANSI_YELLOW + getHelpFromFile(new File("src/main/resources/helpСontrolPersons.txt")) + ANSI_RESET);
                break;
            case "back":
                System.out.println("Done (return)");
                return; //gjghj,jdfnm gjtyznm yf vtnjl!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            default:
                System.out.println(ANSI_YELLOW + "Неверная команда!" + ANSI_RESET);
                controlPersons(letter, level);
                break;
        }
        controlPersons(letter, level);
    }

    @Override
    public void controlJournals(String letter, int level) {
        if (school.getClass(letter, level) == null) {
            Main.log.warning("Класс с заданной буквой и уровнем не найден.");
            return;
        }
        IClass aClass = school.getClass(letter, level);
        String line = (new Scanner(System.in)).nextLine();
        String[] arrayLine = line.split("\"");
        switch (arrayLine[0]) {
            case "add journal ":
                Main.log.config("User добавляет журнал по предмету " + arrayLine[1] + " " + aClass);
                aClass.addJournal(creator.createJournal(arrayLine[1], aClass));
                break;
            case "remove journal ":
                Main.log.config("User удаляет журнал по предмету " + arrayLine[1] + " " + aClass);
                aClass.removeJournal(arrayLine[1]);
                break;
            case "show list journal":
                Main.log.config("User просматривает список журналов " + aClass);
                System.out.println(aClass);
                System.out.println(aClass.getListJournal());
                break;
            case "back":
                System.out.println("Done (return)");
                return;
            case "help":
                System.out.println(ANSI_YELLOW + getHelpFromFile(new File("src/main/resources/helpСontrolJournals.txt")) + ANSI_RESET);
                break;
            default:
                System.out.println(ANSI_YELLOW + "Неверный команда!" + ANSI_RESET);
                controlJournals(letter, level);
                break;
        }
        controlPersons(letter, level);
    }

    @Override
    public void controlRating(String letter, int level, String nameSubject) {
        if (school.getClass(letter, level) == null) {
            Main.log.warning("Класс с заданной буквой и уровнем не найден.");
            return;
        }
        if (school.getClass(letter, level).getJournal(nameSubject) == null) {
            Main.log.warning("Заданный предмет не найден");
            return;
        }
        String line = (new Scanner(System.in)).nextLine();
        String[] arrayLine = line.split("\"");
        IClass aClass = school.getClass(letter, level);
        IJournal journal = aClass.getJournal(nameSubject);
        switch (arrayLine[0]) {
            case "add rating ":
                Main.log.config("User добавляет оценку " + arrayLine[2] + " персонажу " + arrayLine[1]
                        + aClass + ". Дата оценки " + arrayLine[3] + "." + arrayLine[4] + "." + arrayLine[5]);
                Calendar calendar = Calendar.getInstance();
                calendar.set(parseInt(arrayLine[3]), parseInt(arrayLine[4]), parseInt(arrayLine[5]));
                IPerson person = aClass.getPerson(arrayLine[1]);
                Rating rating = null;
                for (Rating.ValueRating ratings : Rating.ValueRating.values()) {
                    if (ratings.equals(arrayLine[2]))
                        rating = creator.createRating(ratings, calendar.getTime(), person);
                }
                journal.addRating(rating);
                break;
            case "remove rating ":
                Main.log.config("User удаляет оценку студента " + arrayLine[1]
                        + aClass + " которая была поставленна " + arrayLine[2] + "." + arrayLine[3] + "." + arrayLine[4]);
                Calendar calendar1 = Calendar.getInstance();
                calendar1.set(parseInt(arrayLine[2]), parseInt(arrayLine[3]), parseInt(arrayLine[4]));
                IPerson person1 = aClass.getPerson(arrayLine[1]);
                journal.deleteRating(person1, (Data) calendar1.getTime());
                break;
            case "show list rating ":
                Main.log.config("User просматривает оценки персонажа " + arrayLine[1] + " " + aClass);
                IPerson person2 = aClass.getPerson(arrayLine[1]);
                System.out.println(aClass);
                System.out.println(person2);
                System.out.println(journal.getListRatings(person2));
                break;
            case "help":
                System.out.println(ANSI_YELLOW + getHelpFromFile(new File("src/main/resources/helpСontrolRating.txt")) + ANSI_RESET);
                break;
            case "back":
                System.out.println("Done (return)");
                return;
            default:
                System.out.println(ANSI_YELLOW + "Неверный команда!" + ANSI_RESET);
                controlRating(letter, level, nameSubject);
                break;
        }
        controlRating(letter, level, nameSubject);
    }

    private String getHelpFromFile(File file) {
        StringBuilder text = new StringBuilder("");
        try {
            Scanner scanner = new Scanner(file);
            do {
                text.append(scanner.nextLine()).append("\n");
            } while (scanner.hasNext());
        } catch (FileNotFoundException e) {
            Main.log.warning("Файл с help информацией не найден.");
            //e.printStackTrace();
        }
        return text.toString();
    }


}

