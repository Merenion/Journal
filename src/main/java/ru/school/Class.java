package ru.school;

import java.util.HashSet;
import java.util.Set;

public class Class implements IClass {

    private String letter;
    private int level;
    private IPerson boss;
    private Set<IJournal> journals = new HashSet<IJournal>();
    private Set<IPerson> students = new HashSet<IPerson>();


    public Class(String letter, int level) {
        this.letter = letter;
        this.level = level;
    }

    @Override
    public void addJournal(IJournal journal) {
        Main.log.finer("Use method");
    }

    @Override
    public void removeJournal(String nameSubject) {
        Main.log.finer("Use method");
    }

    @Override
    public void addStudent(IPerson person) {
        Main.log.finer("Use method");
    }

    @Override
    public void removeStudent(String name) {
        Main.log.finer("Use method");
    }

    @Override
    public Set<IPerson> getStudents() {
        Main.log.finer("Use method");
        return null;
    }

    @Override
    public Set<IJournal> getJournals() {
        Main.log.finer("Use method");
        return null;
    }

    @Override
    public IPerson getPerson(String name) {
        Main.log.finer("Use method");
        return null;
    }

    @Override
    public IJournal getJournal(String subject) {
        Main.log.finer("Use method");
        return null;
    }

    @Override
    public void setBoss(IPerson boss) {
        Main.log.finer("Use method");
    }

    @Override
    public Boss getBoss() {
        Main.log.finer("Use method");
        return null;
    }

    @Override
    public String getListPerson() {
        Main.log.finer("Use method");
        return null;
    }

    @Override
    public String getListJournal() {
        Main.log.finer("Use method");
        return null;
    }

    @Override
    public String toString() {
        return "[" +
                "letter=" + letter +
                ", level=" + level +
                ']';
    }
}
