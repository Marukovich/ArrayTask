package by.marukovich.task0.parser;

import by.marukovich.task0.exception.CustomException;

public interface CustomParser {
    int[] parseArray(String string) throws CustomException;
}
