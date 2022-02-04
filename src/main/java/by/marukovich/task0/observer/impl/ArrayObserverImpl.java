package by.marukovich.task0.observer.impl;

import by.marukovich.task0.entity.ArrayStatistics;
import by.marukovich.task0.entity.CustomArray;
import by.marukovich.task0.entity.Warehouse;
import by.marukovich.task0.observer.ArrayObserver;
import by.marukovich.task0.service.ArrayAction;
import by.marukovich.task0.service.impl.ArrayActionImpl;

public class ArrayObserverImpl implements ArrayObserver {
    @Override
    public void changeElement(CustomArray array) {
        ArrayAction service = ArrayActionImpl.getInstance();
        int min = service.findMinElement(array);
        int max = service.findMaxElement(array);
        double average = service.findAverageElement(array);
        int sum = service.calculateSumOfArrayElements(array);
        int negative = service.findQuantityOfNegativeElement(array);
        int positive = service.findQuantityOfPositiveElement(array);
        ArrayStatistics statistics = new ArrayStatistics(min, max, average, sum, negative, positive);
        int arrayId = array.getArrayId();
        Warehouse warehouse = Warehouse.getInstance();
        warehouse.replace(arrayId, statistics);
    }
}
