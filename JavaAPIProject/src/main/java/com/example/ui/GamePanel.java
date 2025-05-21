package com.example.ui;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

import com.example.entities.Ghost;
import com.example.entities.Pacman;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    private Pacman pacman;
    private Ghost ghost;
    private Timer timer;

    public GamePanel() {
        pacman = new Pacman(100, 100);
        ghost = new Ghost(600, 100);

        setBackground(Color.black);
    
        timer = new Timer(20, this);
        timer.start();
    }
    

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawMap(g);
        pacman.draw(g);
        ghost.draw(g);
    }

    private void drawMap(Graphics g) {
        g.setColor(Color.BLUE);

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

        // right hand blocks
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
    public void actionPerformed(ActionEvent e) {
        pacman.update();
        ghost.update();
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // placeholder if you want directional movement later
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

}