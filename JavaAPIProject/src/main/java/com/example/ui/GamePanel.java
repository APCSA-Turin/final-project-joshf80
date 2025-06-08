package com.example.ui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*; // For writing / reading
import java.util.ArrayList;

import com.example.prediction.*;
import com.example.core.Core;
import com.example.core.CoreMap;
import com.example.entities.Ghost;
import com.example.entities.Pacman;
import com.example.prediction.MovePredictor;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    private Pacman pacman;
    private Ghost ghost;
    // private Ghost ghost2;
    private Timer timer;
    private int highScore = 0;
    private boolean gameRunning = true;
    private CoreMap gameMap = new CoreMap();

    // All core declarations
    private Core c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14;
    private Core c15, c16, c17, c18, c19, c20, c21, c22, c23, c24, c25, c26;
    private Core c27, c28, c29, c30, c31, c32;

    public GamePanel() {
        // Initialize all cores
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
        c13 = new Core(575, 130);
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

        c27 = new Core(-40, 385);
        c28 = new Core(175, 385);
        c29 = new Core(260, 385);
        c30 = new Core(490, 385);
        c31 = new Core(575, 385);
        c32 = new Core(800, 385);

        // Add cores to the game map
        gameMap.addCore(c1);
        gameMap.addCore(c2);
        gameMap.addCore(c3);
        gameMap.addCore(c4);
        gameMap.addCore(c5);
        gameMap.addCore(c6);
        gameMap.addCore(c7);
        gameMap.addCore(c8);
        gameMap.addCore(c9);
        gameMap.addCore(c10);
        gameMap.addCore(c11);
        gameMap.addCore(c12);
        gameMap.addCore(c13);
        gameMap.addCore(c14);
        gameMap.addCore(c15);
        gameMap.addCore(c16);
        gameMap.addCore(c17);
        gameMap.addCore(c18);
        gameMap.addCore(c19);
        gameMap.addCore(c20);
        gameMap.addCore(c21);
        gameMap.addCore(c22);
        gameMap.addCore(c23);
        gameMap.addCore(c24);
        gameMap.addCore(c25);
        gameMap.addCore(c26);
        gameMap.addCore(c27);
        gameMap.addCore(c28);
        gameMap.addCore(c29);
        gameMap.addCore(c30);
        gameMap.addCore(c31);
        gameMap.addCore(c32);


        // Connect all cores 
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
        c28.addNeighbor(c29);
        c30.addNeighbor(c31);
        c31.addNeighbor(c32);
        c32.addNeighbor(c27);

        // Try to load high score from file
        loadHighScore();

        // Initialize game objects
        resetGame();

        // Set up panel and timer
        setBackground(Color.black);
        timer = new Timer(20, this); // ~50fps
        timer.start();
    }

    private void loadHighScore() {
        try {
            File scoreFile = new File("highscore.txt");
            if (scoreFile.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(scoreFile));
                highScore = Integer.parseInt(reader.readLine());
                reader.close();
            }
        } catch (Exception e) {
            System.out.println("Error loading high score: " + e.getMessage());
        }
    }

    private ArrayList<String> getLastMoves(int count) {
        ArrayList<String> moves = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("moves.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    moves.add(line.trim());
                }
            }
        } catch (IOException e) {
            System.out.println("Could not read moves.txt: " + e.getMessage());
        }
        // Return the last specified number of` moves
        int from = Math.max(moves.size() - count, 0);
        return new ArrayList<>(moves.subList(from, moves.size()));
    }

    private String getPredictedMove() {
        MovePredictor predictor = new MovePredictor();
        try {
            predictor.trainFromFile("moves.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return predictor.predictNextMove();
    }


    // Saves new high score to file
    private void saveHighScore() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("highscore.txt"));
            writer.write(Integer.toString(highScore));
            writer.close();
        } catch (Exception e) {
            System.out.println("Error saving high score: " + e.getMessage());
        }
    }

    // used for deaths
    private void resetGame() {
        pacman = new Pacman(60, 40);
        pacman.setCurrent(c1);
        ghost = new Ghost(c19, gameMap, pacman);
        // ghost2 = new Ghost(c16, gameMap, pacman);
        gameRunning = true;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Draw game elements
        drawMap(g);
        pacman.draw(g);
        ghost.draw(g);
        
        // Draw score info
        g.setColor(Color.WHITE);
        g.drawString("Score: " + pacman.getScore(), 20, 15);
        g.drawString("High Score: " + highScore, 650, 15);

        g.setFont(new Font("Monospaced", Font.PLAIN, 14));
        g.setColor(Color.WHITE);

        ArrayList<String> lastMoves = getLastMoves(10);
        int xLeft = 10;
        int yStart = getHeight() - 220;
        g.drawString("Recent Moves:", xLeft, yStart);
        for (int i = 0; i < lastMoves.size(); i++) {
            g.drawString(lastMoves.get(i), xLeft, yStart + 20 * (i + 1));
        }

        // Display predicted next move
        String predicted = getPredictedMove();
        String predictionText = "Prediction: " + predicted;
        int textWidth = g.getFontMetrics().stringWidth(predictionText);
        int xRight = getWidth() - textWidth - 10;
        int yBottom = getHeight() - 20;
        g.drawString(predictionText, xRight, yBottom);
        
        // Game over message
        if (!gameRunning) {
            g.setColor(Color.RED);
            // Times New Roman looks cooler
            g.setFont(new Font("Times New Roman", Font.BOLD, 30));
            g.drawString("GAME OVER", 300, 200);
            g.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            g.drawString("Press any key to restart", 300, 250);
        }
    }

    private void drawMap(Graphics g) {
        g.setColor(Color.BLUE);
        // walls (top -> bottom)
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
        g.drawRoundRect(300, 330, 180, 10, 10, 10);
        g.drawRoundRect(300, 340, 10, 90, 10, 10);

        g.drawRoundRect(470, 340, 10, 90, 10, 10);

        // bottom wall
        g.drawRoundRect(40, 430, 270, 10, 10, 10);
        g.drawRoundRect(470, 430, 270, 10, 10, 10);

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

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameRunning) {
            pacman.update();
            ghost.update();
            
            // Check for collision
            if (Math.abs(pacman.getX() - ghost.getX()) < 30 && 
                Math.abs(pacman.getY() - ghost.getY()) < 30) {
                gameRunning = false;
                if (pacman.getScore() > highScore) {
                    highScore = pacman.getScore();
                    saveHighScore();
                }
            }
        }
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
    if (!gameRunning) {
        resetGame();
        return;
    }

    switch (e.getKeyCode()) {
        case KeyEvent.VK_A:
            pacman.requestDirectionChange(-1, 0);
            break;
        case KeyEvent.VK_D:
            pacman.requestDirectionChange(1, 0);
            break;
        case KeyEvent.VK_W:
            pacman.requestDirectionChange(0, -1);
            break;
        case KeyEvent.VK_S:
            pacman.requestDirectionChange(0, 1);
            break;
    }
}

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}