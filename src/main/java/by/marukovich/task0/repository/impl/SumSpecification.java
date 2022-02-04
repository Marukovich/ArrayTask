package by.marukovich.task0.repository.impl;

import by.marukovich.task0.entity.CustomArray;
import by.marukovich.task0.repository.Specification;
import by.marukovich.task0.service.ArrayAction;
import by.marukovich.task0.service.impl.ArrayActionImpl;

public class SumSpecification implements Specification {
    private int sumValue;

    public SumSpecification(int sumValue) {
        this.sumValue = sumValue;
    }

    @Override
    public boolean specify(CustomArray item) {
        ArrayAction service = ArrayActionImpl.getInstance();
        return sumValue==service.calculateSumOfArrayElements(item);
    }
}
