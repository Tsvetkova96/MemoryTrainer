package com.codebind.Classes;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileHelper {
    public static void WriteResultToFile(String timeResult, String symbolType, String size) {
        try {
            File myObj = new File("result.txt");
            myObj.createNewFile();
            FileWriter myWriter = new FileWriter("result.txt", true);

            myWriter.append(String.format("%s;%s;%s;%s" + System.lineSeparator(),getCurrentDate(),timeResult,symbolType, size));
            myWriter.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private static String getCurrentDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);



    }
}
