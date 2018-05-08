package ru.school;

public class Boss extends Person{
    public Boss(String name, IClass inclass) {
        super(name, inclass);
    }

    @Override
    public String toString() {
        return "Boss"+super.toString();
    }
}
