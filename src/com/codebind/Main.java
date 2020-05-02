package com.codebind;

import com.codebind.UI.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static MainPanel mainPanel;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(1000, 800));
        mainPanel = new MainPanel();
        frame.add(mainPanel);
        frame.setVisible(true);
    }
}
