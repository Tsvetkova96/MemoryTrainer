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
        createNewTrainingPanel();
        creteNewTopPanel();
        bottomBarPanel = new BottomBarPanel();
        this.add(bottomBarPanel, BorderLayout.SOUTH);
    }
    public void createNewTrainingPanel() {
        if(this.trainerPanel != null) {
            this.remove(Main.mainPanel.trainerPanel);
        }
        TrainerPanel trainingPanel = new TrainerPanel(3);
        this.trainerPanel = trainingPanel;
        this.add(trainingPanel,BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }
    public void creteNewTopPanel() {
        if(this.topBarPanel != null) {
            this.remove(this.topBarPanel);
        }
        topBarPanel = new TopBarPanel("Нажмите " + trainerPanel.getNextSymbol());
        this.topBarPanel = topBarPanel;
        this.add(topBarPanel, BorderLayout.NORTH);
        this.revalidate();
        this.repaint();
    }
}
