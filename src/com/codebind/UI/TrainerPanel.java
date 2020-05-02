package com.codebind.UI;

import com.codebind.Classes.Trainer;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class TrainerPanel extends JPanel  {
    public TrainerPanel(int size) {
        setLayout(new java.awt.GridLayout(size, size));
        Trainer trainer = new Trainer(size * size);
        ArrayList<String> tabel = trainer.getShulteTable();
        for (int i = 1; i <= size * size; ++i) {
            JButton b = new JButton(String.valueOf(tabel.get(i-1)));
            b.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {

                }
            });
            add(b);
        }
    }
}
