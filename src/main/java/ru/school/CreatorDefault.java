package ru.school;

import java.util.Date;
/**класс создающий обьекты, если тут поменять реализацию какого либо интерфейса,
 * то он будет использоваться во всей программе*/

public class CreatorDefault implements ICreator{

    @Override
    public ISchool createSchool () {
        Main.log.finer("Use method");
        return new School();
    }

    @Override
    public IPerson createStudent (String name, IClass classroom) {
        Main.log.finer("Use method");
        return new Student(name,classroom);
    }

    @Override
    public IPerson createBoss (String name, IClass classroom) {
        Main.log.finer("Use method");
        return new Boss(name,classroom);
    }

    @Override
    public IClass createClass (String letter, int level) {
        Main.log.finer("Use method");
        return new Class(letter,level);
    }

    @Override
    public IJournal createJournal (String nameSubject, IClass classs){
        Main.log.finer("Use method");
        return new Journal(nameSubject,classs);
    }

    @Override
    public Rating createRating (Rating.ValueRating rating, Date data, IPerson person){
        Main.log.finer("Use method");
        return new Rating(rating,data,person);
    }
}
