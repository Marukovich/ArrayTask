package by.marukovich.task0.reader;

import by.marukovich.task0.exception.CustomException;

import java.util.List;

public interface CustomReader {
    List<String> reader(String filePath) throws CustomException;
}
