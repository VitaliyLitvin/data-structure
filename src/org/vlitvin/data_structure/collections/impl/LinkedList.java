package org.vlitvin.data_structure.collections.impl;


import org.vlitvin.data_structure.collections.List;

public class LinkedList<T> implements List<T> {

    private Node head;
    private Node tail;
    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public int add(T value) {
        Node<T> node = new Node(value);
        if (size == 0) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
        return size;
    }

    @Override
    public void add(T value, int index) {
        validateIndex(index);
        Node<T> newNode = new Node(value);
        if (index == 0) {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        else {
            Node currentNode = head.next;
            for (int i = 1; i <= index; i++) {
                if (index == i) {
                    currentNode.prev.next = newNode;
                    newNode.next = currentNode;
                    newNode.prev = currentNode.prev;
                    currentNode.prev = newNode;
                }
                currentNode = currentNode.next;
            }
        }
        size++;
    }

    @Override
    public int indexOf(T value) {
        Node currentNode = head;
        for (int i = 0; i < size; i++) {
            if (currentNode.value.equals(value)) {
                return i;
            }
            currentNode = currentNode.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T value) {
        Node currentNode = tail;
        for (int i = size - 1; i >= 0; i--) {
            if (currentNode.value.equals(value)) {
                return i;
            }
            currentNode = currentNode.prev;
        }
        return -1;
    }

    @Override
    public boolean contains(T value) {
        Node currentNode = head;
        for (int i = 0; i < size; i++) {
            if (currentNode.value.equals(value)) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    @Override
    public T set(T value, int index) {
        validateIndex(index);
        Node<T> currentNode = head;
        T currentValue = null;
        for (int i = 0; i <= index; i++) {
            if (i == index) {
                currentValue = currentNode.value;
                currentNode.value = value;
            }
        }
        return currentValue;
    }

    @Override
    public void clear() {
        size = 0;
        head = null;
        tail = null;
    }

    @Override
    public T get(int index) {
        validateIndex(index);
        T result = null;
        Node<T> currentNode = head;
        for (int i = 0; i <= index; i++) {
            if (i == index) {
                result = currentNode.value;
            }
        }
        return result;
    }

    @Override
    public void remove(int index) {
        validateIndex(index);
        if (index == 0) {
            head = head.next;
            head.prev = null;
        } else if (index == size - 1) {
            tail = tail.prev;
            tail.next = null;
        } else {
            Node currentNode = head.next;
            for (int i = 1; i < index; i++) {
                if (i == index) {
                    currentNode.next.prev = currentNode.prev;
                    currentNode.prev.next = currentNode.next;
                }
            }
        }
        size--;
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            String msg = "Incorect index -> " + index +
                    " , index should be between 0 and " + size;
            throw new IllegalArgumentException(msg);
        }
    }

    private class Node<T> {
        T value;
        Node next;
        Node prev;

        public Node(T value) {
            this.value = value;
        }
    }

}
