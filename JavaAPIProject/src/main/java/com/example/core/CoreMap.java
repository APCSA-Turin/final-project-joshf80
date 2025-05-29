package com.example.core;

import java.util.ArrayList;

// Manages all cores and provides pathfinding functions
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
        double minDistance = Double.MAX_VALUE;
        
        for (Core core : allCores) {
            double dist = Math.sqrt(Math.pow(x - core.getX(), 2) + Math.pow(y - core.getY(), 2));
            if (dist < minDistance) {
                minDistance = dist;
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
        if (start.getNeighborCores().contains(target)) {
            path.add(target);
        }
        return path;
    }

    // Simple chase algorithm - picks direction that gets ghost closer to target
    public Core getNextCoreToward(Core current, Core target) {
        Core bestCore = null;
        double minDistance = Double.MAX_VALUE;
        
        for (Core neighbor : current.getNeighborCores()) {
            double dist = neighbor.distanceTo(target);
            if (dist < minDistance) {
                minDistance = dist;
                bestCore = neighbor;
            }
        }
        return bestCore;
    }
}