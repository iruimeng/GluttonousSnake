package com.game.demo;

import lombok.Data;

/**
 * Created by mengrui-g on 2017/9/8.
 */
@Data
public class Node {
    private final int x;
    private final int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * 对比是否相等
     * @param ano another Node
     * @return boolean
     */
    public boolean equals(Node ano) {
        if (this.getX() == ano.getX() && this.getY() == ano.getY()) {
            return true;
        }
        return false;
    }


}
