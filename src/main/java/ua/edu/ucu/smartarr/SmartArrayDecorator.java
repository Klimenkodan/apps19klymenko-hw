package ua.edu.ucu.smartarr;

abstract class SmartArrayDecorator implements SmartArray {
    private static final int NUM_NOT_OBVIOUS_SYMBOLS = 20;
    protected Object[] arr;

    public SmartArrayDecorator(SmartArray smartArray) {

        this.arr = smartArray.toArray().clone();
    }
    @Override
    public Object[] toArray() {
        return arr.clone();
    }

    public String operationDescription() {
        return getClass().getName().substring(NUM_NOT_OBVIOUS_SYMBOLS);
    }

    public int size() {
        return arr.length;
    }
}
