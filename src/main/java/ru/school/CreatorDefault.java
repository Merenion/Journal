package ru.school;

public class CreatorDefault implements ICreator{

    @Override
    public ISchool createSchool () {
        return new School();
    }

    @Override
    public IPerson createStudent (String name, IClass classroom) {
        return new Student(name,classroom);
    }

    @Override
    public IPerson createBoss (String name, IClass classroom) {
        return new Boss(name,classroom);
    }

    @Override
    public IClass createClass (String letter, int level) {
        return new Class(letter,level);
    }

    @Override
    public IJournal createJournal (String nameSubject, IClass classs){
        return new Journal(nameSubject,classs);
    }
}
