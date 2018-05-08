package ru.school;

public class Student extends Person{
    public Student(String name, IClass inclass) {
        super(name, inclass);
    }

    @Override
    public String toString() {
        return "Student"+super.toString();
    }
}
