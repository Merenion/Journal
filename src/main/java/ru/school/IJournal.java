package ru.school;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;
import java.util.Set;

public interface IJournal {
    void addRating (Rating rating);
    void deleteRating (IPerson person,Date date);
    Rating getRating (Date date , IPerson person);
    List<Rating> getRatings (IPerson person);
    String getListRatings (IPerson person);
    String getNameSubject();
}
