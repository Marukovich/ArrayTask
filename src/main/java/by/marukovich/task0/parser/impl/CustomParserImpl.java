package by.marukovich.task0.parser.impl;

import by.marukovich.task0.parser.CustomParser;

public class CustomParserImpl implements CustomParser {

    private static final String DELIMITER = "\\s+";

    @Override
    public int[] parseArray(String string){
        string = string.trim();
        String[] stringsArray = string.split(DELIMITER);
        int[] integerArray = new int[stringsArray.length];
        for (int i = 0; i < stringsArray.length; i++) {
            integerArray[i] = Integer.parseInt(stringsArray[i]);
        }
        return integerArray;
    }
}
