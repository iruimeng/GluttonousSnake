package com.mt.snake;

import java.util.Random;

/**
 * Created by mengrui-g on 2017/9/8.
 */
public class Grid {

    private final int wigth;
    private final int height;

    //表格覆盖情况
    private final boolean status[][];

    private Snake snake;

    private Node food;

    //初始化默认前进方向
    private Direction snakeDireciton = Direction.LEFT;


    public Grid(int wigth, int height) {
        this.wigth = wigth;
        this.height = height;
        status = new boolean[wigth][height];

        initSnake();
        makeFood();
    }

    /**
     * 初始化逻辑
     * @return
     */
    private Snake initSnake() {
        snake = new Snake();

        int x = (int) Math.ceil(wigth/2);
        int y = (int) Math.ceil(height/2);
        //设置snake的body
        for (int i = 0; i < 4; i++) {
            x += 1;
            Node node = new Node(x , y);
            snake.addTail(node);
            System.out.println("init:" + node);
            //更新棋盘覆盖状态
            status[x][y] = true;
        }
        return snake;
    }

    public void changeDirection(Direction d) {
        if (snakeDireciton.equals(d)) {
            return;
        }
        snakeDireciton = d;
    }

    public boolean nextStep() {
        Node head = snake.getHead();

        //当前头是否合法的next
        if (isBoundary(head)) {

            //移动一步
            Node tail = snake.move(snakeDireciton);
            //头部和食物吻合，再把尾巴添加回去
            if (snake.getHead().equals(food)) {
                snake.addTail(tail);
            }
            return true;
        }
        return false;
    }

    private boolean isBoundary(Node node) {
        int x = node.getX();
        int y = node.getX();
        //碰到边界
        if (x == 0 && snakeDireciton == Direction.LEFT) {
            return false;
        }
        if (x == wigth - 1 && snakeDireciton == Direction.RIGHT) {
            return false;
        }
        if (y == 0 && snakeDireciton == Direction.DOWN ) {
            return false;
        }
        if (y == height - 1 && snakeDireciton == Direction.UP) {
            return false;
        }
        return true;
    }

    private Node makeFood() {

        int x, y;
        x = new Random().nextInt(Config.GRID_WIDTH/2);
        y = new Random().nextInt(Config.GRID_HEIGHT);

        System.out.println(x);
        System.out.println(y);

        food = new Node(x, y);
        return food;
    }

    public Snake getSnake() {
        return snake;
    }
    public Node getFood() {
        return food;
    }

    public int getWidth() {
        return wigth;
    }
    public int getHeight() {
        return height;
    }
}
