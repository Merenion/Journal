package ru.school;

import jdk.nashorn.internal.runtime.options.Option;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;

public class School implements ISchool {

    private Set<IClass> classes = new HashSet<IClass>();

    @Override
    public void addClass(IClass schoolClass) {
        Main.log.finer("Use method");
        if (classes.stream().anyMatch(x -> x.getLetter().equals(schoolClass.getLetter()) && x.getLevel() == schoolClass.getLevel())) {
            Main.log.warning("Такой класс уже существует, задайте другие параметры");
            return;
        }
        classes.add(schoolClass);
        Main.log.info("Класс добавлен");
    }

    @Override
    public void removeClass(String letter, int level) {
        Main.log.finer("Use method");
        Optional optional = classes.stream().filter(x -> x.getLetter().equals(letter) && x.getLevel() == level).findAny();
        if (!optional.isPresent()) {
            Main.log.warning("Такого класса не существует");
            return;
        }
        classes.remove((IClass) optional.get());
        Main.log.info("Класс удален");
    }

    @Override
    public IClass getClass(String letter, int level) {
        Main.log.finer("Use method");
        Optional optional = classes.stream().filter(x -> x.getLetter().equals(letter) && x.getLevel() == level).findAny();
        if (!optional.isPresent()) {
            Main.log.warning("Такого класса не существует");
            return null;
        }
        return (IClass) optional.get();
    }

    @Override
    public String getListClasses() {
        Main.log.finer("Use method");
        StringBuilder sb = new StringBuilder("Classes:");
        if (classes.size() != 0) {
            int i = 1;
            for (IClass iClass : classes)
                sb.append("\n").append(i++).append(") ").append(iClass);
        } else {
            sb.append("Пусто");
        }
        return sb.toString();
    }
}
