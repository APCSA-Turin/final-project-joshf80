package com.example.entities;

import java.awt.*;
import com.example.core.Core;

public class Pacman extends Entity {
    private Core currentCore;
    private Core targetCore; // Next core we're moving toward
    private boolean changingDirection; // Flag for intersection handling

    public Pacman(int x, int y) {
        super(x, y);
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillOval(getX(), getY(), 35, 35);
        
        // Draw score (simple version)
        g.setColor(Color.WHITE);
        g.drawString("Score: " + getScore(), 10, 20);
    }
    
    public void setCurrent(Core newCurrentCore) { 
        currentCore = newCurrentCore; 
    }
    
    public Core getCurrent() { 
        return currentCore; 
    }

    public void update() {
        if (targetCore != null) {
            // Move toward target core
            int dx = Integer.compare(targetCore.getX(), x);
            int dy = Integer.compare(targetCore.getY(), y);
            
            x += dx * 4;
            y += dy * 4;
            
            // Snap to core when close
            if (targetCore.isOnCore(x, y)) {
                x = targetCore.getX();
                y = targetCore.getY();
                currentCore = targetCore;
                targetCore = null;
                changingDirection = false;
            }
        }
    }

    public void requestDirectionChange(int dx, int dy) {
        if (currentCore == null) return;
        
        // Always allow direction changes at intersections
        if (currentCore.isIntersection() || changingDirection) {
            Core next = currentCore.getCoreInDirection(dx, dy);
            if (next != null) {
                targetCore = next;
                changingDirection = true;
            }
        }
        // For non-intersections, only allow 180° turns
        else if ((this.dx * dx < 0) || (this.dy * dy < 0)) {
            Core next = currentCore.getCoreInDirection(dx, dy);
            if (next != null) {
                targetCore = next;
            }
        }
    }
}