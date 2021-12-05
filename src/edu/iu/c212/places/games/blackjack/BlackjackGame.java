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
    private static int[] nums = new int[]{1,2,3,4,5,6,7,8,9,10,10,10,10};
    private static Random rand = new Random();
    private static boolean isAOne;


    public BlackjackGame(Arcade arc) {

    }
    public void onEnter(User user) {

    }
    public static class hitButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int addNum = nums[rand.nextInt(nums.length)];
            // we want to add numbers to both first and second, regardless, but then add differently and show as long as second is
            if ((handTotals[0] + addNum) > 21) {
                totalsLabel.setText("BUST");
                hit.setEnabled(false);
                stay.setEnabled(false);
                System.out.println("bust");
                totalsLabel.setText("BUST");
            } else {

                if (addNum == 1) {
                    isAOne = true;
                    handTotals[0] += 1;
                    handTotals[1] += 11;
                } else {
                    handTotals[0] += addNum;
                    handTotals[1] += addNum;
                }
                if (handTotals[0] != handTotals[1] && handTotals[1] < 21) {
                    totalsLabel.setText("Your first  hand total: " + handTotals[0] + "and your second hand total: " + handTotals[1]);
                } else {
                    totalsLabel.setText("Your hand total: " + handTotals[0]);
                }
                System.out.println(isAOne);
            }
        }
    }
    public static class stayButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            hit.setEnabled(false);
            stay.setEnabled(false);

        }
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame = new JFrame();
        frame.setTitle("MouseListenerDemo");
        frame.setSize(420,420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel();
        JPanel statusPanel = new JPanel();
        int firstNum = nums[rand.nextInt(nums.length)];
        int secondNum = nums[rand.nextInt(nums.length)];
        if (firstNum == 1) {
            handTotals[0] = 1 + secondNum;
            handTotals[1] = 11 + secondNum;
        }
        else if (secondNum == 1) {
            handTotals[0] = 1 + firstNum;
            handTotals[1] = 11 + firstNum;
        }
        int sum = firstNum + secondNum;
        System.out.println("sum " + sum);
        handTotals[0] = sum;
        handTotals[1] = sum;
        totalsLabel = new JLabel("Your hand total: " + sum);
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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
