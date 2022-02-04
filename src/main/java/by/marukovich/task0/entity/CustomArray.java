package by.marukovich.task0.entity;

import by.marukovich.task0.observer.ArrayObserver;
import by.marukovich.task0.observer.Observable;
import by.marukovich.task0.util.CustomCounter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomArray implements Observable {
    private int arrayId;
    private int[] integerArray;
    private List<ArrayObserver> listObservers = new ArrayList<>();
    {
        this.arrayId = CustomCounter.generateId();
    }
    public CustomArray() {
    }

    public CustomArray(int[] array) {
        this.integerArray = Arrays.copyOf(array, array.length);

    }

    public void setElement(int index, int value) {
        if (index >= 0 & index < Integer.MAX_VALUE) {
            integerArray[index] = value;
            notifyObservers();
        }
    }

    public int getArrayId() {
        return arrayId;
    }

    public void setIntegerArray(int[] integerArray) {
        this.integerArray = integerArray;
    }

    public int[] getIntegerArray() {
        return integerArray.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomArray that)) return false;
        return Arrays.equals(integerArray, that.integerArray);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(integerArray);
    }

    @Override
    public String toString() {
        return "CustomArray[" + Arrays.toString(integerArray) + "]";
    }

    @Override
    public void attach(ArrayObserver observer) {
        listObservers.add(observer);
    }

    @Override
    public void detach(ArrayObserver observer) {
        listObservers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (ArrayObserver observer: listObservers) {
            observer.changeElement(this);
        }
    }
}
