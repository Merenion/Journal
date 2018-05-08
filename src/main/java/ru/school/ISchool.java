package ru.school;

public interface ISchool {
    void addClass(IClass schoolClass);
    void removeClass(String unit, int level);
    IClass getClass(String unit, int level);
}
