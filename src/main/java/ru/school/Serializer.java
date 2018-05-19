package ru.school;

import java.io.*;
import java.util.Optional;

public class Serializer {

    private static Serializer serializer;

    private Serializer() {
    }

    public static Serializer getSerializer () {
        if (serializer == null) {
            serializer = new Serializer();
        }
        return serializer;
    }

    private String path = "src/main/resources/schoolSave.out";

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void write (Object object) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(object);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Main.log.info("Все данные перезаписаны (Сериализация завершена)");
    }

    public <T> T reader () {
        Optional<Object> optional;
        T object = null;
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            object = (T) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        Main.log.info("Все данные считанны (Диссериализация завершена)");
        return object;
    }
}
