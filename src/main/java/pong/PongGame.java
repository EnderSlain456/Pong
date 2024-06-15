package pong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static pong.score.P1Score.getScore1;
import static pong.score.P2Score.getScore2;

public class PongGame extends JFrame implements ActionListener {

    private GamePanel gamePanel;

    public static Dimension ScreenSize;

    public PongGame() {
        setTitle("Pong Game");
        setSize(800, 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        ScreenSize = getSize();
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource("/icon/pong.png"));
            this.setIconImage(icon.getImage());
        } catch (Exception e) {
            System.out.println("Icon image not found: " + e.getMessage());
        }

        JLabel score1 = getScore1();
        JLabel score2 = getScore2();

        gamePanel = new GamePanel();
        gamePanel.setLayout(null);
        add(gamePanel);
        score1.setForeground(Color.WHITE);
        score1.setBounds(200, 20, 100, 30);
        score2.setForeground(Color.WHITE);
        score2.setBounds(550, 20, 100, 30);
        gamePanel.add(score1);
        gamePanel.add(score2);


        Timer timer = new Timer(10, this);
        timer.start();

        System.out.println("ScreenSize: " + ScreenSize);
    }

    public void Screensize() {
        ScreenSize = getSize();
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            gamePanel.updateGame();
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        gamePanel.repaint();
    }

    public static void main(String[] args) {
        PongGame game = new PongGame();
        game.setVisible(true);
    }
}
