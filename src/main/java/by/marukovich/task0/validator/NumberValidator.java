package by.marukovich.task0.validator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NumberValidator {
    private static final NumberValidator instance = new NumberValidator();
    public static final Logger log = LogManager.getLogger();
    private static final String REGEXP_STRING_VALIDATOR = "^\\s*-?\\d+(\\s+(-?\\d+))*\\s*$";

    public static NumberValidator getInstance() {
        return instance;
    }

    public boolean validateStringWithIntegers(String str) {
        if (str != null && str.matches(REGEXP_STRING_VALIDATOR)) {
            return true;
        } else {
            log.log(Level.INFO, "String {} can not be parsed to int", str);
            return false;
        }
    }


}
