package com.example.entities;

import java.awt.*;

import com.example.core.Core;

public class Pacman extends Entity{
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

    public void setTarget(Core newTargetCore) { targetCore = newTargetCore; }

    public Core getTarget() { return targetCore; }

    public void setCurrent(Core newCurrentCore) { currentCore = newCurrentCore; }
    
    public Core getCurrent() { return currentCore; }


    public void update() {
        if (super.dx == 0 && dy == 0) {
            return;
        }

        x += dx * 4;  
        y += dy * 4;

        if (x < 40) x = 700;  
        if (x > 700) x = 40;  
        if (y < 0) y = 430;  
        if (y > 430) y = 0;

    }
}
