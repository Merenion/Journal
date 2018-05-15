package ru.school;

import javax.xml.crypto.Data;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class Journal implements IJournal{

    private String nameSubject;
    private IClass classs;
    private Set<Rating> ratings = new HashSet<Rating>();

    public Journal(String nameSubject, IClass classs) {
        this.nameSubject = nameSubject;
        this.classs = classs;
    }

    @Override
    public void addRating(Rating rating) {
        Main.log.finer("Use method");
        ratings.add(rating);
    }

    @Override
    public void deleteRating(IPerson person, Data data) {
        Main.log.finer("Use method");
        Rating rating = getRating(data,person);
        ratings.remove(rating);
    }

    @Override
    public Rating getRating(Data data, IPerson person) {
        Main.log.finer("Use method");
        return null;

    }

    @Override
    public Set<Rating> getRatings(IPerson person) {
        Main.log.finer("Use method");
        return null;
    }

    @Override
    public String getListRatings(IPerson person) {
        Main.log.finer("Use method");
        return null;
    }

    @Override
    public String toString() {
        return "Journal{" +
                "nameSubject='" + nameSubject + '\'' +
                ", " + classs +
                '}';
    }
}
