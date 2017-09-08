package com.game.demo;

import javax.swing.*;
import java.awt.*;

/**
 * Created by mengrui-g on 2017/9/8.
 */
public class SnakeApp {

    public void init() {

        Grid grid = new Grid(Config.GRID_WIDTH, Config.GRID_HEIGHT);

        JFrame window = new JFrame("Gluttonous Snake");

        //GameView初始化
        GameView gv = new GameView(grid);
        gv.init();
        //设置JPanel大小
        int w = Config.GRID_WIDTH * Config.NODE_SIZE;
        int h = Config.GRID_HEIGHT * Config.NODE_SIZE;
        gv.getCanvas().setPreferredSize(new Dimension(w, h));

        //JPanel添加到窗口
        Container pane = window.getContentPane();
        pane.add(gv.getCanvas(), BorderLayout.CENTER);


        window.pack();

        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    public static void main(String[] args) {
        SnakeApp sa = new SnakeApp();


        sa.init();
    }
}
