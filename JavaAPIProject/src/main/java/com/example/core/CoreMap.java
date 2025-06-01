package com.example.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

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
        Queue<Core> queue = new LinkedList<>();
        HashMap<Core, Core> cameFrom = new HashMap<>();
        HashSet<Core> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Core current = queue.poll();

            if (current.equals(target)) {
                break;
            }

            for (Core neighbor : current.getNeighborCores()) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                    cameFrom.put(neighbor, current);
                }
            }
        }

        // Reconstruct path
        ArrayList<Core> path = new ArrayList<>();
        Core current = target;

        // If no path was found
        if (!cameFrom.containsKey(target)) return path;

        while (!current.equals(start)) {
            path.add(0, current);
            current = cameFrom.get(current);
        }
        path.add(0, start);

        return path;
    }

    // chase algorithm
    public Core getNextCoreToward(Core current, Core target) {
        ArrayList<Core> path = findPath(current, target);
        if (path.size() > 1) {
            return path.get(1); // The first step after current
        }
        return null;
    }
}