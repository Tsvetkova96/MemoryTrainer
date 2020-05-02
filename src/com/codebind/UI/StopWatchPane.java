package com.codebind.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;

/**
 * Класс вывода таймера тренировки со свойствами <b>label</b>, <b>lastTickTime</b>, <b>timer</b>
 * @autor Цветкова
 * @version 1.0
 */
public class StopWatchPane extends JPanel {
    /** Поле вывода таймера */
    private JLabel label;
    /** Поле последнего тика таймера */
    private long lastTickTime;
    /** Поле таймера */
    private Timer timer;
    /**
     * Конструктор - создание нового объекта
     */
    public StopWatchPane() {
        setLayout(new GridBagLayout());
        label = new JLabel(String.format("%02d:%02d.%03d", 0, 0, 0, 0));

        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText(getTime());
            }
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(4, 4, 4, 4);
        add(label, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.weightx = 0;
        gbc.gridwidth = 1;
        gbc.gridx++;
    }
    /**
     * Функция возвращает текущее значение таймера в формате mm:ss:ms
     * @return возвращает текущее значение таймера в формате mm:ss:ms
     */
    public String getTime() {
        long runningTime = System.currentTimeMillis() - lastTickTime;
        Duration duration = Duration.ofMillis(runningTime);
        long hours = duration.toHours();
        duration = duration.minusHours(hours);
        long minutes = duration.toMinutes();
        duration = duration.minusMinutes(minutes);
        long millis = duration.toMillis();
        long seconds = millis / 1000;
        millis -= (seconds * 1000);
        return String.format("%02d:%02d.%03d", minutes, seconds, millis);
    }
    /**
     * Функция запуска таймера
     */
    public void start() {
        lastTickTime = System.currentTimeMillis();
        timer.restart();
    }
    /**
     * Функция остановки таймера
     */
    public  void stop() {
        timer.stop();
    }
}
