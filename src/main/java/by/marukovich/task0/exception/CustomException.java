package by.marukovich.task0.exception;

public class CustomException extends Exception{
    public CustomException() {
        this("no message");
    }

    public CustomException(String message) {
        super("ERROR: " + message);
    }

    public CustomException(String message, Throwable cause) {
        super("ERROR: " + message, cause);
    }

    public CustomException(Throwable cause) {
        this("no message", cause);
    }
}
