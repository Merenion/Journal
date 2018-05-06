package ru.school;

import java.util.HashSet;
import java.util.Set;

public class Class implements IClass{

    private char unit;
    private int level;
    private Set<IJournal> journals = new HashSet<IJournal>();
    private Set<IPerson> students = new HashSet<IPerson>();

    @Override
    public void addJournal(Journal journal) {

    }

    @Override
    public void removeJournal(Journal journal) {

    }

    @Override
    public Set<IPerson> getStudents() {
        return students;
    }

    @Override
    public Set<IJournal> getJournals() {
        return journals;
    }
}
