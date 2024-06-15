package pong.assets;

import java.awt.*;

public class CenterLine {

    private static final int WIDTH = 5;
    private static final int HEIGHT = 600;
    private int x;
    private int y;


    public Rectangle getShape() {
        return new Rectangle(x = 390, y = 0 , WIDTH, HEIGHT);
    }
}
