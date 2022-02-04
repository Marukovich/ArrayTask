package by.marukovich.task0.entity;

public class ArrayStatistics {
    private int min;
    private int max;
    private double average;
    private int sum;
    private int positive;
    private int negative;

    public ArrayStatistics(int min,
                           int max,
                           double average,
                           int sum,
                           int positive,
                           int negative) {
        this.min = min;
        this.max = max;
        this.average = average;
        this.sum = sum;
        this.positive = positive;
        this.negative = negative;
    }
}
