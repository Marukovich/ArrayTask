package by.marukovich.task0.parser.impl;

import by.marukovich.task0.exception.CustomException;
import by.marukovich.task0.parser.CustomParser;

public class CustomParserImpl implements CustomParser {
    private static final CustomParserImpl customParser = new CustomParserImpl();
    private static final String DELIMITER = "\\s+";

    private CustomParserImpl(){}

    public static CustomParserImpl getInstance(){
        return customParser;
    }
    @Override
    public int[] parseArray(String string) throws CustomException {
        if(string == null){
            throw new CustomException("String is null.");
        }
        String[] stringsArray = string.strip().split(DELIMITER);
        int[] integerArray = new int[stringsArray.length];
        for (int i = 0; i < stringsArray.length; i++) {
            integerArray[i] = Integer.parseInt(stringsArray[i]);
        }
        return integerArray;
    }
}
