package by.marukovich.task0.repository.impl;

import by.marukovich.task0.entity.CustomArray;
import by.marukovich.task0.repository.Specification;
import by.marukovich.task0.service.ArrayAction;
import by.marukovich.task0.service.impl.ArrayActionImpl;

public class MaxSpecification implements Specification {

    private int maxValue;

    public MaxSpecification(int maxValue) {
        this.maxValue = maxValue;
    }

    @Override
    public boolean specify(CustomArray item) {
        ArrayAction service = ArrayActionImpl.getInstance();
        return maxValue==service.findMaxElement(item);
    }
}
