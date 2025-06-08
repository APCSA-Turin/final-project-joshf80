package com.example.entities;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;

import com.example.core.Core;

// Pacman entity logic and movement
public class Pacman extends Entity {
    private Core currentCore;
    private Core targetCore;

    public Pacman(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillOval(getX(), getY(), 35, 35);
    }

    public void setCurrent(Core newCurrentCore) {
        currentCore = newCurrentCore;
    }

    public Core getCurrent() {
        return currentCore;
    }

    public void update() {
        if (targetCore != null) {
            // Move toward target core, based on comparison of positions
            int dx = Integer.compare(targetCore.getX(), x);
            int dy = Integer.compare(targetCore.getY(), y);

            x += dx * 4;
            y += dy * 4;


            // Snap to core when close so that there’s no misalignment
            if (targetCore.isOnCore(x, y)) {
                x = targetCore.getX();
                y = targetCore.getY();
                currentCore = targetCore; // avoid weird movement
                score++;
            }
        }
    }

    // Called when user changes direction
    public void requestDirectionChange(int dx, int dy) {

        if (currentCore == null) return;

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("moves.txt", true));
            if (dx == 0 && dy == 1) {
                writer.write("down");
            }
            else if (dx == 1 && dy == 0) {
                writer.write("right");
            }
            else if (dx == 0 && dy == -1) {
                writer.write("up");
            }
            else if (dx == -1 && dy == 0) {
                writer.write("left");
            }
            writer.newLine();
            writer.close();
        } catch (Exception e) {
            System.out.println("Error saving high score: " + e.getMessage());
        }


        Core next = currentCore.getCoreInDirection(dx, dy);
        if (next != null) {
            currentCore = null;
            targetCore = next;
        }
    }
}