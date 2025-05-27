package com.example.core;

import java.util.ArrayList;

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

    public void addNeighbor(Core neighbor) {
        if (!neighborCores.contains(neighbor)) {
            neighborCores.add(neighbor);
            neighbor.addNeighbor(this);
        }
    }

    public Core checkDirection(int direction) {
        for (Core core : neighborCores) {
            if(direction == -1) /* left */ {
                if (core.getY() == getY()) {
                    if (core.getX() < getX()) {
                        return core;
                    }
                }
            }

            if(direction == 0) /* up */ {
                if (core.getX() == getX()) {
                    if (core.getY() > getY()) {
                        return core;
                    }
                }
            }

            if(direction == 1) /* right */ {
                if (core.getY() == getY()) {
                    if (core.getX() > getX()) {
                        return core;
                    }
                }
            }

            
            if(direction == 2) /* down */ {
                if (core.getX() == getX()) {
                    if (core.getY() > getY()) {
                        return core;
                    }
                }
            }
        }

        return null;
    }

    public Boolean onCore(int x2, int y2) {
        if (x2 > x - 10 && x2 < x + 10) {
            if (y2 > y - 10 && y2 < y + 10) {
                return true;
            }
        }
        return false;
    }
}
