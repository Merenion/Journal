package ru.school.test;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "person")
public class Persons implements IPersonss{

    @XmlElement(name = "catname")
    private String name;

    public Persons() {
    }

    public Persons(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
