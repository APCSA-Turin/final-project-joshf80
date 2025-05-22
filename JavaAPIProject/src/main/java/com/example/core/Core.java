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

    public void addNeighbor(Core neighbor) {
        if (!neighborCores.contains(neighbor)) {
            neighborCores.add(neighbor);
            neighbor.addNeighbor(this);
        }
    }
}
