package by.marukovich.task0.main;

import by.marukovich.task0.entity.CustomArray;
import by.marukovich.task0.exception.CustomException;
import by.marukovich.task0.parser.impl.CustomParserImpl;
import by.marukovich.task0.reader.impl.FileReaderImpl;
import by.marukovich.task0.service.ArrayAction;
import by.marukovich.task0.service.impl.ArrayActionImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.ArrayList;
import java.util.List;

public class SimpleMain {
    private static final Logger log = LogManager.getLogger();

    public static void main(String[] args) {
        log.log(Level.INFO, "first log");
        List<String> stringList = new ArrayList<>();

        FileReaderImpl fileReader = new FileReaderImpl();
        try {
            stringList = fileReader.reader("data/num.txt");
        } catch (CustomException e) {
            log.log(Level.ERROR, "file not found");
        }
        String string = stringList.get(0);
        CustomParserImpl customParser = new CustomParserImpl();
        int[] array = customParser.parseArray(string);
        CustomArray intArray = new CustomArray(array);
        intArray.setIntegerArray(array);
        ArrayAction arrayAction = ArrayActionImpl.getInstance();
        int minElement = arrayAction.findMinElement(intArray);
        log.log(Level.INFO, minElement);
    }
}
