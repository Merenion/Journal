package ru.school;

import java.util.Scanner;

public class Tui {

    ICreator creator = new CreatorDefault();
    ISchool school = creator.createSchool();



    void mainSelect(String line) {
        String[] arrayLine = line.split("\"");
        switch (arrayLine[0]) {
            case "create new school":
                school = creator.createSchool();
                break;
            case "add class ":
                school.addClass(creator.createClass(arrayLine[1], Integer.parseInt(arrayLine[2])));
                break;
            case "remove class ":
                school.removeClass(arrayLine[1], Integer.parseInt(arrayLine[2]));
                break;
            case "add journal ":
                IClass aClass = school.getClass()
                break;
            case "remove journal ":
                break;
            case "add student ":
                break;
            case "remove student ":
                break;
            case "add rating ":
                break;
            case "remove rating ":
                break;

        }
    }

    void controlClass (String unit, int level) {
        String line = (new Scanner(System.in)).nextLine();
        String[] arrayLine = line.split("\"");
        IClass aClass = school.getClass(unit,level);


    }
}
