package com.example.entities;

import java.awt.*;
import com.example.core.Core;
import com.example.ui.*;;

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
                currentCore = targetCore;
                targetCore = null;
                score++;
            }
        }
    }

    // Called when user changes direction
    public void requestDirectionChange(int dx, int dy) {
        if (currentCore == null) return;


        Core next = currentCore.getCoreInDirection(dx, dy);
        if (next != null) {
            currentCore = null;
            targetCore = next;
        }
    }
}