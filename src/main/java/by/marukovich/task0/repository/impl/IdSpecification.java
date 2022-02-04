package by.marukovich.task0.repository.impl;

import by.marukovich.task0.entity.CustomArray;
import by.marukovich.task0.repository.Specification;

public class IdSpecification implements Specification {

    private int id;

    public IdSpecification(int id) {
        this.id = id;
    }

    @Override
    public boolean specify(CustomArray item) {
        return id == item.getArrayId();
    }
}
