package ru.school;

import java.io.Serializable;

public interface IPerson extends Serializable {
    void setName(String name);
    String getName();
    void setClassroom(IClass classroom);
    IClass getClassroom();
}
