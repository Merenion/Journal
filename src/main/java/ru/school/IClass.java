package ru.school;

import java.util.Set;

public interface IClass {

    void addJournal (IJournal journal);
    void removeJournal (String nameSubject);
    void addStudent (IPerson person);
    void removeStudent (String name);
    Set<IPerson> getStudents();
    Set<IJournal> getJournals();
    IPerson getStudent(String name);
    IJournal getJournal (String subject);
    void setBoss (IPerson boss);
    IPerson getBoss ();
    String getListPerson();
    String getListJournal();
    String getLetter();
    int getLevel();
}
