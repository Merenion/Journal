package ru.school;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Journal implements IJournal, Serializable {

    private String nameSubject;
    private IClass classs;
    private Set<Rating> ratings = new HashSet<Rating>();

    Journal(String nameSubject, IClass classs) {
        this.nameSubject = nameSubject;
        this.classs = classs;
    }

    @Override
    public void addRating(Rating rating) {
        Main.log.finer("Use method");
        assert rating!=null:"Rating = null - unacceptable";
        assert rating.getPerson()!=null:"Person = null - unacceptable";
        Optional<Rating> optional = ratings.stream().filter(x -> x.getDate().getTime()==(rating.getDate().getTime())).findAny();
        if (optional.isPresent()) {
            Main.log.warning("На эту дату оценка уже была поставлена. Она будет замененна.");
            ratings.remove(optional.get());
        }
        ratings.add(rating);
        Main.log.info("Оценка поставлена");
    }

    @Override
    public void deleteRating(IPerson person, Date date) {
        Main.log.finer("Use method");
        assert person != null:"Person = null - unacceptable";
        Optional<Rating> optional = ratings.stream().filter(x -> x.getDate().getTime() == date.getTime()
                && x.getPerson().getName().equals(person.getName())).findAny();
        if (!optional.isPresent()) {
            Main.log.warning("Такая оцценка не найдена");
            return;
        }
        ratings.remove(optional.get());
        Main.log.info("Оценка удалена");
    }

    @Override
    public Rating getRating(Date date, IPerson person) {
        Main.log.finer("Use method");
        assert person != null:"Person = null - unacceptable";
        Optional<Rating> optional = ratings.stream().filter(x -> x.getDate().getTime() == date.getTime()
                && x.getPerson().getName().equals(person.getName())).findAny();
        if (!optional.isPresent()) {
            Main.log.warning("Такая оцценка не найдена");
            return null;
        }
        return optional.get();
    }

    @Override
    public List<Rating> getRatings(IPerson person) {
        Main.log.finer("Use method");
        assert person != null:"Person = null - unacceptable";
        return ratings.stream().filter(x->x.getPerson().getName().equals(person.getName())).collect(Collectors.toList());
    }

    @Override
    public String getListRatings(IPerson person) {
        Main.log.finer("Use method");
        assert person != null:"Person = null - unacceptable";
        StringBuilder sb = new StringBuilder("Ratings:");
        List<Rating> list = this.ratings.stream().filter(x -> x.getPerson().getName().equals(person.getName()))
                .collect(Collectors.toList());
        if (list.size()!=0) {
            int i = 1;
            for (Rating rating : list)
                sb.append("\n").append(i++).append(") ").append(rating);
        } else {
            sb.append("Пусто");
        }
        return sb.toString();
    }

    @Override
    public String getNameSubject() {
        return nameSubject;
    }

    @Override
    public String toString() {
        return "Journal{" +
                "nameSubject='" + nameSubject + '\'' +
                ", " + classs +
                '}';
    }
}
