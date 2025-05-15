package com.example;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class Map extends JPanel implements ActionListener, KeyListener {

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
