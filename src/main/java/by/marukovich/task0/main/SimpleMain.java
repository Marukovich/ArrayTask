package by.marukovich.task0.main;

import by.marukovich.task0.entity.ArrayStatistics;
import by.marukovich.task0.entity.CustomArray;
import by.marukovich.task0.entity.Warehouse;
import by.marukovich.task0.exception.CustomException;
import by.marukovich.task0.parser.CustomParser;
import by.marukovich.task0.parser.impl.CustomParserImpl;
import by.marukovich.task0.reader.impl.FileReaderImpl;
import by.marukovich.task0.repository.CustomRepository;
import by.marukovich.task0.service.ArrayAction;
import by.marukovich.task0.service.impl.ArrayActionImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class SimpleMain {
    private static final Logger log = LogManager.getLogger();

    public static void main(String[] args) throws CustomException {
        log.log(Level.INFO, "first log");
        List<String> stringList = new ArrayList<>();

        FileReaderImpl fileReader = new FileReaderImpl();
        try {
            stringList = fileReader.reader("data/num.txt");
        } catch (CustomException e) {
            log.log(Level.ERROR, "file not found");
        }
        String string = stringList.get(0);
        CustomParser customParser = CustomParserImpl.getInstance();
        int[] array = customParser.parseArray(string);
        CustomArray intArray = new CustomArray(array);
        intArray.setIntegerArray(array);
        ArrayAction arrayAction = ArrayActionImpl.getInstance();
        Warehouse warehouse = Warehouse.getInstance();
        CustomRepository repository = CustomRepository.getInstance();
        int minElement = arrayAction.findMinElement(intArray);
        int maxElement = arrayAction.findMaxElement(intArray);
        double average = arrayAction.findAverageElement(intArray);
        int sum = arrayAction.calculateSumOfArrayElements(intArray);
        int negative = arrayAction.findQuantityOfNegativeElement(intArray);
        int positive = arrayAction.findQuantityOfPositiveElement(intArray);
        ArrayStatistics arrayStatistics = new ArrayStatistics(minElement, maxElement, average, sum, positive, negative);
        Integer arrayId = intArray.getArrayId();
        warehouse.put(arrayId, arrayStatistics);
        repository.addCustomArray(intArray);

    }
}
