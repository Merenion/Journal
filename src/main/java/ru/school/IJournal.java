package ru.school;

import javax.xml.crypto.Data;

public interface IJournal {
    void addRating (IPerson person, Rating rating, Data data);
    void deleteRating (IPerson person,Data data);
    void getRating (Data data ,IPerson person);
    void getRatings (IPerson person);

}
