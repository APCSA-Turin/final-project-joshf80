package com.example.core;

import java.util.ArrayList;


// Cores are used at intersection points to identify which possible moves entities could make
public class Core {
    private int x, y; // position of core
    private ArrayList<Core> neighborCores; // holds which cores are available to each core.

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
            neighbor.addNeighbor(this); // <--> bidirectional connection to avoid excess code
        }
    }

    // returns which core is available at current entities core, given a direction
    public Core checkDirection(int direction) {
        for (Core core : neighborCores) {
            if(direction == -1) /* left */ {
                if (core.getY() == getY()) { 
                    if (core.getX() < getX()) { // if neighbor core is to the left of current core
                        return core;
                    }
                }
            }

            if(direction == 0) /* up */ {
                if (core.getX() == getX()) {
                    if (core.getY() > getY()) { // if neighbor core is over the current core
                        return core;
                    }
                }
            }

            if(direction == 1) /* right */ {
                if (core.getY() == getY()) {
                    if (core.getX() > getX()) { // if neighbor core is to the right of current core
                        return core;
                    }
                }
            }

            
            if(direction == 2) /* down */ {
                if (core.getX() == getX()) {
                    if (core.getY() > getY()) { // if neighbor core is below the current core
                        return core;
                    }
                }
            }
        }

        return null;
    }

    public Boolean onCore(int x2, int y2) {
        // Check if given coordinates are within the space of the core (allows for less precise key movement)
        if (x2 > x - 10 && x2 < x + 10) {
            if (y2 > y - 10 && y2 < y + 10) {
                return true;
            }
        }
        return false;
    }
}
