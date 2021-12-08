package edu.iu.c212.places.games.blackjack;

public class BlackjackPlayer extends BlackjackParticipant {
    protected int []handTotals = new int[10];
    public BlackjackPlayer() {
        hit();
        hit();
    }
    @Override
    public int getBestTotal() {
        if (handTotals[1] <= 21) {
            return handTotals[1];
        }
        else {
            return handTotals[0];
        }

    }


    @Override
    public void hit() {
        int addNum = nums[rand.nextInt(nums.length)];
        // we want to add numbers to both first and second, regardless, but then add differently and show as long as second is
        if ((handTotals[0] + addNum) > 21) {
            bust = true;
        } else {

            if (addNum == 1) {
                isAOne = true;
                handTotals[0] += 1;
                handTotals[1] += 11;
            } else {
                handTotals[0] += addNum;
                handTotals[1] += addNum;
            }
        }
    }
}
