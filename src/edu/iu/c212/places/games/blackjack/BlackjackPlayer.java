package edu.iu.c212.places.games.blackjack;

public class BlackjackPlayer extends BlackjackParticipant {
    public BlackjackPlayer() {
        this.handTotals = handTotals;
        hit();
        hit();
    }
    public String getCurrentTotalsString() {
// <<<<<<< master-two
//         return null;
//     }
// =======
//         if (handTotals[0] != handTotals[1] && handTotals[1] < 21) {

//             return ("Your first  hand total: " + handTotals[0] + "and your second hand total: " + handTotals[1]);
//         } else {
//             return("Your hand total: " + handTotals[0]);
//         }
// >>>>>>> master

    public int getBestTotal() {
        return 0;
    }


    @Override
    public void hit() {
    }
}
