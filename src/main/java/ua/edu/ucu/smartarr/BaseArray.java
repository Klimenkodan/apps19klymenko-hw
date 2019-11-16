package ua.edu.ucu.smartarr;


// Base array for decorators
public class BaseArray implements SmartArray{
    private Object[] arr;
    private int size;

    public BaseArray(Object[] objects) {
        this.size = objects.length;
        this.arr = objects.clone();

    }

    @Override
    public Object[] toArray() {
        return arr.clone();
    }

    @Override
    public String operationDescription() {
        return getClass().getName();
    }

    @Override
    public int size() {
        return size;
    }
}
