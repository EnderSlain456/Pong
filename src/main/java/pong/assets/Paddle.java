package pong.assets;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Paddle {

    private static final int WIDTH = 10;
    private static final int HEIGHT = 100;
    private int x;
    private int y;
    private int ya = 0;

    public Paddle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move() {
        if (y + ya >= 0 && y + ya <= 500) {
            y += ya;
        }
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W && x < 100) {
            ya = -4;
        }
        if (key == KeyEvent.VK_S && x < 100) {
            ya = 4;
        }
        if (key == KeyEvent.VK_UP && x > 700) {
            ya = -4;
        }
        if (key == KeyEvent.VK_DOWN && x > 700) {
            ya = 4;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W && x < 100) {
            ya = 0;
        }
        if (key == KeyEvent.VK_S && x < 100) {
            ya = 0;
        }
        if (key == KeyEvent.VK_UP && x > 700) {
            ya = 0;
        }
        if (key == KeyEvent.VK_DOWN && x > 700) {
            ya = 0;
        }
    }

    public Rectangle getShape() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }
}
