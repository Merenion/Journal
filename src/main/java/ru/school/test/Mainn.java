package ru.school.test;

import ru.school.Journal;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.StringWriter;

public class Mainn {
    public static void main(String[] args) throws JAXBException {
        IPersonss personss1 = new Persons();
        IPersonss personss2 = new Persons();
        IPersonss personss3 = new Persons();
        IPersonss personss4 = new Persons();
        Journalss journalss = new Journalss();
        journalss.setSubject("MatematikA");

        personss1.setName("Vlad");
        personss2.setName("Marina");
        personss3.setName("Vika");
        personss4.setName("Pasha");

        journalss.addPersons(personss1);
        journalss.addPersons(personss2);
        journalss.addPersons(personss3);
        journalss.addPersons(personss4);

        //писать результат сериализации будем во Writer(StringWriter)
        StringWriter writer = new StringWriter();

        //создание объекта Marshaller, который выполняет сериализацию
        JAXBContext context = JAXBContext.newInstance(Persons.class,Journal.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        // самосериализация
        marshaller.marshal(journalss, writer);

        //преобразовываем все записанное в StringWriter в строку
        System.out.println(writer.toString());

//        File file = new File("src/main/resources/lol.xml");
//        JAXBContext context = JAXBContext.newInstance(Journalss.class,Persons.class);
//        Marshaller marshaller = context.createMarshaller();
//
//        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
//
//        marshaller.marshal(journalss,file);
//        marshaller.marshal(journalss,System.out);
    }
}
