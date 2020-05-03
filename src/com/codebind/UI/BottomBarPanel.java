package com.codebind.UI;

import com.codebind.Main;

import javax.swing.*;
import java.awt.*;
/**
 * Класс вывода нижней панели с кнопками
 * @autor Цветкова
 * @version 1.0
 */
public class BottomBarPanel extends JPanel {
    /**
     * Конструктор - создание нового объекта
     */
    public BottomBarPanel() {
        this.setLayout(new GridLayout());
        JButton satrtButton = new JButton("Начать");
        satrtButton.setForeground(Color.RED);
        satrtButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                startNewTraining();
            }
        });
        this.add(satrtButton);
        JButton resultButton = new JButton("Таблица результатов");
        resultButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                final JDialog frame = new JDialog((JFrame) SwingUtilities.getWindowAncestor(Main.mainPanel), "Таблица результатов", true);
                frame.getContentPane().add(new ResultTablePanel());
                frame.pack();
                frame.setVisible(true);
            }
        });
        this.add(resultButton);
    }
    /**
     * Функция для начала новой тренировки
     */
    void startNewTraining() {
        int size =Integer.parseInt(((String) Main.mainPanel.topBarPanel.fieldSizeComboBox.getSelectedItem()).split("x")[0]);
        String symbolType =((String) Main.mainPanel.topBarPanel.symbolTypeComboBox.getSelectedItem());
        Main.mainPanel.createNewTrainingPanel(size,symbolType, true);
        Main.mainPanel.creteNewTopPanel(true);
    }

}
