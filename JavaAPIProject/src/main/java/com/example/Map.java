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
        // walls top -> bottom
        g.drawRoundRect(40, 20, 10, 235, 10, 10);
        g.drawRoundRect(40, 20, 700, 10, 10, 10);
        g.drawRoundRect(730, 20, 10, 235, 10, 10);
        g.drawRoundRect(387, 30, 15, 95, 10, 10);
        g.drawRoundRect(620, 255, 120, 10, 10, 10);
        g.drawRoundRect(40, 255, 120, 10, 10, 10);
        g.drawRoundRect(620, 265, 10, 95, 10, 10);
        g.drawRoundRect(150, 265, 10, 95, 10, 10);

        // left hand blocks
        g.drawRoundRect(100, 75, 60, 45, 20, 20);
        g.drawRoundRect(220, 75, 100, 45, 20, 20);
        //right hand blocks
        g.drawRoundRect(620, 75, 60, 45, 20, 20);
        g.drawRoundRect(460, 75, 100, 45, 20, 20);

        // smaller blocks
        g.drawRoundRect(100, 170, 60, 15, 20, 20);
        g.drawRoundRect(620, 170, 60, 15, 20, 20);



        // t-bone 1
        g.drawRoundRect(332, 200, 120, 18, 10, 10);
        g.drawRoundRect(387, 200, 18, 95, 10, 10);
        // t-bone 2
        g.drawRoundRect(260, 275, 60, 18, 10, 10);
        g.drawRoundRect(242, 200, 18, 160, 10, 10);
        // t-bone 3
        g.drawRoundRect(460, 275, 60, 18, 10, 10);
        g.drawRoundRect(520, 200, 18, 160, 10, 10);

        // tubes
        g.drawRoundRect(620, 360, 120, 10, 10, 10);
        g.drawRoundRect(40, 360, 120, 10, 10, 10);

        // bottom wall
        g.drawRoundRect(40, 430, 700, 10, 10, 10);
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
