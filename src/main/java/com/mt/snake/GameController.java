package com.mt.snake;

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap;

import java.awt.event.KeyEvent;

/**
 * Created by MT on 2017/9/10.
 */
public class GameController implements KeyListener, Runnable {

    private final Grid grid;
    private final GameView gv;

    private boolean running;


    public GameController(Grid grid, GameView gv) {
        this.grid = grid;
        this.gv = gv;
        this.running = true;

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        switch (code) {
            case KeyEvent.VK_UP:
                grid.changeDirection(Direction.UP);
                break;
            case KeyEvent.VK_DOWN:
                grid.changeDirection(Direction.DOWN);
                break;
            case KeyEvent.VK_RIGHT:
                grid.changeDirection(Direction.RIGHT);
                break;
            case KeyEvent.VK_LEFT:
                grid.changeDirection(Direction.LEFT);
                break;
        }
        System.out.println(code);
    }

    public void keyReleased(KeyEvent e) {

    }

    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(Config.MOVE_INTERVAL);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            boolean next = grid.nextStep();
            if (next == false) {
                gv.gameOver();
            }
            gv.draw();
        }
    }
}
