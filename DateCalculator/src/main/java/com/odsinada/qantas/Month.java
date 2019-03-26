package com.odsinada.qantas;

public class Month {
    private final int index;
    private final int numberOfDays;

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public int getIndex() {
        return index;
    }

    public Month(int index, int numberOfDays) {
        this.index = index;
        this.numberOfDays = numberOfDays;
    }
}
