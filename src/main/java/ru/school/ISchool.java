package ru.school;

public interface ISchool {
    void addClass(IClass schoolClass);
    void removeClass(char unit, int level);
    IClass getClass(char unit, int level);
}
