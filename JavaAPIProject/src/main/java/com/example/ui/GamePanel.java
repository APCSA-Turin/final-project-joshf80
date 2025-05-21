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
        g.drawRoundRect(310, 170, 165, 18, 10, 10);
        g.drawRoundRect(387, 170, 18, 110, 10, 10);

        // t-bone 2
        g.drawRoundRect(238, 255, 80, 18, 10, 10);
        g.drawRoundRect(220, 170, 18, 200, 10, 10);

        // t-bone 3
        g.drawRoundRect(460, 255, 80, 18, 10, 10);
        g.drawRoundRect(542, 170, 18, 200, 10, 10);

        // tubes
        g.drawRoundRect(620, 360, 120, 10, 10, 10);
        g.drawRoundRect(40, 360, 120, 10, 10, 10);

        // bottom wall
        g.drawRoundRect(40, 430, 700, 10, 10, 10);


        // testing points for pathway
        g.drawOval(70, 50, 10, 10);
        g.drawOval(185, 50, 10, 10);
        g.drawOval(350, 50, 10, 10);
        g.drawOval(425, 50, 10, 10);
        g.drawOval(585, 50, 10, 10);
        g.drawOval(700, 50, 10, 10);

        g.drawOval(70, 140, 10, 10);
        g.drawOval(185, 140, 10, 10);
        g.drawOval(270, 140, 10, 10);
        g.drawOval(350, 140, 10, 10);
        g.drawOval(425, 140, 10, 10);
        g.drawOval(500, 140, 10, 10);
        g.drawOval(585, 140, 10, 10);
        g.drawOval(700, 140, 10, 10);

        g.drawOval(70, 215, 10, 10);
        g.drawOval(185, 215, 10, 10);
        g.drawOval(270, 215, 10, 10);
        g.drawOval(350, 215, 10, 10);
        g.drawOval(425, 215, 10, 10);
        g.drawOval(500, 215, 10, 10);
        g.drawOval(585, 215, 10, 10);
        g.drawOval(700, 215, 10, 10);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        pacman.update();
        ghost.update();
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A:
                pacman.changeDirection(-1, 0);
                break;
            case KeyEvent.VK_W:
                pacman.changeDirection(0, -1);
                break;
            case KeyEvent.VK_S:
                pacman.changeDirection(0, 1);
                break;
            case KeyEvent.VK_D:
                pacman.changeDirection(1, 0);
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

}