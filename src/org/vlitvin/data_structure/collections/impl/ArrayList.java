package org.vlitvin.data_structure.collections.impl;

import org.vlitvin.data_structure.collections.List;

public class ArrayList<T> implements List<T> {

    private static final int INITIAL_CAPACITY = 5;
    T[] array;
    int size;
    int currentCapacity = INITIAL_CAPACITY;

    public ArrayList() {
        array = (T[]) new Object[INITIAL_CAPACITY];
    }

    @Override
    public int add(T value) {
        array[size] = value;
        size++;
        checkCapacity();
        return size;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T value, int index) {
        validateIndex(index);
        T nextValue;
        for (; index < size; index++) {
            nextValue = array[index];
            array[index] = value;
            value = nextValue;
        }
        array[index] = value;
        size++;
        checkCapacity();
    }

    @Override
    public int indexOf(T value) {
        for (int i = 0; i < size; i++) {
            if (value.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T value) {
        for (int i = size; i >= 0; i--) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(T value) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public T set(T value, int index) {
        T currentElement = array[index];
        array[index] = value;
        return currentElement;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public T get(int index) {
        validateIndex(index);
        return array[index];
    }

    @Override
    public void remove(int index) {
        validateIndex(index);
        if (size == 1) {
            size = 0;
        } else {
            for (; index < size; index++) {
                if(index+1<size){
                   T nextValue = array[index+1];
                   array[index] = nextValue;
                }
        }
            size--;
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            String msg = "Incorect index -> " + index +
                    " , index should be between 0 and " + size;
            throw new IllegalArgumentException(msg);
        }
    }

    private void checkCapacity() {
        if (size == currentCapacity) {
            currentCapacity = currentCapacity * 2;
            T[] newArray = (T[]) new Object[currentCapacity];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }

}
