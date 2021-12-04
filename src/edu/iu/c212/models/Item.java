package edu.iu.c212.models;

public enum Item {
    ITEM_ONE("name1", 2.0),
    ITEM_TWO("name2", 3.0),
    ITEM_THREE("name3", 2.0),
    ITEM_FOUR("name4", 3.0),
    ITEM_FIVE("name5", 2.0),
    ITEM_SIX("name6", 3.0),
    ITEM_SEVEN("name7", 2.0),
    ITEM_EIGHT("name8", 3.0),
    ITEM_NINE("name9", 2.0),
    ITEM_TEN("name10", 3.0),
    ;

    String readableName;
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