package edu.iu.c212.models;

public enum Item {
    ITEM_ONE("Slinky", 2.00),
    ITEM_TWO("Yo-yo", 1.50),
    ITEM_THREE("Giant Stuffed Bear", 14.0),
    ITEM_FOUR("HexBug", 3.0),
    ITEM_FIVE("Jar of Jellybeans", 10.0),
    ITEM_SIX("Finger Trap", 3.0),
    ITEM_SEVEN("Novelty Mug", 20.0),
    ITEM_EIGHT("Claw Hand", 15.0),
    ITEM_NINE("Lego Bionicle Set", 75.0),
    ITEM_TEN("Small Gumball Machine", 100.0),
    ;

    /**
     * The name to display in the Inventory.
     */
    String readableName;

    /**
     * How much the item costs.
     */
    double value;


    Item(String readableName, double value) {
        this.readableName = readableName;
        this.value = value;
    }

    public String getReadableName() {
        return readableName;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
    return readableName + ": " + value;
    }


}