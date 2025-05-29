package com.example.entities;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import com.example.core.Core;

public class Ghost extends Entity {
    private Core currentCore;
    private Random random;
    
    public Ghost(int x, int y) {
        super(x, y);
        random = new Random();
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(getX(), getY(), 35, 35);
    }
    
    public void setCurrent(Core core) {
        currentCore = core;
    }
    
    public void update() {
        if (currentCore == null) return;
        // Basic movement
        x += dx * 3;
        y += dy * 3;
    }
}