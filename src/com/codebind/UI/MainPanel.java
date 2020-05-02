package com.codebind.UI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class MainPanel extends JPanel {
    public MainPanel() {
        this.setLayout(new BorderLayout());
        this.add(new TrainerPanel(5), BorderLayout.CENTER);
    }
}
