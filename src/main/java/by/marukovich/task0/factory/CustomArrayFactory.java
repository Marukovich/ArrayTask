package by.marukovich.task0.factory;

import by.marukovich.task0.entity.CustomArray;
import by.marukovich.task0.exception.CustomException;

public interface CustomArrayFactory {
    CustomArray createCustomArray(int[] integerArray) throws CustomException;
}
