package by.marukovich.task0.repository;

import by.marukovich.task0.entity.CustomArray;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class CustomRepository {

    private List<CustomArray> listOfArrays;

    public void addCustomArray(CustomArray customArray) {
        this.listOfArrays.add(customArray);
    }

    public void removeCustomArray(CustomArray customArray) {
        this.listOfArrays.remove(customArray);
    }

    public boolean addAll(Collection<? extends CustomArray> c) {
        return listOfArrays.addAll(c);
    }

    public boolean removeAll(Collection<? extends CustomArray> c) {
        return listOfArrays.removeAll(c);
    }

    public CustomArray get(int index) {
        return listOfArrays.get(index);
    }

    public CustomArray set(int index, CustomArray customArray) {
        return listOfArrays.set(index, customArray);
    }

    public void sort(Comparator<CustomArray> c) {
        listOfArrays.sort(c);
    }

    public List<CustomArray> query(Specification specification) {
        List<CustomArray> list = new ArrayList<>();
        for (CustomArray array : listOfArrays) {
            if (specification.specify(array)) {
                list.add(array);
            }
        }
        return list;
    }
}
