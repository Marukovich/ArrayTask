package by.marukovich.task0.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NumberValidator {
    private static final NumberValidator instance = new NumberValidator();
    public static final Logger log = LogManager.getLogger(NumberValidator.class);
    private static final String SPLIT = "\\s+";

    public static NumberValidator getInstance() {
        return instance;
    }

    public boolean validateStringWithIntegers(String str) {
        String[] literals = str.strip().split(SPLIT);
        return AllNumbersInt(literals);
    }

    private boolean AllNumbersInt(String[] literals) {
        for (String literal : literals) {
            try {
                Integer.parseInt(literal.strip());

            } catch (NumberFormatException e) {
                log.error("literal " + literal + " can't be parsed to int",e);
                return false;
            }
        }
        return true;

    }
}
