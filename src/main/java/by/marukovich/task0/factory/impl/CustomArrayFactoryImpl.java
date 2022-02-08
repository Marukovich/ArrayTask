package by.marukovich.task0.factory.impl;

import by.marukovich.task0.entity.ArrayStatistics;
import by.marukovich.task0.entity.CustomArray;
import by.marukovich.task0.entity.Warehouse;
import by.marukovich.task0.exception.CustomException;
import by.marukovich.task0.factory.CustomArrayFactory;
import by.marukovich.task0.observer.ArrayObserver;
import by.marukovich.task0.observer.impl.ArrayObserverImpl;
import by.marukovich.task0.repository.CustomRepository;
import by.marukovich.task0.service.ArrayAction;
import by.marukovich.task0.service.impl.ArrayActionImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomArrayFactoryImpl implements CustomArrayFactory {
    private Logger log = LogManager.getLogger();
    private static final CustomArrayFactoryImpl instance = new CustomArrayFactoryImpl();

    private CustomArrayFactoryImpl(){}

    public static CustomArrayFactoryImpl getInstance(){
        return instance;
    }

    @Override
    public CustomArray createCustomArray(int[] integerArray) throws CustomException {
        if(integerArray == null || integerArray.length == 0){
            log.log(Level.ERROR, "integerArray is null or his length = 0");
            throw new CustomException("integerArray is null or his length = 0");
        }
        CustomArray customArray;
        customArray = new CustomArray(integerArray);
        log.log(Level.INFO, "New CustomArray is created");
        addToRepository(customArray);
        addToWarehouse(customArray);
        addObserverToNewCustomArray(customArray);
        return customArray;
    }

    private void addToRepository(CustomArray customArray){
        CustomRepository repository = CustomRepository.getInstance();
        repository.addCustomArray(customArray);
        log.log(Level.INFO, "New ArrayStatistics is added to repository");
    }

    private void addToWarehouse(CustomArray customArray){
        ArrayAction arrayAction = ArrayActionImpl.getInstance();
        int min = arrayAction.findMinElement(customArray);
        int max = arrayAction.findMaxElement(customArray);
        double average = arrayAction.findAverageElement(customArray);
        int sum = arrayAction.calculateSumOfArrayElements(customArray);
        int negativeQuantity = arrayAction.findQuantityOfNegativeElement(customArray);
        int positiveQuantity = arrayAction.findQuantityOfPositiveElement(customArray);
        ArrayStatistics arrayStatistics = new ArrayStatistics(min,
                max,
                average,
                sum,
                negativeQuantity,
                positiveQuantity);
        Warehouse warehouse = Warehouse.getInstance();
        warehouse.put(customArray.getArrayId(), arrayStatistics);
        log.log(Level.INFO, "New ArrayStatistics is added to warehouse");
    }

    private void addObserverToNewCustomArray(CustomArray customArray){
        ArrayObserver observer = new ArrayObserverImpl();
        customArray.attach(observer);
        log.log(Level.INFO, "Observer is attached to new CustomArray");
    }
}
