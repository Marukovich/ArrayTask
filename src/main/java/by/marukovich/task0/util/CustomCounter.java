package by.marukovich.task0.util;

public class CustomCounter {
    private static int idCounter = 0;

    public static int generateId(){
        return idCounter++;
    }
}
