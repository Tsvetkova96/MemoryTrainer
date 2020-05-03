package com.codebind.UI;

import com.codebind.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/**
 * Класс вывода верхней панели с инструментами со свойствами <b>currentSymbolText</b>, <b>stopWatchPane</b>, <b>fieldSizeComboBox</b>, <b>symbolTypeComboBox</b>
 * @autor Цветкова
 * @version 1.0
 */
public class TopBarPanel extends JPanel {
    /** Поле текущий символ который необходимо нажать */
    JLabel currentSymbolText;
    /** Поле с таймером тренировки */
    StopWatchPane stopWatchPane;
    /** Поле выбора размера таблицы */
    JComboBox fieldSizeComboBox;
    /** Поле выбора типа символов */
    JComboBox symbolTypeComboBox;
    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param labelText - текст лейбла в которм отобразаются следующий для нажатия символ
     * @param size - размер таблицы
     * @param symbolType - тип символов
     * @param needStart - нужен ли запускать тренеровку. True только поле нажатия кнопки "Начать"
     */
    public TopBarPanel(String labelText, String size, String symbolType, boolean needStart) {
        this.setLayout(new GridLayout());
        createSymbolTypeComboBox(symbolType);
        createFieldSizeComboBox(size, symbolType);
        currentSymbolText = new JLabel(labelText);
        currentSymbolText.setForeground(Color.RED);
        this.add(currentSymbolText);
        stopWatchPane = new StopWatchPane();
        this.add(stopWatchPane);
        if(needStart) stopWatchPane.start();
    }
    /**
     * Функция создания нового комбо бокса для выбора размера таблицы в зависимости
     * @param size размер, который будет выбран по умолчанию
     * @symbolType тип сиволов. Если тип != "Цифры", по комбо бокс будет содержать значения 3x3, 4x4 и 5x5
     */
    void createFieldSizeComboBox(String size, String symbolType) {
        ArrayList<String> items = new ArrayList<String>();
        if(Integer.parseInt(size.split("x")[0])  > 5) size =  symbolType.equals("Цифры") ? size : "5x5";
        int maxChose = symbolType.equals("Цифры") ? 16 : 6;
        for(int i = 3; i < maxChose; i++ ) {
            items.add(i + "x" + i);
        }
        fieldSizeComboBox = new JComboBox(items.toArray());
        fieldSizeComboBox.setSelectedItem(size);
        this.add(fieldSizeComboBox);
        fieldSizeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onComboBoxValueChanged();
            }
        });
    }
    /**
     * Функция вызывающаяся при имзменении размера таблицы или типа символов. Создает панель тренировки заново
     */
    private void onComboBoxValueChanged() {
        int size = Integer.parseInt(((String) fieldSizeComboBox.getSelectedItem()).split("x")[0]);
        String symbolType =((String) Main.mainPanel.topBarPanel.symbolTypeComboBox.getSelectedItem());
        if(size > 5) size =  symbolType.equals("Цифры") ? size : 5;
        Main.mainPanel.createNewTrainingPanel(size, symbolType, false);
        Main.mainPanel.creteNewTopPanel(false);
    }
    /**
     * Функция создания нового комбо бокса для выбора размера таблицы в зависимости
     * @symbolType тип сиволов, который будет выбран по умолчанию
     */
    void createSymbolTypeComboBox(String syboltype) {
        String[] items = {
                "Цифры",
                "РУС",
                "АНГЛ",
        };
        symbolTypeComboBox = new JComboBox(items);
        symbolTypeComboBox.setSelectedItem(syboltype);
        this.add(symbolTypeComboBox);
        symbolTypeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onComboBoxValueChanged();
            }
        });
    }
    /**
     * Процедура определения текущего символа который необходимо нажать {@link TopBarPanel#currentSymbolText}
     */
    public void setCurrentSymbolText(String text) {
        currentSymbolText.setText(text);
    }
}
