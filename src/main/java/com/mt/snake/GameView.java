package com.mt.snake;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * Created by MT on 2017/9/8.
 */
public class GameView {

    private final Grid grid;

    private JPanel canvas;

    public void init() {
        canvas = new JPanel() {
            @Override
            public void paintComponent(Graphics graphics) {
                drawBg(graphics);

                drawSnake(graphics, grid.getSnake());

                drawFood(graphics, grid.getFood());
            }
        };
    }

    public GameView(Grid grid) {
        this.grid = grid;
    }

    public JPanel getCanvas() {
        return canvas;
    }

    public void draw() {
        Graphics graphics = canvas .getGraphics();
        drawSnake(graphics, grid.getSnake());
        drawFood(graphics, grid.getFood());
        canvas.repaint();
    }

    private int ns = Config.NODE_SIZE;

    private void drawSquare(Graphics graphics, Node node, Color color) {
        graphics.setColor(color);
        graphics.fillRect(node.getX() * ns, node.getY() * ns, ns - 1, ns - 1);
    }

    private void drawCycle(Graphics graphics, Node node, Color color) {
        graphics.setColor(color);
        graphics.fillOval(node.getX() * ns, node.getY() * ns, ns, ns);
    }

    public void drawBg(Graphics graphics) {
        graphics.setColor(new Color(0, 0, 0));
        graphics.fillRect(0,0, grid.getWidth() * ns, grid.getHeight() * ns);
    }

    /**
     * 画snake，遍历每个节点画矩形
     * @param graphics
     * @param snake
     */
    public void drawSnake(Graphics graphics, Snake snake) {
        Color c = Color.green;
        Iterator<Node> it = snake.getBody().iterator();
        while (it.hasNext()) {
            Node n = it.next();
            drawSquare(graphics, n, c);
        }
    }

    /**
     * 画food
     * @param graphics
     * @param food
     */
    public void drawFood(Graphics graphics, Node food) {
        drawCycle(graphics, grid.getFood(), Color.green);
    }

    public void gameOver() {
        JOptionPane.showMessageDialog(null, "游戏结束", "游戏结束", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

}
