package com.codebind.Classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Класс для работы с файлами
 * @autor Цветкова
 * @version 1.0
 */
public class FileHelper {
    /**
     * Функция записи в файл результатов тренировки {@link FileHelper}
     */
    public static void writeResultToFile(Result result) {
        try {
            File myObj = new File("result.txt");
            myObj.createNewFile();
            FileWriter myWriter = new FileWriter("result.txt", true);

            myWriter.append(String.format("%s;%s;%s;%s" + System.lineSeparator(),getCurrentDate(),result.getTimeResult(),result.getSymbolType(), result.getSize()));
            myWriter.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    /**
     * Функция чтения результатов тренировки из файла
     * @return возвращает строку со всеми результатами разделенными !!
     */
    public static  String readResultFromFile() {
        String result = "";
        try {
            File myObj = new File("result.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                result += data + "!!";
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    /**
     * Функция возвращающая текущую дату для записи в файл
     * @return возвращает текущую дату
     */
    private static String getCurrentDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

}
