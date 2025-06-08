package com.example.entities;

import java.awt.*;
import java.util.*;
import com.example.core.*;

// Ghost entity logic
public class Ghost extends Entity {
    private Core currentCore;
    private Core targetCore;
    private CoreMap gameMap;
    private Pacman pacman;
    private ArrayList<Core> path = new ArrayList<>();
    private int pathIndex = 0;

    public Ghost(Core start, CoreMap map, Pacman pacmanRef) {
        super(start.getX(), start.getY()); // Call the correct constructor
        this.currentCore = start;
        this.targetCore = start;
        this.gameMap = map;
        this.pacman = pacmanRef;
    }


    @Override
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(getX(), getY(), 35, 35);
    }

    public void update() {
        if (currentCore == null) return; // null reference error

        // If no target or reached current target, recalculate path
        if (targetCore == null || targetCore == currentCore) {
            path = gameMap.findPath(currentCore, pacman.getCurrent()); // returns path in order as array
            pathIndex = 0;

            if (path != null && path.size() > 1) {
                targetCore = path.get(1); // Skip current core
            }
        }

        // Movement toward next core
        if (targetCore != null) {
            // set ghost direction to face next core
            int dx = Integer.compare(targetCore.getX(), x); // direction on x plane
            int dy = Integer.compare(targetCore.getY(), y); // direction on yplane

            // 4 pixels per tick in direction of core
            x += dx * 4;
            y += dy * 4;

            // Snap to core if reached
            if (targetCore.isOnCore(x, y)) {
                //set ghost x, y to core x,y
                x = targetCore.getX();
                y = targetCore.getY();
                currentCore = targetCore; // reached core on path

                if (pathIndex++ < path.size()) { 
                    targetCore = path.get(pathIndex);// goto next core in path
                } else {
                    targetCore = null; // finished path
                }
            }
        }
    }

    public void setCurrent(Core core) {
        this.currentCore = core;
    }
}
