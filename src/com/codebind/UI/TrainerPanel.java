package com.codebind.UI;

import com.codebind.Classes.Trainer;
import com.codebind.Main;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class TrainerPanel extends JPanel  {
    Trainer trainer;
    public TrainerPanel(int size) {
        setLayout(new java.awt.GridLayout(size, size));
        trainer = new Trainer(size * size);
        ArrayList<String> tabel = trainer.getShulteTable();
        for (int i = 1; i <= size * size; ++i) {
            JButton b = new JButton(String.valueOf(tabel.get(i-1)));
            b.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    String clickedButtonText = b.getText();
                    if(trainer.checkSymbol(clickedButtonText)) {
                        Main.mainPanel.topBarPanel.setCurrentSymbolText("Нажмите " + trainer.getNextSymbol());
                        if(trainer.CheckEndTrainig()){
                            
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
