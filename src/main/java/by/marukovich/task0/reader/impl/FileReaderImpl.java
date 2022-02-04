package by.marukovich.task0.reader.impl;

import by.marukovich.task0.exception.CustomException;
import by.marukovich.task0.reader.CustomReader;
import by.marukovich.task0.validator.NumberValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class FileReaderImpl implements CustomReader {
    public static final Logger log = LogManager.getLogger();
    private final NumberValidator numberValidator = NumberValidator.getInstance();

    @Override
    public List<String> reader(String filePath) throws CustomException {
        List<String> stringList = new ArrayList<>();
        String text;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))){
            while ((text=bufferedReader.readLine())!= null){
                if(numberValidator.validateStringWithIntegers(text)){
                    stringList.add(text);
                }
            }
        } catch (FileNotFoundException e) {
            log.log(Level.ERROR, "File is not found");
            throw new CustomException("File is not found", e);
        } catch (IOException e) {
            log.log(Level.ERROR, "File can't be read" + filePath, e);
            throw new CustomException("File can't be read");
        }
        return stringList;
    }
}
