package ua.edu.ucu.smartarr;

abstract class SmartArrayDecorator implements SmartArray {

    protected Object[] arr;
    protected int size;

    public SmartArrayDecorator(SmartArray smartArray) {

        this.arr = smartArray.toArray().clone();
        this.size = smartArray.size();
    }
}
