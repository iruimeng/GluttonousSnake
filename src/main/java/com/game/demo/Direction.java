package com.game.demo;

/**
 * Created by mengrui-g on 2017/9/8.
 */

public enum Direction {
    UP(0),
    RIGHT(1),
    DOWN(2),
    LEFT(3);

    private final int directionCode;

    public int directionCode() {
        return directionCode;
    }

    Direction(int directionCode) {
        this.directionCode = directionCode;
    }
}

