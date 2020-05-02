package com.codebind.UI;

import com.codebind.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TopBarPanel extends JPanel {
    JLabel currentSymbolText;
    StopWatchPane stopWatchPane;
    JComboBox fieldSizeComboBox;
    JComboBox symbolTypeComboBox;
    public TopBarPanel(String labelText, String size, String symbolType) {
        this.setLayout(new GridLayout());
        createSymbolTypeComboBox(symbolType);
        createFieldSizeComboBox(size, symbolType);
        currentSymbolText = new JLabel(labelText);
        this.add(currentSymbolText);
        stopWatchPane = new StopWatchPane();
        this.add(stopWatchPane);
        stopWatchPane.start();
    }
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
                onFieldSizeChange();
            }
        });
    }
    public void onFieldSizeChange() {
        int size = Integer.parseInt(((String) fieldSizeComboBox.getSelectedItem()).split("x")[0]);
        String symbolType =((String) Main.mainPanel.topBarPanel.symbolTypeComboBox.getSelectedItem());
        if(size > 5) size =  symbolType.equals("Цифры") ? size : 5;
        Main.mainPanel.createNewTrainingPanel(size, symbolType);
        Main.mainPanel.creteNewTopPanel();
    }
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
                onFieldSizeChange();
            }
        });
    }
    public void setCurrentSymbolText(String text) {
        currentSymbolText.setText(text);
    }
}
