package org.corieleclair;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Objects;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static java.lang.Thread.sleep;

public class Main {

    private static void prepareGlenniferControllers(){
        // main frame settings
        JFrame frame = new JFrame("FrameDemo");




        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setMinimumSize(new Dimension(1200, 500));


        GridLayout mainLayout = new GridLayout(4, 2);

        mainLayout.setVgap(10);
        mainLayout.setHgap(5);

        frame.setLayout(mainLayout);

        // speed controllers

        JLabel leftSpeedControllersLabel = new JLabel("Left Motor Speed Controller: 0-1");
        leftSpeedControllersLabel.setOpaque(true);

        leftSpeedControllersLabel.setBackground(Color.RED);
        leftSpeedControllersLabel.setMaximumSize(new Dimension(100, 1));
        frame.add(leftSpeedControllersLabel);


        Double[] leftSpeedMotorChoices = { 0.0, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1.0};
        final JComboBox<Double> leftMotorSpeed = new JComboBox<>(leftSpeedMotorChoices);

        JLabel rightSpeedControllersLabel = new JLabel("Right Motor Speed Controller: 0-1");
        rightSpeedControllersLabel.setOpaque(true);
        rightSpeedControllersLabel.setBackground(Color.GREEN);
        frame.add(rightSpeedControllersLabel);

        Double[] rightSpeedMotorChoices = { 0.0, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1.0};
        final JComboBox<Double> rightMotorSpeed = new JComboBox<>(rightSpeedMotorChoices);





        JButton buttonUpdateSpeeds = new JButton("Update Speeds?");
        JButton stopRobotButton = new JButton("Stop Robot");

        stopRobotButton.addActionListener(e -> {
            try {
                ContactPi.UpdateSpeed("0", "0");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            buttonUpdateSpeeds.setText("Update Speeds?");
            buttonUpdateSpeeds.setOpaque(false);
        });



        buttonUpdateSpeeds.addActionListener(e -> {
            try {
                ContactPi.UpdateSpeed(leftMotorSpeed.getSelectedItem().toString(), rightMotorSpeed.getSelectedItem().toString());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        buttonUpdateSpeeds.setFocusable(false);
        stopRobotButton.setFocusable(false);
        rightMotorSpeed.setFocusable(false);
        leftMotorSpeed.setFocusable(false);


        frame.add(buttonUpdateSpeeds);
        frame.add(stopRobotButton);

        frame.add(rightMotorSpeed);
        frame.add(leftMotorSpeed);


        frame.pack();

        frame.setVisible(true);

        frame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_UP) {
                    try {
                        ContactPi.DriveForward();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    System.out.println("Up Arrrow-Key is pressed!");

                }
                else if (keyCode == KeyEvent.VK_DOWN) {
                    try {
                        ContactPi.DriveReverse();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    System.out.println("Up Arrrow-Key is pressed!");
                }
                else if (keyCode == KeyEvent.VK_LEFT) {
                    try {
                        ContactPi.DriveLeft();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    System.out.println("Up Arrrow-Key is pressed!");
                }
                else if (keyCode == KeyEvent.VK_RIGHT) {
                    try {
                        ContactPi.DriveRight();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    System.out.println("Up Arrrow-Key is pressed!");
                } else if (keyCode == KeyEvent.VK_CONTROL) {
                    try {
                        ContactPi.Stop();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                    System.out.println("Right Arrrow-Key is pressed!");
            }
        });




    }



    public static void main(String[] args) {
        prepareGlenniferControllers();


    }



}

