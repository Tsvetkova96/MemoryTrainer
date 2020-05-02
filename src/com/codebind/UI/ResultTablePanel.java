package com.codebind.UI;

import com.codebind.Classes.Result;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
/**
 * Класс вывода панели с результатами тренировки.
 * @autor Цветкова
 * @version 1.0
 */
public class ResultTablePanel extends JPanel {
    /**
     * Конструктор - создание нового объекта
     */
    public  ResultTablePanel() {
        ArrayList<Result> results = Result.getResultsFromFile();
        String[] columnNames = {"Дата",
                "Результат",
                "Тип символов",
                "Размер таблицы"};
        Object[][] data = new Object[results.size()][4];
        for(int i = 0; i < results.size(); i++) {
            data[i][0] = results.get(i).getDate();
            data[i][1] = results.get(i).getTimeResult();
            data[i][2] = results.get(i).getSymbolType();
            data[i][3] = results.get(i).getSize();
        }

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        this.setLayout(new GridLayout());
        this.add(scrollPane);


    }

}
