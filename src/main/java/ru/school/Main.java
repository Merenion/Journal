package ru.school;

public class Main {
    public static void main(String[] args) {
        ISchool school = new School();
        school.addClass(new Class());
    }
}
