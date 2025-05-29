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

    // chase algorithm
    public Core getNextCoreToward(Core current, Core target) {
        Core bestCore = null;
        
        
        return bestCore;
    }
}