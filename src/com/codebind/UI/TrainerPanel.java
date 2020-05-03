package com.codebind.UI;

import com.codebind.Classes.FileHelper;
import com.codebind.Classes.Result;
import com.codebind.Classes.Trainer;
import com.codebind.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

/**
 * Класс вывода панели с таблицей для тренировки со свойствами <b>trainer</b>
 * @autor Цветкова
 * @version 1.0
 */
public class TrainerPanel extends JPanel  {
    /** Поле для управления процессом тренировки */
    Trainer trainer;
    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param size - размер таблицы
     * @param symbolType - тип символов
     */
    public TrainerPanel(int size, String symbolType) {
        setLayout(new java.awt.GridLayout(size, size));
        trainer = new Trainer(size * size, symbolType);
        ArrayList<String> tabel = trainer.getShulteTable();
        for (int i = 1; i <= size * size; ++i) {
            JButton b = new JButton(String.valueOf(tabel.get(i-1)));
            int fontSize = 280 / size;
            b.setFont(new Font("Arial", Font.PLAIN, fontSize));
            b.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    //System.out.println("Resized to " + e.getComponent().getSize());
                    int fontSize = ((JButton)e.getSource()).getWidth() / 4;
                    b.setFont(new Font("Arial", Font.PLAIN, fontSize));
                }
            });
            b.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    String clickedButtonText = b.getText();
                    if(trainer.checkSymbol(clickedButtonText)) {
                        if(trainer.checkEndTrainig()){
                            var timer =Main.mainPanel.topBarPanel.stopWatchPane;
                            timer.stop();
                            String time = timer.getTime();
                            JOptionPane.showMessageDialog(null,"Поздравляем! Ваш результат " + time + " секунд");
                            String symbolType =  (String) Main.mainPanel.topBarPanel.symbolTypeComboBox.getSelectedItem();
                            String size =  (String) Main.mainPanel.topBarPanel.fieldSizeComboBox.getSelectedItem();
                            FileHelper.writeResultToFile(new Result("",time,size,symbolType));
                        } else {
                            Main.mainPanel.topBarPanel.setCurrentSymbolText("Нажмите " + trainer.getNextSymbol());
                        }
                    }
                }
            });
            add(b);
        }
    }
    /**
     * Функция возвращает следующий символ который необходимо нажать
     * @return  возвращает следующий символ который необходимо нажать
     */
    public String getNextSymbol() {
        return  trainer.getNextSymbol();
    }
}
