package ru.school;

import java.util.Set;

public interface IClass {

    void addJournal (Journal journal);
    void removeJournal (Journal journal);
    Set<IPerson> getStudents();
    Set<IJournal> getJournals();
}
