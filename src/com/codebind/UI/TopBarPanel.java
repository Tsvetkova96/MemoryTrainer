package com.codebind.UI;

import javax.swing.*;
import java.awt.*;

public class TopBarPanel extends JPanel {
    JLabel currentSymbolText;
    StopWatchPane stopWatchPane;
    public TopBarPanel(String labelText) {
        this.setLayout(new GridLayout());
        currentSymbolText = new JLabel(labelText);
        this.add(currentSymbolText);
        stopWatchPane = new StopWatchPane();
        this.add(stopWatchPane);
        stopWatchPane.start();
    }
    public void setCurrentSymbolText(String text) {
        currentSymbolText.setText(text);
    }
}
