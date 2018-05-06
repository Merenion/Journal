package ru.school;

public interface IPerson {
    void setName(String name);
    String getName();
    void setClassroom(IClass classroom);
    IClass getClassroom();
}
