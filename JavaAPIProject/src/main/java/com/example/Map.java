package com.example;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class Map extends JPanel implements ActionListener, KeyListener {

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.blue);
        g.drawRoundRect(40, 20, 10, 235, 10, 10);
        g.drawRoundRect(40, 20, 700, 10, 10, 10);
        g.drawRoundRect(730, 20, 10, 235, 10, 10);
        g.drawRoundRect(387, 30, 15, 95, 10, 10);

        
        g.drawRoundRect(100, 75, 60, 45, 20, 20);
        g.drawRoundRect(220, 75, 100, 45, 20, 20);

        g.drawRoundRect(620, 75, 60, 45, 20, 20);
        g.drawRoundRect(460, 75, 100, 45, 20, 20);

        g.drawRoundRect(100, 170, 60, 15, 20, 20);
        g.drawRoundRect(620, 170, 60, 15, 20, 20);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint(); // trigger screen refresh
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // must be defined
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // must be defined
    }    
}
