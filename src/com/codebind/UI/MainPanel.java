package com.codebind.UI;

import com.codebind.Main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class MainPanel extends JPanel {
    public TrainerPanel trainerPanel;
    public TopBarPanel topBarPanel;
    public BottomBarPanel bottomBarPanel;
    public MainPanel() {
        this.setLayout(new BorderLayout());
        createNewTrainingPanel(5, "Цифры");
        creteNewTopPanel();
        bottomBarPanel = new BottomBarPanel();
        this.add(bottomBarPanel, BorderLayout.SOUTH);
    }
    public void createNewTrainingPanel(int size, String  symbolType) {
        if(this.trainerPanel != null) {
            this.remove(Main.mainPanel.trainerPanel);
        }
        TrainerPanel trainingPanel = new TrainerPanel(size, symbolType);
        this.trainerPanel = trainingPanel;
        this.add(trainingPanel,BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }
    public void creteNewTopPanel() {
        String prevfieldSize = "5x5";
        String prevSymbolType = "Цифры";
        if(this.topBarPanel != null) {
            prevfieldSize = (String) Main.mainPanel.topBarPanel.fieldSizeComboBox.getSelectedItem();
            prevSymbolType = (String) Main.mainPanel.topBarPanel.symbolTypeComboBox.getSelectedItem();
            this.remove(this.topBarPanel);
        }
        topBarPanel = new TopBarPanel("Нажмите " + trainerPanel.getNextSymbol(), prevfieldSize, prevSymbolType);
        this.topBarPanel = topBarPanel;
        this.add(topBarPanel, BorderLayout.NORTH);
        this.revalidate();
        this.repaint();
    }
}
