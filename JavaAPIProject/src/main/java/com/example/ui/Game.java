package com.example.ui;
import java.awt.Color;

import javax.swing.*;


public class Game 
{
    public static void initWindow() {
        // Initiate window
        JFrame frame = new JFrame();
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GamePanel map = new GamePanel();
        frame.add(map);
        frame.addKeyListener(map);

        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.black);
        frame.setVisible(true);
    }

    public static void main( String[] args )
    {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                initWindow();
            }
        });
    }
}