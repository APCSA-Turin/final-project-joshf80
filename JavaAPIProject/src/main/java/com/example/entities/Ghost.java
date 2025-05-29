package com.example.entities;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import com.example.core.Core;

public class Ghost extends Entity {
    private Core currentCore;
    private Random random;
    
    public Ghost(int x, int y) {  // Keep original constructor
        super(x, y);
        random = new Random();
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(getX(), getY(), 35, 35);
    }
    
    public void setCurrent(Core core) {  // Add this method to match usage
        currentCore = core;
    }
    
    public void update() {
        if (currentCore == null) return;
        
        // Simple random movement between cores
        if (random.nextInt(50) == 0) {
            ArrayList<Core> neighbors = currentCore.getNeighborCores();
            if (!neighbors.isEmpty()) {
                Core next = neighbors.get(random.nextInt(neighbors.size()));
                int dx = Integer.compare(next.getX(), currentCore.getX());
                int dy = Integer.compare(next.getY(), currentCore.getY());
                super.changeDirection(dx, dy);
                currentCore = next;
            }
        }
        
        // Basic movement
        x += dx * 3;
        y += dy * 3;
    }
}