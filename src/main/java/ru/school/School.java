package ru.school;

import java.util.HashSet;
import java.util.Set;

public class School implements ISchool {

    private Set<IClass> classes = new HashSet<IClass>();

    @Override
    public void addClass(IClass schoolClass) {

    }

    @Override
    public void removeClass(char unit, int level) {

    }

    @Override
    public IClass getClass(char unit, int level) {
        return null;
    }
}
