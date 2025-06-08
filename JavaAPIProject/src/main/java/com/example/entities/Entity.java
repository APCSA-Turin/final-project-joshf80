package com.example.entities; 

import java.awt.*;

public class Entity {
    // parent class for ghost and pacman

    // chose to implement protected modifiers, so that the ghost and pacman classes can still access
    protected int x, y;
    protected int dx;
    protected int dy;
    protected int score; // score tracking

    public Entity(int x, int y) {
        // position on screen
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

    public int getScore() {
        return score;
    }


    public void move() {
        x += dx * 4;
        y += dy * 4;
    }

    public void draw(Graphics g) {  }
}