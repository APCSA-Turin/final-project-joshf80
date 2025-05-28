package com.example.entities;

import java.awt.*;

import com.example.core.Core;

public class Pacman extends Entity{
    private Core currentCore;

    public Pacman(int x, int y) {
        super(x, y);
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillOval(getX(), getY(), 35, 35);
    }
    
    // Give Pacman a Core to constantly be heading towards
    public void setCurrent(Core newCurrentCore) { currentCore = newCurrentCore; }
    
    // Get said Core in order to retrieve X / Y changes nessecary
    public Core getCurrent() { return currentCore; }

    // Update Pacman position using values in superclass
    public void update() {
        if (super.dx == 0 && dy == 0) { // (no direction)
            return;
        }

        x += dx * 4;  
        y += dy * 4;

        // wrap player around
        if (x < 40) x = 700;  
        if (x > 700) x = 40;  
        if (y < 0) y = 430;  
        if (y > 430) y = 0;

    }
}
