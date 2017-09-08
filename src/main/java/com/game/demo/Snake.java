package com.game.demo;

import java.util.LinkedList;
import java.util.Map;

/**
 * Created by mengrui-g on 2017/9/8.
 */
public class Snake {

    private LinkedList<Node> body = new LinkedList<Node>();

    private Direction direction;

    public Node move(Direction direction) {

        Node head = getHead();

        int x = 0, y = 0;
        switch (direction) {
            case UP:
                x = head.getX();
                y = head.getY() + 1;
                break;
            case RIGHT:
                x = head.getX() + 1;
                y = head.getY();
                break;
            case DOWN:
                x = head.getX();
                y = head.getY() - 1;
                break;
            case LEFT:
                x = head.getX() - 1;
                y = head.getY();
                break;
        }

        Node nhead = new Node(x, y);
        addTail(nhead);
        return this.body.pollLast();
    }


    /**
     * 如果头部和food相邻，添加到body
     * TODO还需要判断Snake的运动方向和food是否一致。
     * @param food
     * @return Node
     */
    public Node eat(Node food) {
        if (isNeighbor(body.getFirst(), food)) {
            this.body.addFirst(food);
            return food;
        }
        return null;
    }

    /**
     * 判断两点是否相邻。
     * @param a
     * @param b
     * @return
     */
    private boolean isNeighbor(Node a, Node b) {
        return Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY()) == 1;
    }

    public Node getHead() {
        return this.body.getFirst();
    }

    /**
     * 添加尾部，在吃到节点的时候调用
     * @param node
     * @return
     */
    public Node addTail(Node node) {
        this.body.addLast(node);
        return node;
    }

    public LinkedList<Node> getBody() {
        return this.body;
    }
}
