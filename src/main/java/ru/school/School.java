package ru.school;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

public class School implements ISchool {

    private Set<IClass> classes = new HashSet<IClass>();

    @Override
    public void addClass(IClass schoolClass) {
        Main.log.finer("Use method");
    }

    @Override
    public void removeClass(String unit, int level) {
        Main.log.finer("Use method");
    }

    @Override
    public IClass getClass(String unit, int level) {
        Main.log.finer("Use method");
        return null;
    }

    @Override
    public String getListClasses() {
        Main.log.finer("Use method");
        return null;
    }
}
