package ru.school;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Class implements IClass {

    private String letter;
    private int level;
    private IPerson boss;
    private Set<IJournal> journals = new HashSet<IJournal>();
    private Set<IPerson> students = new HashSet<IPerson>();


    Class(String letter, int level) {
        this.letter = letter;
        this.level = level;
    }

    @Override
    public void addJournal(IJournal journal) {
        Main.log.finer("Use method");
        if (journals.stream().anyMatch(x -> x.getNameSubject().equals(journal.getNameSubject()))) {
            Main.log.warning("Такой журнал уже существует, задайте другие параметры");
            return;
        }
        journals.add(journal);
        Main.log.info("Журнал добавлен");
    }

    @Override
    public void removeJournal(String nameSubject) {
        Main.log.finer("Use method");
        Optional optional = journals.stream().filter(x -> x.getNameSubject().equals(nameSubject)).findAny();
        if (!optional.isPresent()) {
            Main.log.warning("Такого журнала не существует");
            return;
        }
        journals.remove((IJournal) optional.get());
        Main.log.info("Журнал удален");
    }

    @Override
    public void addStudent(IPerson person) {
        Main.log.finer("Use method");
        if (students.stream().anyMatch(x -> x.getName().equals(person.getName()))) {
            Main.log.warning("Такой студент уже существует, задайте другие параметры");
            return;
        }
        students.add(person);
        Main.log.info("Студент добавлен");
    }

    @Override
    public void removeStudent(String name) {
        Main.log.finer("Use method");
        Optional optional = students.stream().filter(x -> x.getName().equals(name)).findAny();
        if (!optional.isPresent()) {
            Main.log.warning("Такого студента не существует");
            return;
        }
        students.remove((IPerson) optional.get());
        Main.log.info("Студент удален");
    }

    @Override
    public Set<IPerson> getStudents() {
        Main.log.finer("Use method");
        return students;
    }

    @Override
    public Set<IJournal> getJournals() {
        Main.log.finer("Use method");
        return journals;
    }

    @Override
    public IPerson getStudent(String name) {
        Main.log.finer("Use method");
        Optional optional = students.stream().filter(x -> x.getName().equals(name)).findAny();
        if (!optional.isPresent()) {
            Main.log.warning("Такого студента не существует");
            return null;
        }
        return (IPerson) optional.get();
    }

    @Override
    public IJournal getJournal(String subject) {
        Main.log.finer("Use method");
        Optional optional = journals.stream().filter(x -> x.getNameSubject().equals(subject)).findAny();
        if (!optional.isPresent()) {
            Main.log.warning("Такого журнала не существует");
            return null;
        }
        return (IJournal) optional.get();
    }

    @Override
    public void setBoss(IPerson boss) {
        Main.log.finer("Use method");
        this.boss = boss;
        Main.log.info("Классный руководитель задан");
    }

    @Override
    public IPerson getBoss() {
        Main.log.finer("Use method");
        return boss;
    }

    @Override
    public String getListPerson() {
        Main.log.finer("Use method");
        StringBuilder sb = new StringBuilder("Students:");
        if (students.size() != 0) {
            int i = 1;
            for (IPerson person: students)
                sb.append("\n").append(i++).append(") ").append(person);
        } else {
            sb.append("Пусто");
        }
        return sb.toString();
    }

    @Override
    public String getListJournal() {
        Main.log.finer("Use method");
        StringBuilder sb = new StringBuilder("Journals:");
        if (journals.size() != 0) {
            int i = 1;
            for (IJournal journal : journals)
                sb.append("\n").append(i++).append(") ").append(journal);
        } else {
            sb.append("Пусто");
        }
        if (boss!=null)
            sb.append("\n").append(boss);
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Class[" +
                "letter=" + letter +
                ", level=" + level +
                ']';
    }

    @Override
    public String getLetter() {
        return letter;
    }

    @Override
    public int getLevel() {
        return level;
    }
}
