package pong.score;

import javax.swing.*;

public class P1Score extends JLabel {

    public static int score1 = 0;
    public static JLabel update1 = new JLabel("P1: " + score1);

    public static void Score() {
        score1 = score1 + 1;
        update1.setText("P1: " + score1);
        update1.setBounds(200, 20, 100, 30);
        update1.validate();
        update1.repaint();
    }

    public static JLabel getScore1() {
        return update1;
    }
}
