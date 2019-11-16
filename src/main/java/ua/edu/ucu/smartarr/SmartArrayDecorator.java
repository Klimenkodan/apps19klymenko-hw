package ua.edu.ucu.smartarr;

abstract class SmartArrayDecorator implements SmartArray {

    protected Object[] arr;

    public SmartArrayDecorator(SmartArray smartArray) {

        this.arr = smartArray.toArray().clone();
    }
}
