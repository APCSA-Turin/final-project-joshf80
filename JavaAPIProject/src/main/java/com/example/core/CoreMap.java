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

    // BFS pathfinding - will be used by ghosts
    public ArrayList<Core> findPath(Core start, Core target) {
        Queue<Core> queue = new LinkedList<>();
        HashMap<Core, Core> cameFrom = new HashMap<>();
        HashSet<Core> visited = new HashSet<>(); // hash solves effeciency issue

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

        // Trace path
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