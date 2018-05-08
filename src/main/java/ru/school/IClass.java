package ru.school;

import java.util.Set;

public interface IClass {

    void addJournal (Journal journal);
    void removeJournal (Journal journal);
    void addStudent (IPerson person);
    void removeStudent (IPerson person);
    Set<IPerson> getStudents();
    Set<IJournal> getJournals();
    IPerson getPerson (String name);
    IPerson getJurnal (String subject);
}
