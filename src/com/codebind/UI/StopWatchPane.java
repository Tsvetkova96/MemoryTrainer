package com.codebind.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;

public class StopWatchPane extends JPanel {

    private JLabel label;
    private long lastTickTime;
    private Timer timer;

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
    public void start() {
        lastTickTime = System.currentTimeMillis();
        timer.restart();
    }
    public  void stop() {
        timer.stop();
    }
}
