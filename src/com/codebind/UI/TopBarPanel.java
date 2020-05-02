package com.codebind.UI;

import com.codebind.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TopBarPanel extends JPanel {
    JLabel currentSymbolText;
    StopWatchPane stopWatchPane;
    JComboBox comboBox;
    public TopBarPanel(String labelText) {
        this.setLayout(new GridLayout());
        createFieldSizeComboBox();
        currentSymbolText = new JLabel(labelText);
        this.add(currentSymbolText);
        stopWatchPane = new StopWatchPane();
        this.add(stopWatchPane);
        stopWatchPane.start();
    }
    void createFieldSizeComboBox() {
        String[] items = new String[13];
        for(int i = 3; i < 16; i++ ) {
            items[i-3] = i + "x" + i;
        }
        comboBox = new JComboBox(items);
        comboBox.setSelectedItem("5x5");
        this.add(comboBox);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onFieldSizeChange();
            }
        });
    }
    public void onFieldSizeChange() {
        int size = Integer.parseInt(((String) comboBox.getSelectedItem()).split("x")[0]);
        Main.mainPanel.createNewTrainingPanel(size);
        Main.mainPanel.creteNewTopPanel();


    }
    public void setCurrentSymbolText(String text) {
        currentSymbolText.setText(text);
    }
}
