package com.example.core;

import java.util.ArrayList;

// Manages all cores and pathfinding functions
public class CoreMap {
    private ArrayList<Core> allCores;

    public CoreMap() {
        allCores = new ArrayList<Core>();
    }

    public void addCore(Core core) {
        if (!allCores.contains(core)) {
            allCores.add(core);
        }
    }

    // Finds nearest core to given coordinates
    public Core findNearestCore(int x, int y) {
        Core nearest = null;
        double minDistance = Double.MAX_VALUE; // since we are looking for lesser values

        for (Core core : allCores) {
            double distance = Math.sqrt(Math.pow(x - core.getX(), 2) + Math.pow(y - core.getY(), 2));
            if (distance < minDistance) {
                minDistance = distance;
                nearest = core;
            }
        }
        return nearest;
    }

    // Basic pathfinding - will be used by ghosts
    public ArrayList<Core> findPath(Core start, Core target) {
        // TODO: Implement simple pathfinding
        // For now just returns direct path if neighbors
        ArrayList<Core> path = new ArrayList<Core>();
        Core currentCore = start;
        double totalDistance = 0;

        for (Core core : currentCore.getNeighborCores()) {
            double projectedTotal;
        }

        return path;
    }

    // chase algorithm
    public Core getNextCoreToward(Core current, Core target) {
        Core bestCore = null;
        
        
        return bestCore;
    }
}