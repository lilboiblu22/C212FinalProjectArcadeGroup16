package edu.iu.c212.models;

import java.util.ArrayList;
import java.util.List;

public class User {
   /**
    * Name of the User
    */
   String username;
   /**
    * Balance of the User
    */
   double balance;

   /**
    * Inventory of the User
    */
   List<Item> inventory;

   /**
    * User Constructor
    * @param username name of the User
    * @param balance amount of money
    * @param inventory List of Items
    */
   public User(String username, double balance, List<Item> inventory) {
      this.username = username;
      this.balance = balance;
      this.inventory = inventory;
   }

   /**
    * User Constructor w/ no arguments.
    */
   public User() {
      this.username = "username";
      this.balance = 0;
      this.inventory = new ArrayList<>();
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getUsername() {
      return username;
   }

   public void setBalance(double balance) {
      this.balance = balance;
   }

   public double getBalance() {
      return balance;
   }

   public List<Item> getInventory() {
      return inventory;
   }

   public void setInventory(List<Item> inventory) {
      this.inventory = inventory;
   }

   public void addItem(Item item) {
      this.inventory.add(item);
   }

   public int getInventorySize() {
      return inventory.size();
   }

   public void removeItem(Item item) {
      this.inventory.remove(item);
   }

   public void addBalance(double amount) {
      this.balance += amount;
   }

   public void removeBalance(double amount) {
      this.balance -= amount;
   }

}