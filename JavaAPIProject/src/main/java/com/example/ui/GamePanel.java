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

    private Core c1;
    private Core c2;
    private Core c3;
    private Core c4;
    private Core c5;
    private Core c6;
    private Core c7;
    private Core c8;
    private Core c9;
    private Core c10;
    private Core c11;
    private Core c12;
    private Core c13;
    private Core c14;
    private Core c15;
    private Core c16;
    private Core c17;
    private Core c18;
    private Core c19;
    private Core c20;
    private Core c21;
    private Core c22;
    private Core c23;
    private Core c24;
    private Core c25;
    private Core c26;
    private Core c27;
    private Core c28;
    private Core c29;
    private Core c30;
    private Core c31;
    private Core c32;



    public GamePanel() {
        c1 = new Core(60, 40);
        c2 = new Core(175, 40);
        c3 = new Core(340, 40);
        c4 = new Core(415, 40);
        c5 = new Core(575, 40);
        c6 = new Core(690, 40);

        c7 = new Core(60, 130);
        c8 = new Core(175, 130);
        c9 = new Core(260, 130);
        c10 = new Core(340, 130);
        c11 = new Core(415, 130);
        c12 = new Core(490, 130);
        c13= new Core(575, 130);
        c14 = new Core(690, 130);

        c15 = new Core(60, 205);
        c16 = new Core(175, 205);
        c17 = new Core(260, 205);
        c18 = new Core(340, 205);
        c19 = new Core(415, 205);
        c20 = new Core(490, 205);
        c21 = new Core(575, 205);
        c22 = new Core(690, 205);

        c23 = new Core(260, 290);
        c24 = new Core(340, 290);
        c25 = new Core(415, 290);
        c26 = new Core(490, 290);

        c27 = new Core(60, 385);
        c28 = new Core(175, 385);
        c29 = new Core(260, 385);
        c30 = new Core(490, 385);
        c31 = new Core(575, 385);
        c32 = new Core(690, 385);


        // Connecting all cores
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
        c23.addNeighbor(c29);
        c24.addNeighbor(c23);
        c24.addNeighbor(c25);
        c25.addNeighbor(c26);
        c26.addNeighbor(c30);
        c27.addNeighbor(c28);
        c31.addNeighbor(c32);

        // setup game objects
        pacman = new Pacman(60,40);
        pacman.setCurrent(c1);
        ghost = new Ghost(375, 365);

        setBackground(Color.black);
        
        // frame rate
        timer = new Timer(20, this);
        timer.start();
    }
    

    @Override
    protected void paintComponent(Graphics g) {
        // draw all objects every tick
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        pacman.update();
        ghost.update();
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Handle user keystrokes
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A:
                //Check if user is currently on a core
                if (pacman.getCurrent().getX() >= pacman.getX() - 5 && pacman.getCurrent().getX() <= pacman.getX() + 5) {
                    // check if there is a core in direction user wants to go
                    /*  if user direction available {     
                     *  - set new current core to core its heading towards
                     * }
                     */ 
                    pacman.changeDirection(-1, 0);
                }
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
    

    // nessecary methods
    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

}