package ru.school;

import javax.xml.crypto.Data;
import java.util.HashSet;
import java.util.Set;

public class Journal implements IJournal{

    private String nameSubject;
    private IClass classs;
    private Set<Rating> ratings = new HashSet<Rating>();

    public Journal(String nameSubject, IClass classs) {
        this.nameSubject = nameSubject;
        this.classs = classs;
    }

    @Override
    public void addRating(IPerson person, Rating rating) {

    }

    @Override
    public void deleteRating(IPerson person, Data data) {

    }

    @Override
    public void getRating(Data data, IPerson person) {

    }

    @Override
    public void getRatings(IPerson person) {

    }


}
