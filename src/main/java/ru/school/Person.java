package ru.school;

public class Person implements IPerson{
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
        this.name = name;
    }

    @Override
    public IClass getClassroom() {
        return classroom;
    }

    @Override
    public void setClassroom(IClass classroom) {
        this.classroom = classroom;
    }
}
