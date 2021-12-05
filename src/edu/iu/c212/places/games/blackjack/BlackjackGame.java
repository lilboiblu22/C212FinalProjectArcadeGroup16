package edu.iu.c212.places.games.blackjack;
import edu.iu.c212.Arcade;
import edu.iu.c212.models.User;
import edu.iu.c212.places.games.Game;

//public class BlackjackGame extends Game  {
//
//    @Override
//    public void play() {
//
//    }
//
//}


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class BlackjackGame extends Game {
    private static int[] handTotals = new int[10];
    private static boolean bust = false;
    private static JLabel totalsLabel;
    private static JButton hit;
    private static JButton stay;
    private static int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
    private static Random rand = new Random();
    private static boolean isAOne;


    public BlackjackGame(Arcade arc) {

    }

    @Override
    public void play() {

    }

    public void onEnter(User user) {
        BlackjackPlayer player = new BlackjackPlayer();
        BlackjackDealer dealer = new BlackjackDealer();

        JFrame frame = new JFrame();
        frame = new JFrame();
        frame.setTitle("MouseListenerDemo");
        frame.setSize(420,420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel();
        JPanel statusPanel = new JPanel();



    }

    public static class stayButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            hit.setEnabled(false);
            stay.setEnabled(false);

        }
    }
}