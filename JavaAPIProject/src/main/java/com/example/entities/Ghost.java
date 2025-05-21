package com.example.entities;

import java.awt.*;

public class Ghost extends Entity {

    public Ghost(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(getX(), getY(), 20, 20);
    }
    
    public void update() {
        
    }
}
