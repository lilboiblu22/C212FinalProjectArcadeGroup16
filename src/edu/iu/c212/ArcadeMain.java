package edu.iu.c212;

import edu.iu.c212.models.Item;
import edu.iu.c212.models.User;

public class ArcadeMain {
    public static void main(String[] args) {
        //new Arcade();
        User user = new User();
        user.addItem(Item.ITEM_FIVE);
        user.addItem(Item.ITEM_FIVE);
        System.out.println(user.getInventory());
    }
}
