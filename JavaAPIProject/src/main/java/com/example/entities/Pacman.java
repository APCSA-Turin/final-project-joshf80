package com.example.entities;

import java.awt.*;

public class Pacman extends Entity{

    public Pacman(int x, int y) {
        super(x, y);
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillOval(getX(), getY(), 20, 20);
    }

    public void update() {
        if (super.dx == 0 && dy == 0) return;

        x += dx * 4;  
        y += dy * 4;

        if (x < 0) x = 800;  
        if (x > 800) x = 0;  
        if (y < 0) y = 800;  
        if (y > 800) y = 0;

    }
}
