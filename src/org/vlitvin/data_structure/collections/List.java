package org.vlitvin.data_structure.collections;

/**
 * Created by vlytvyn on 16.02.2017.
 */
public interface List<T> {

    int size();

    int add(T value);

    void add(T value, int index);

    int indexOf(T value);

    int lastIndexOf(T value);

    boolean contains(T value);

    T set(T value, int index);

    void clear();

    T get(int index);

    void remove(int index);

}
