package edu.iu.c212.places;

import edu.iu.c212.models.Item;
import edu.iu.c212.models.User;
import edu.iu.c212.utils.ConsoleUtils;

import java.io.Console;

import static edu.iu.c212.utils.ConsoleUtils.readLineFromConsole;

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

    public  getStoreItems(){

    }

    @Override
    void onEnter(User user) {
        while (true) {
            ConsoleUtils.printToConsole("Welcome to the store! What would you like to do?");
            ConsoleUtils.printToConsole("buy");
            ConsoleUtils.printToConsole("sell");
            ConsoleUtils.printToConsole("leave");
            String input = readLineFromConsole();
            if (input.equals(StoreAction.BUY.toString())) {

            }
 else if (input.equals(StoreAction.SELL.toString())) {
                if (user.getInventory().size() == 0) {
                    ConsoleUtils.printToConsole("You don't have anything to sell!");
                }
                else {
                    ConsoleUtils.printToConsole("What would you like to sell?");
                }
            }
        }
    }

    }
