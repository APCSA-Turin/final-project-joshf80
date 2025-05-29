package com.example.entities; 

import java.awt.*;

public class Entity {
    protected int x, y;
    protected int dx;
    protected int dy;
    protected int score; // score tracking

    public Entity(int x, int y) {
        this.x = x;
        this.y = y;
        this.score = 0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getScore() { // New getter for score
        return score;
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