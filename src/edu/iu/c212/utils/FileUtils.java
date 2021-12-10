package edu.iu.c212.utils;

import edu.iu.c212.models.Item;
import edu.iu.c212.models.User;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileUtils {
    private static final File file = new File("TextFiles/SaveData.txt");

    // line format:
    // user_name|balance|item1,item2,item3
    // user name not allowed to contain pipe

    /**
     * Write user data to the file you provided above.
     * @param users The total list of all users
     */
    public static void writeUserDataToFile(List<User> users) throws IOException {
       try {
           PrintWriter out = new PrintWriter(file);
           for (User user : users) {
               out.println(user.getUsername() +
                       "|" + user.getBalance() +
                       "|" + user.getInventory().toString());
           }
           out.close();
       }
       catch (IOException e) {
           System.out.println("Error writing to file");
       }
    }

    /**
     * Read user data from the file you provided above. Return a list of Users
     */
    public static List<User> getUserDataFromFile() throws IOException {
      try {
        List<User> users = new ArrayList<User>();
        Scanner in = new Scanner(file);


        while (in.hasNextLine()) {
            // line format:
            // user_name|balance|item1,item2,item3
            // (1) break up the line into name, balance, items
            String[] line = in.nextLine().split("\\|");
            User user = new User();
            user.setUsername(line[0]);
            user.setBalance(Double.parseDouble(line[1]));
            users.add(user);
            // items are stored like Name0: Price0, Name1: Price1, etc...
            // (2) break item information up into name and price
            String[] items = line[2].split(","); // if they have nothing, this is []
            if (items.length >= 1) {
                List<Item> listOfItems = new ArrayList<Item>();
                for (String s : items) {
                    // each s will look like...
                    // name1: 2.0
                    // name2: 3.0
                    // etc...
                    String[] item = s.split(":");
                    if (item[0].contains("["))
                        item[0] = item[0].substring(1);
                    // when user has more than one item, the second item onwards has a space before the item name...
                    item[0] = item[0].trim();
                    // item[0] will never have a "]" character. only the price may at the end. so this is commented out
                    //else if (item[0].contains("]"))
                    //        item[0] = item[0].substring(0, item[0].length() - 1);
                    // name1
                    // 2.0
                    // just need the name...
                    Item enumItem = switch (item[0]) {
                        case "Slinky" -> Item.ITEM_ONE;
                        case "Yo-yo" -> Item.ITEM_TWO;
                        case "Giant Stuffed Bear" -> Item.ITEM_THREE;
                        case "HexBug" -> Item.ITEM_FOUR;
                        case "Jar of Jellybeans" -> Item.ITEM_FIVE;
                        case "Finger Trap" -> Item.ITEM_SIX;
                        case "Novelty Mug" -> Item.ITEM_SEVEN;
                        case "Claw Hand" -> Item.ITEM_EIGHT;
                        case "Lego Bionicle Set" -> Item.ITEM_NINE;
                        case "Small Gumball Machine" -> Item.ITEM_TEN;
                        default -> null;
                    };
                    listOfItems.add(enumItem);
                }
                if (listOfItems.get(0) != null)
                    user.setInventory(listOfItems);
            }
        }
          in.close();
        return users;
    }
    catch (IOException e) {
          System.out.println("Error reading from file");
          return null;
         }
    }
}