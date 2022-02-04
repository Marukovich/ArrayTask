package by.marukovich.task0.repository.impl;

import by.marukovich.task0.entity.CustomArray;
import by.marukovich.task0.repository.Specification;
import by.marukovich.task0.service.ArrayAction;
import by.marukovich.task0.service.impl.ArrayActionImpl;

public class MinSpecification implements Specification {

    private int minValue;

    public MinSpecification(int minValue) {
        this.minValue = minValue;
    }

    @Override
    public boolean specify(CustomArray item) {
        ArrayAction service = ArrayActionImpl.getInstance();
        return minValue==service.findMinElement(item);
    }
}
