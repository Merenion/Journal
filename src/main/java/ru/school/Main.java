package ru.school;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class Main  {
    public static void main(String[] args) throws IOException {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2,4,1);

        System.out.println(calendar.getTime());


    }
}
