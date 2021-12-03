package edu.iu.c212.models;

import java.util.List;

public class User {
   String username;
   double balance;

   List<Item> inventory;

   public User(String username, double balance, List<Item> inventory) {
      this.username = username;
      this.balance = balance;
      this.inventory = inventory;
   }

   public User() {

   }

   public String getUsername() {
      return username;
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

   public void setUsername(String user){username = user;}

   public void setBalance(double b){balance = b;}

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