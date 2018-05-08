package ru.school;

import java.util.HashSet;
import java.util.Set;

public class Class implements IClass{

    private char unit;
    private int level;
    private Set<IJournal> journals = new HashSet<IJournal>();
    private Set<IPerson> students = new HashSet<IPerson>();

    public Class(char unit, int level) {
        this.unit = unit;
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
    public String toString() {
        return "Class{" +
                "unit=" + unit +
                ", level=" + level +
                '}';
    }
}
