package com.codebind.UI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class MainPanel extends JPanel {
    public TrainerPanel trainerPanel;
    public TopBarPanel topBarPanel;
    public MainPanel() {
        this.setLayout(new BorderLayout());
        trainerPanel = new TrainerPanel(5);
        topBarPanel = new TopBarPanel("Нажмите " + trainerPanel.getNextSymbol());
        this.add(topBarPanel, BorderLayout.NORTH);
        this.add(trainerPanel, BorderLayout.CENTER);

    }
}
