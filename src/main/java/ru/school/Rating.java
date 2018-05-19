package ru.school;

import java.io.Serializable;
import java.util.Date;

public class Rating implements Serializable {

    enum ValueRating {A(5),B(4),C(3),D(2),F(1);
        int priority;
        ValueRating(int i) {
            priority = i;
        }

        public int getPriority() {
            return priority;
        }
    }

    Rating(ValueRating rating, Date date, IPerson person) {
        this.rating = rating.getPriority();
        this.date = date;
        this.person = person;
        letterRating = rating.toString();
    }

    private int rating;
    private String letterRating;
    private Date date;
    private IPerson person;

    public int getRating() {
        return rating;
    }

    public Date getDate() {
        return date;
    }

    public IPerson getPerson() {
        return person;
    }

    @Override
    public String toString() {
        return "{" +
                "value = " + rating + "("+letterRating+")"+
                ", date = " + date +
                '}';
    }
}
