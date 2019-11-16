package ua.edu.ucu.smartarr;

import java.util.Comparator;

abstract class SmartArrayDecorator implements SmartArray {

    protected SmartArray smartArray;
    protected Object[] arr;
    protected int size;

    public SmartArrayDecorator(SmartArray smartArray) {

        this.smartArray = smartArray;
        this.arr = smartArray.toArray().clone();
        this.size = smartArray.size();
    }
}
