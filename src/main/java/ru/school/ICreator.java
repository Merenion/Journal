package ru.school;

public interface ICreator {
    ISchool createSchool ();
    IPerson createStudent (String name, IClass classroom);
    IPerson createBoss (String name, IClass classroom);
    IClass createClass (String letter, int level);
    IJournal createJournal (String nameSubject, IClass classs);
}
