package by.marukovich.task0.service;

import by.marukovich.task0.entity.CustomArray;

public interface ArrayAction {
    int findMinElement(CustomArray integerArray);

    int findMaxElement(CustomArray integerArray);

    double findAverageElement(CustomArray integerArray);

    int calculateSumOfArrayElements(CustomArray integerArray);

    int findQuantityOfNegativeElement(CustomArray integerArray);

    int findQuantityOfPositiveElement(CustomArray integerArray);
}
