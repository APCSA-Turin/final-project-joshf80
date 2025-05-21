package com.example.entities; 

import java.awt.*;

public class Entity {
    protected int x, y;
    protected int dx;
    protected int dy;

    public Entity(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void changeDirection(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public void move() {
        x += dx * 4;
        y += dy * 4;
    }

    public void draw(Graphics g) {  }

}
