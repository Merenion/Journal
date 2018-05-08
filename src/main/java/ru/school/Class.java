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
    public void addJournal(Journal journal) {

    }

    @Override
    public void removeJournal(Journal journal) {

    }

    @Override
    public void addStudent(IPerson person) {

    }

    @Override
    public void removeStudent(IPerson person) {

    }

    @Override
    public Set<IPerson> getStudents() {
        return null;
    }

    @Override
    public Set<IJournal> getJournals() {
        return null;
    }

    @Override
    public IPerson getPerson(String name) {
        return null;
    }

    @Override
    public IPerson getJurnal(String subject) {
        return null;
    }

    @Override
    public void setBoss(IPerson boss) {

    }

    @Override
    public Boss getBoss() {
        return null;
    }

    @Override
    public String toString() {
        return "Class{" +
                "letter=" + letter +
                ", level=" + level +
                '}';
    }
}
