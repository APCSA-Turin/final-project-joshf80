package com.example.core;

import java.util.ArrayList;

// Cores are used at intersection points to identify which possible moves entities could make
public class Core {
      private int x, y;
    private ArrayList<Core> neighborCores;

    public Core(int x, int y) {
        this.x = x;
        this.y = y;
        this.neighborCores = new ArrayList<Core>();
    }


    public int getX() { return x; }
    public int getY() { return y; }

    // Method used to connect the cores
    public void addNeighbor(Core neighbor) {
        if (!neighborCores.contains(neighbor)) {
            neighborCores.add(neighbor);
            neighbor.addNeighbor(this); // bidirectional connection
        }
    }

    // Returns all connected cores
    public ArrayList<Core> getNeighborCores() {
        return neighborCores;
    }

    // Returns which core is available in given direction (-1 = left / down | 1 = right / up)
    public Core getCoreInDirection(int dx, int dy) {

        for (Core neighbor : neighborCores) {

            if (dx == -1 && neighbor.getX() < x && neighbor.getY() == y) {
                return neighbor;
            }
            if (dx == 1 && neighbor.getX() > x && neighbor.getY() == y) {
                return neighbor;
            }
            if (dy == -1 && neighbor.getY() < y && neighbor.getX() == x) {
                return neighbor;
            }
            if (dy == 1 && neighbor.getY() > y && neighbor.getX() == x) {
                return neighbor;
            }
        }
        return null;
    }

    // position checking for when moving is possible
    public boolean isOnCore(int x, int y) {
        int threshold = 3; // snapping threshold (so user keystrokes dont have to be so precise)
        return x > this.x - threshold && x < this.x + threshold &&
               y > this.y - threshold && y < this.y + threshold;
    }
}   