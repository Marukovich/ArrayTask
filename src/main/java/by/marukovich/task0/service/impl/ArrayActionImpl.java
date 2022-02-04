package by.marukovich.task0.service.impl;

import by.marukovich.task0.entity.CustomArray;
import by.marukovich.task0.service.ArrayAction;

import java.util.Arrays;

public class ArrayActionImpl implements ArrayAction {

    private static final ArrayActionImpl instance = new ArrayActionImpl();

    private ArrayActionImpl(){}

    public static ArrayActionImpl getInstance(){
        return instance;
    }
    @Override
    public int findMinElement(CustomArray integerArray){
        int[] array=integerArray.getIntegerArray();
        Arrays.sort(array);
        return array[0];
    }

    @Override
    public int findMaxElement(CustomArray integerArray) {
        int[] array = integerArray.getIntegerArray();
        Arrays.sort(array);
        return array[array.length - 1];
    }

    @Override
    public double findAverageElement(CustomArray integerArray) {
        double totalSum = 0;
        int[] array = integerArray.getIntegerArray();
        for (int element : array) {
            totalSum = totalSum + element;
        }
        return totalSum / array.length;
    }

    @Override
    public int calculateSumOfArrayElements(CustomArray integerArray) {
        int totalSum = 0;
        for (int element : integerArray.getIntegerArray()) {
            totalSum = totalSum + element;
        }
        return totalSum;
    }

    @Override
    public int findQuantityOfNegativeElement(CustomArray integerArray) {
        int quantity = 0;
        for (int element : integerArray.getIntegerArray()) {
            if (element < 0) {
                quantity++;
            }
        }
        return quantity;
    }

    @Override
    public int findQuantityOfPositiveElement(CustomArray integerArray) {
        int quantity = 0;
        for (int element : integerArray.getIntegerArray()) {
            if (element > 0) {
                quantity++;
            }
        }
        return quantity;
    }
}
