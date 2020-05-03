package com.codebind;

import com.codebind.UI.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Основной класс приложения со свойством <b>mainPanel</b>
 * @autor Цветкова
 * @version 1.0
 */
public class Main {
    /** Полу вывода главной нанели содержащей все элементы интерфейса */
    public static MainPanel mainPanel;
    /**
     * Функция создающая интерфейс приложения
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(1000, 800));
        mainPanel = new MainPanel();
        frame.add(mainPanel);
        frame.setVisible(true);
    }
}
