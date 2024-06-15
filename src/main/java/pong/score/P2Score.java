package pong.score;

import javax.swing.*;

public class P2Score {

    public static int score2 = 0;
    public static JLabel update2 = new JLabel("P2: " + score2);

    public static void Score() {
        score2 = score2 + 1;
        update2.setText("P2: " + score2);
        update2.setBounds(550 , 20, 100, 30);
        update2.validate();
        update2.repaint();

    }

    public static JLabel getScore2() {
        return update2;
    }
}
