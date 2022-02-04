package by.marukovich.task0.repository.impl;

import by.marukovich.task0.entity.CustomArray;
import by.marukovich.task0.repository.Specification;
import by.marukovich.task0.service.ArrayAction;
import by.marukovich.task0.service.impl.ArrayActionImpl;

public class NegativeQuantitySpecification implements Specification {
    private int negativeQuantityValue;

    public NegativeQuantitySpecification(int negativeQuantityValue) {
        this.negativeQuantityValue = negativeQuantityValue;
    }

    @Override
    public boolean specify(CustomArray item) {
        ArrayAction service = ArrayActionImpl.getInstance();
        return negativeQuantityValue==service.findQuantityOfNegativeElement(item);
    }
}
