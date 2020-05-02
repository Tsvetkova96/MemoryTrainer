package com.codebind.UI;

import com.codebind.Classes.FileHelper;
import com.codebind.Classes.Trainer;
import com.codebind.Main;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class TrainerPanel extends JPanel  {
    Trainer trainer;
    public TrainerPanel(int size, String symbolType) {
        setLayout(new java.awt.GridLayout(size, size));
        trainer = new Trainer(size * size, symbolType);
        ArrayList<String> tabel = trainer.getShulteTable();
        for (int i = 1; i <= size * size; ++i) {
            JButton b = new JButton(String.valueOf(tabel.get(i-1)));
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
                            FileHelper.WriteResultToFile(time,symbolType,size);
                        } else {
                            Main.mainPanel.topBarPanel.setCurrentSymbolText("Нажмите " + trainer.getNextSymbol());
                        }
                    }
                }
            });
            add(b);
        }
    }
    public String getNextSymbol() {
        return  trainer.getNextSymbol();
    }
}
