package edu.iu.c212.places;

import edu.iu.c212.models.Item;
import edu.iu.c212.models.User;
import edu.iu.c212.utils.ConsoleUtils;

import java.io.Console;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static edu.iu.c212.utils.ConsoleUtils.readLineFromConsole;

/**
 * Represents the Lobby, which you will enter at the beginning of the
 * arcade and after exiting any other places.
 *
 * It should have a $0 entry fee.
 */
public class Store extends Place {

    enum StoreAction {
        BUY{
            @Override
            public String toString() {
                return "buy";
            }
        },
        SELL{
            @Override
            public String toString() {
                return "sell";
            }
        },
        LEAVE{
            @Override
            public String toString() {
                return "leave";
            }
        }
    }

    @Override
    void onEnter(User user) {
        while (true) {
            List<StoreAction> storeActionList = new ArrayList<>();
            storeActionList.add(StoreAction.BUY); storeActionList.add(StoreAction.SELL);
            storeActionList.add(StoreAction.LEAVE);
            StoreAction action =
                    ConsoleUtils.printMenuToConsole("Welcome to the store. Please select an option: \n",
                    storeActionList, true);

            switch (action) {
                case BUY: buyMenu();
                case SELL: sellMenu();
                case LEAVE: return;
                default:
                    System.out.println("Invalid input");
            }
        }
    }

    void sellMenu() {
        List<String> yesOrNo = new ArrayList<>();
        yesOrNo.add("yes"); yesOrNo.add("no");
        // if the user has an empty inventory, complain and don't allow them to sell anything
        if (arcade.getCurrentUser().getInventorySize() == 0)
            System.out.println("You don't have anything to sell...");
        // print a menu to the console asking which item
        // in their inventory to sell and list all options.
        else {
            Item item = ConsoleUtils.printMenuToConsole("Which item in your inventory would you like to sell? \n"
                            + "Remember, you can only get 50% of the item value back...",
                    arcade.getCurrentUser().getInventory(), true);

            String answer = ConsoleUtils.printMenuToConsole("Are you sure that you would like to sell your " +
                    item.toString() + "? \n", yesOrNo, true);

            switch (answer) {
                case "yes" -> {
                    System.out.println("Selling " + item);
                    arcade.getCurrentUser().removeItem(item);
                }
                case "no" -> System.out.println("You chose not to sell your " + item);
            }
        }
    }

    void buyMenu() {
        List<String> yesOrNo = new ArrayList<>();
        yesOrNo.add("yes"); yesOrNo.add("no");

        List<Item> items = new ArrayList<>(Arrays.asList(Item.values()));

        Item item = ConsoleUtils.printMenuToConsole("Which item would you like to buy?" +
                Arrays.toString(Item.values()), items, true);

        if (arcade.getCurrentUser().getBalance() < item.getValue()) {
            System.out.println("You don't have enough money to buy this item. ");
        } else if (arcade.getCurrentUser().getInventorySize() == 3) {
            System.out.println("You don't have enough space to buy this item. ");
        } else {
            System.out.println();
            String answer = ConsoleUtils.printMenuToConsole("Are you sure you would like to buy this "
                            + item.getReadableName() + "? ", yesOrNo, true);

            switch (answer) {
                case "yes" -> {
                    System.out.println("Buying " + item);
                    arcade.getCurrentUser().addItem(item);
                    arcade.getCurrentUser().removeBalance(item.getValue());
                }
                case "no" -> System.out.println("You chose not to buy this " + item);
            }
        }
    }
}
