package ru.school;

import java.io.Serializable;

/**Родительский класс для студента и классного руководителя (Student, Boss)*/

public class Person implements IPerson {
    private String name;
    private IClass classroom;

    public Person(String name, IClass classroom) {
        this.name = name;
        this.classroom = classroom;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        Main.log.finer("Use method");
        this.name = name;
    }

    @Override
    public IClass getClassroom() {
        Main.log.finer("Use method");
        return classroom;
    }

    @Override
    public void setClassroom(IClass classroom) {
        Main.log.finer("Use method");
        this.classroom = classroom;
    }

    @Override
    public String toString() {
        return " {" +
                "name='" + name + '\'' +
                classroom +
                '}';
    }
}
