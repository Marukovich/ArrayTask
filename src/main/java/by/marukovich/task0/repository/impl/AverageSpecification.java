package by.marukovich.task0.repository.impl;

import by.marukovich.task0.entity.CustomArray;
import by.marukovich.task0.repository.Specification;
import by.marukovich.task0.service.ArrayAction;
import by.marukovich.task0.service.impl.ArrayActionImpl;

public class AverageSpecification implements Specification {

    private int averageValue;

    public AverageSpecification(int averageValue) {
        this.averageValue = averageValue;
    }

    @Override
    public boolean specify(CustomArray item) {
        ArrayAction service = ArrayActionImpl.getInstance();
        return averageValue == service.findAverageElement(item);
    }
}
