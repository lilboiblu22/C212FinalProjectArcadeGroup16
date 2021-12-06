package edu.iu.c212.places.games.blackjack;

public class BlackjackDealer extends BlackjackParticipant {

    private int shownCard;
    private int dealerBest;
    private boolean firstCard;
    public BlackjackDealer() {
        hit();
        hit();
        firstCard = true;
    }
    @Override public void hit() {
        if ((handTotals[0] + addNum) > 21) {
            bust = true;
        }
        else {
            int addNum = nums[rand.nextInt(nums.length)];
            if (addNum == 1) {
                isAOne = true;
                handTotals[0] += 1;
                handTotals[1] += 11;
            } else {
                handTotals[0] += addNum;
                handTotals[1] += addNum;
            }
        }
        if (firstCard = true) {
            shownCard = addNum;
            firstCard = false;
        }

    }


    public String getPartialHand () {
        return shownCard + "???";

    }
    public void play() {
        if (bust) {
            dealerBest = -1;
        }
        if (getBestTotal() <= 17) {
            hit();

        }

    }
}
