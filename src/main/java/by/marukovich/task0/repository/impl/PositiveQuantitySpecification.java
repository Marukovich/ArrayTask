package by.marukovich.task0.repository.impl;

import by.marukovich.task0.entity.CustomArray;
import by.marukovich.task0.repository.Specification;
import by.marukovich.task0.service.ArrayAction;
import by.marukovich.task0.service.impl.ArrayActionImpl;

public class PositiveQuantitySpecification implements Specification {
    private int positiveQuantityValue;

    public PositiveQuantitySpecification(int positiveQuantityValue) {
        this.positiveQuantityValue = positiveQuantityValue;
    }

    @Override
    public boolean specify(CustomArray item) {
        ArrayAction service = ArrayActionImpl.getInstance();
        return positiveQuantityValue==service.findQuantityOfPositiveElement(item);
    }
}
