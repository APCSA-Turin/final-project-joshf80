package com.example.ui;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

import com.example.core.Core;
import com.example.entities.Ghost;
import com.example.entities.Pacman;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    private Pacman pacman;
    private Ghost ghost;
    private Timer timer;

    public GamePanel() {
        pacman = new Pacman(60,40);
        ghost = new Ghost(375, 365);

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

        // ghost box
        g.drawRoundRect(300, 330, 50, 10, 10, 10);
        g.drawRoundRect(300, 340, 10, 90, 10, 10);

        g.drawRoundRect(430, 330, 50, 10, 10, 10);
        g.drawRoundRect(470, 340, 10, 90, 10, 10);

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


        g.drawOval(270, 300, 10, 10);
        g.drawOval(350, 300, 10, 10);
        g.drawOval(425, 300, 10, 10);
        g.drawOval(500, 300, 10, 10);

        g.drawOval(70, 395, 10, 10);
        g.drawOval(185, 395, 10, 10);
        g.drawOval(270, 395, 10, 10);
        g.drawOval(500, 395, 10, 10);
        g.drawOval(585, 395, 10, 10);
        g.drawOval(700, 395, 10, 10);


        Core c1 = new Core(60, 40);
        Core c2 = new Core(175, 40);
        Core c3 = new Core(340, 40);
        Core c4 = new Core(415, 40);
        Core c5 = new Core(575, 40);
        Core c6 = new Core(690, 40);

        Core c7 = new Core(60, 130);
        Core c8 = new Core(175, 130);
        Core c9 = new Core(260, 130);
        Core c10 = new Core(340, 130);
        Core c11 = new Core(415, 130);
        Core c12 = new Core(490, 130);
        Core c13= new Core(575, 130);
        Core c14 = new Core(690, 130);

        Core c15 = new Core(60, 205);
        Core c16 = new Core(175, 205);
        Core c17 = new Core(260, 205);
        Core c18 = new Core(340, 205);
        Core c19 = new Core(415, 205);
        Core c20 = new Core(490, 205);
        Core c21 = new Core(575, 205);
        Core c22 = new Core(690, 205);

        Core c23 = new Core(260, 290);
        Core c24 = new Core(340, 290);
        Core c25 = new Core(415, 290);
        Core c26 = new Core(490, 290);

        Core c27 = new Core(60, 385);
        Core c28 = new Core(175, 385);
        Core c29 = new Core(260, 385);
        Core c30 = new Core(490, 385);
        Core c31 = new Core(575, 385);
        Core c32 = new Core(690, 385);


        c1.addNeighbor(c2);
        c1.addNeighbor(c7);
        c2.addNeighbor(c3);
        c2.addNeighbor(c8);
        c3.addNeighbor(c10);
        c4.addNeighbor(c11);
        c4.addNeighbor(c5);
        c5.addNeighbor(c13);
        c5.addNeighbor(c6);
        c6.addNeighbor(c14);
        c7.addNeighbor(c15);
        c7.addNeighbor(c8);
        c8.addNeighbor(c9);
        c8.addNeighbor(c16);
        c9.addNeighbor(c17);
        c9.addNeighbor(c10);
        c10.addNeighbor(c11);
        c11.addNeighbor(c12);
        c12.addNeighbor(c20);
        c12.addNeighbor(c13);
        c13.addNeighbor(c21);
        c13.addNeighbor(c14);
        c14.addNeighbor(c22);
        c15.addNeighbor(c16);
        c16.addNeighbor(c28);
        c17.addNeighbor(c18);
        c18.addNeighbor(c24);
        c19.addNeighbor(c25);
        c19.addNeighbor(c20);
        c21.addNeighbor(c31);
        c21.addNeighbor(c22);
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