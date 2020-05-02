package com.codebind.UI;

import com.codebind.Main;

import javax.swing.*;
import java.awt.*;

public class BottomBarPanel extends JPanel {
    public BottomBarPanel() {
        this.setLayout(new GridLayout());
        JButton button = new JButton("Начать");
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                newTraining();
            }
        });
        this.add(button);
    }
    void newTraining() {
        Main.mainPanel.createNewTrainingPanel();
        Main.mainPanel.creteNewTopPanel();
    }

}
