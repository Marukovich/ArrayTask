package by.marukovich.task0.repository;

import by.marukovich.task0.entity.CustomArray;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class CustomRepository {

    private List<CustomArray> customArrayList = new ArrayList<>();
    private static final CustomRepository instance = new CustomRepository();

    private CustomRepository(){}

    public static CustomRepository getInstance(){
        return instance;
    }

    public void addCustomArray(CustomArray customArray) {
        customArrayList.add(customArray);
    }

    public void removeCustomArray(CustomArray customArray) {
        customArrayList.remove(customArray);
    }

    public boolean addAll(Collection<? extends CustomArray> c) {
        return customArrayList.addAll(c);
    }

    public boolean removeAll(Collection<? extends CustomArray> c) {
        return customArrayList.removeAll(c);
    }

    public CustomArray get(int index) {
        return customArrayList.get(index);
    }

    public CustomArray set(int index, CustomArray customArray) {
        return customArrayList.set(index, customArray);
    }

    public void sort(Comparator<CustomArray> c) {
        customArrayList.sort(c);
    }

    public List<CustomArray> query(Specification specification) {
        List<CustomArray> list = new ArrayList<>();
        for (CustomArray array : customArrayList) {
            if (specification.specify(array)) {
                list.add(array);
            }
        }
        return list;
    }
}
