package com.example;
import java.awt.Color;

import javax.swing.*;


public class App 
{
    public static void initWindow() {
        JFrame frame = new JFrame();
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Map map = new Map();
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
