package com.codebind.Classes;

import java.util.ArrayList;
/**
 * Класс результатов тренировки со свойствами <b>size</b>, <b>symbolType</b>, <b>timeResult</b> и <b>date</b> .
 * @autor Цветкова
 * @version 1.0
 */
public class Result {
    /** Поле размер таблицы */
    String size;
    /** Поле тип символов */
    String symbolType;
    /** Поле результат тренировки */
    String timeResult;
    /** Поле дата тренировки */
    String date;
    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param date - дата
     * @param timeResult - результат
     * @param size - размер таблицы
     * @param symbolType - тип символов
     */
    public Result(String date,String timeResult, String size, String symbolType) {
        this.date = date;
        this.timeResult = timeResult;
        this.size = size;
        this.symbolType = symbolType;
    }
    /**
     * Функция возвращает список всех результатов тренеровки
     * @return возвращает список всех  результатов тренеровки
     */
    public static ArrayList<Result> getResultsFromFile() {
        ArrayList<Result> list = new ArrayList<Result>();
        String fileResulText = FileHelper.readResultFromFile();
        var results = fileResulText.split("!!");
        for (String row : results) {
            var resultString = row.split(";");
            list.add(new Result(resultString[0],resultString[1],resultString[3],resultString[2]));
        }
        return  list;
    }
    /**
     * Функция получения значения поля {@link Result#size}
     * @return возвращает размер таблицы
     */
    public String getSize() {
        return  size;
    }
    /**
     * Функция получения значения поля {@link Result#date}
     * @return возвращает дату тренировки
     */
    public String getDate() {
        return  date;
    }
    /**
     * Функция получения значения поля {@link Result#timeResult}
     * @return возвращает результат третировки
     */
    public String getTimeResult() {
        return  timeResult;
    }
    /**
     * Функция получения значения поля {@link Result#symbolType}
     * @return возвращает тим символов
     */
    public String getSymbolType() {
        return  symbolType;
    }
}
