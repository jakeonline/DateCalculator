package com.odsinada.qantas;

public class Month {
    private final int index;
    private final int dayCount;

    public int getDayCount() {
        return dayCount;
    }

    public int getIndex() {
        return index;
    }

    public Month(int index, int dayCount) {
        this.index = index;
        this.dayCount = dayCount;
    }
}
