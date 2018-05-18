package ru.school.test;

import com.sun.scenario.effect.impl.prism.PrImage;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;
import java.util.Set;

@XmlRootElement
public class Journalss implements IJournalss{
    @XmlElement(name = "frfrf")
    private String subject;

    @XmlElementWrapper(name="ColektPerson", nillable = true)
    private Set<IPersonss> persons = new HashSet<>();

    @Override
    public String getSubject() {
        return subject;
    }

    @Override
    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public void addPersons (IPersonss personss) {
        persons.add(personss);
    }
}
