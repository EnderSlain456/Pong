package pong;
import pong.assets.Ball;
import pong.assets.CenterLine;
import pong.assets.Paddle;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



public class GamePanel extends JPanel {


    private Ball ball;
    public static Paddle leftPaddle;
    public static Paddle rightPaddle;

    private CenterLine center;

    public GamePanel() {
        setBackground(Color.BLACK);

        center = new CenterLine();


        ball = new Ball();
        leftPaddle = new Paddle(10, 250);
        rightPaddle = new Paddle(770, 250);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                leftPaddle.keyPressed(e);
                rightPaddle.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                leftPaddle.keyReleased(e);
                rightPaddle.keyReleased(e);
            }
        });
        setFocusable(true);
    }

    public void updateGame() throws InterruptedException {
        ball.move();
        ball.checkCollision(leftPaddle.getBounds(), rightPaddle.getBounds());
        leftPaddle.move();
        rightPaddle.move();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.WHITE);
        g2d.fill(ball.getShape());
        g2d.fill(center.getShape());
        g2d.fill(leftPaddle.getShape());
        g2d.fill(rightPaddle.getShape());

    }
}
