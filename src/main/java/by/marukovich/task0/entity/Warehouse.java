package by.marukovich.task0.entity;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private static Warehouse warehouse = new Warehouse();
    private Map<Integer, ArrayStatistics> map = new HashMap<>();
    private Warehouse() {
    }
    public static Warehouse getInstance(){
        return warehouse;
    }

    public ArrayStatistics get(Integer key) {
        return map.get(key);
    }

    public ArrayStatistics replace(Integer key, ArrayStatistics value) {
        return map.replace(key, value);
    }
}
