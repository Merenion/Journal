package ru.school;

import javax.xml.crypto.Data;
import java.util.Set;

public interface IJournal {
    void addRating (Rating rating);
    void deleteRating (IPerson person,Data data);
    Rating getRating (Data data ,IPerson person);
    Set<Rating> getRatings (IPerson person);
    String getListRatings (IPerson person);
}
