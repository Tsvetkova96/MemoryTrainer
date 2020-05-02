package com.codebind.UI;

import javax.swing.*;
import java.awt.*;

public class TopBarPanel extends JPanel {
    JLabel currentSymbolText;
    public TopBarPanel(String labelText) {
        this.setLayout(new GridLayout());
        currentSymbolText = new JLabel(labelText);
        this.add(currentSymbolText);
    }
    public void setCurrentSymbolText(String text) {
        currentSymbolText.setText(text);
    }
}
