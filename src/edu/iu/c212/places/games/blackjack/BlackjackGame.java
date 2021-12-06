package edu.iu.c212.places.games.blackjack;
import edu.iu.c212.Arcade;
import edu.iu.c212.models.User;
import edu.iu.c212.places.games.Game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Random;

public class BlackjackGame extends Game {
    private static int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
    protected int [] handTotals = new int[10];
    private static Random rand = new Random();
    private static boolean bust = false;
    private static JLabel totalsLabel;
    private static JButton hit;
    private static JButton stay;
    static BlackjackPlayer player;
    static BlackjackDealer dealer;
    public static boolean isRunning;

    private Object lock;
    public static Thread t;


    public BlackjackGame(Arcade arcade) {
        super(arcade,"Blackjack",10);
        setArcade(arcade);
        setEntryFee(10);
        setPlaceName("Blackjack");
    }

    public void bust() {

    }

    @Override
    public void play() {

    }

    public void onEnter(User user) {
        BlackjackPlayer player = new BlackjackPlayer();
        BlackjackDealer dealer = new BlackjackDealer();
        User User = new User();

        JFrame frame = new JFrame();
        frame = new JFrame();
        frame.setTitle("MouseListenerDemo");
        frame.setSize(420, 420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel();
        JPanel statusPanel = new JPanel();

        totalsLabel = new JLabel("Your hand total: " + handTotals[0]);
        statusPanel.add(totalsLabel);
        JPanel buttonsPanel = new JPanel();
        JLabel dealerLabel = new JLabel("Dealer's hand: " + nums[rand.nextInt(nums.length)] + ", ???");

        hit = new JButton("Hit!");
        stay = new JButton("stay");
        buttonsPanel.add(hit);
        buttonsPanel.add(stay);
        statusPanel.add(dealerLabel);
        mainPanel.add(statusPanel);
        mainPanel.add(buttonsPanel);
        hit.addActionListener(new hitButtonListener());
        stay.addActionListener(new stayButtonListener());


        frame.add(mainPanel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        lock = new Object();
        JFrame finalFrame = frame;
        t = new Thread (() -> {
            synchronized (lock) {
                while (finalFrame.isVisible()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException ignored) {}
                }
            }
        });
        t.start();

        isRunning = true;


    }
    public static class WindowClosedListener implements WindowListener {

        @Override
        public void windowOpened(WindowEvent e) {}

        @Override
        public void windowClosing(WindowEvent e) {}

        @Override
        public void windowClosed(WindowEvent e) {
            if (isRunning) {
                System.out.println("By exiting mid-game, you've chose to forfeit");
                System.out.println("Goodbye!");

            }
            else {
                if (player.getBestTotal() > dealer.getBestTotal()) {
                    System.out.println("Congratulations! you won $50!!");
                    //give player some money
                    System.out.println("\n Hope to see you again soon!");

                }
            }
        }

        @Override
        public void windowIconified(WindowEvent e) {}

        @Override
        public void windowDeiconified(WindowEvent e) {}

        @Override
        public void windowActivated(WindowEvent e) {}

        @Override
        public void windowDeactivated(WindowEvent e) {}
    }

    public static class stayButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            dealer.play();

            hit.setEnabled(false);
            stay.setEnabled(false);

        }
    }

    public static class hitButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            player.hit();
            if (player.getBust()) {
                totalsLabel.setText("BUST");
                hit.setEnabled(false);
                stay.setEnabled(false);
                System.out.println("bust");
                totalsLabel.setText("BUST");
                isRunning = false;
                //write losing code here
            } else {
                totalsLabel.setText(player.getCurrentTotalsString());
            }
        }
    }
}