package pong.assets;


import pong.GamePanel;
import pong.score.P1Score;
import pong.score.P2Score;

import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.util.concurrent.TimeUnit;

public class Ball {

    private static final int DIAMETER = 30;
    private int x = 386;
    private int y = 286;
    private int xa = 5;
    private int ya = 5;

    public void move() {
        x += xa;
        y += ya;
        if (x <= 0 || x >= 770) {
            xa = -xa;
        }
        if (y <= 0 || y >= 550) {
            ya = -ya;
        }
    }

    public void checkCollision(Rectangle leftPaddle, Rectangle rightPaddle) throws InterruptedException {

        if (x <= 1 || x >= 769) {
            if ( x <= 1) {
                P2Score.Score();
            } else {
                P1Score.Score();

            }

            GamePanel.leftPaddle = new Paddle(10, 250);
            GamePanel.rightPaddle = new Paddle(770, 250);

            x = 386;
            y = 286;

            xa = 0;
            ya = 0;

            TimeUnit.SECONDS.sleep(1);

            xa = 5;
            ya = 5;
            x += xa;
            y +=ya;

        }

        if (getBounds().intersects(leftPaddle) || getBounds().intersects(rightPaddle)) {
            xa = -xa;
        }
    }

    public Ellipse2D getShape() {
        return new Ellipse2D.Double(x, y, DIAMETER, DIAMETER);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }
}
