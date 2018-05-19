package ru.school;

public interface ITui {

    /**TUI - Текстовый интерфейс пользователя*/

    ISchool getSchool();
    void setSchool(ISchool school);
    void mainSelect();
    void controlClasses();
    void controlPersons(String letter, int level);
    void controlJournals(String letter, int level);
    void controlRating(String letter, int level, String nameSubject);

}
