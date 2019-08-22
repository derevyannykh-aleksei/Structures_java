package structures;

import java.util.Objects;

public class LinearList<T> implements IList<T> {

    private Object[] items;
    private int sizeList;
    private int start;

    public LinearList() {
        items = new Object[8];
    }
    public LinearList(int capacity) {
        if (capacity < 1)
            throw new IllegalArgumentException("Capacity must be greater than zero");
        items = new Object[capacity];
    }
    @Override
    public int getSizeList() {
        return sizeList;
    }

    @Override
    public void add(T elementToAdd) {
        add(elementToAdd, sizeList);
    }

    @Override
    public void add(T elementToAdd, int index) {
        if (index < 0 || index > sizeList)
            throw new IllegalArgumentException("Not correct index");
        if (sizeList == 0)
            items[start] = elementToAdd;
        else if (sizeList < items.length) {

        }
        else {
            int newStart = start;

            if (newStart == 0 && index < sizeList / 2)
                newStart = (items.length * 2 - sizeList) / 2;

            Object[] newItems = new Object[items.length * 2];
            for (int i = 0; i < index; i++)
                newItems[newStart + i] = items[start + i];

            newItems[newStart + index] = elementToAdd;

            for (int i = index; i <sizeList ; i++)
                newItems[newStart + i + 1] = items[start + i];

            items = newItems;
        }

        sizeList++;
    }

    @Override
    public void remove(int index) {

    }

    @Override
    public boolean remove(T element) {
        return false;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= sizeList)
            throw new IllegalArgumentException("Not correct index");

        return (T) items[start + index];
    }

    @Override
    public T set(T change, int index) {
        if (index < 0 || index >= sizeList)
            throw new IllegalArgumentException("Not correct index");

        T retElement = (T) items[start + index];
        items[start + index] = change;
        return retElement;
    }

    @Override
    public int indexOf(T element) {
        for (int i = 0; i < sizeList ; i++) {
            if (Objects.equals(items[start + i], element))
                return i;
        }
        return -1;
    }
}
