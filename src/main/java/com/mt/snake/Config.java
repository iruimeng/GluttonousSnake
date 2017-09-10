package com.mt.snake;

/**
 * Created by MT on 2017/9/8.
 */
public class Config {

    /**
     * 单个格子大小
     */
    public static final int NODE_SIZE = 12;

    /**
     * 棋盘格子长宽的个数
     * 画图的像素点长度需要GRID_WIDTH * NODE_SIZE
     */
    public static final int GRID_WIDTH = 60;
    public static final int GRID_HEIGHT = 40;

    /**
     * 移动间隔时间，毫秒
     */
    public static final int MOVE_INTERVAL = 500;
}
