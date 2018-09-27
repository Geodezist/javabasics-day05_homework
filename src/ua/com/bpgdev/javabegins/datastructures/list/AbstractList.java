package ua.com.bpgdev.javabegins.datastructures.list;

import java.util.StringJoiner;

abstract class AbstractList implements List {
    int size;

    public boolean contains(Object value) {
        return indexOf(value) != -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public String toString() {
        if (size == 0) {
            return "[]";
        }

        StringJoiner stringJoiner = new StringJoiner(", ","[","]");
        for (Object o: this ) {
            stringJoiner.add(o.toString());
        }

        return stringJoiner.toString();
    }

    boolean isEqualWithNulls(Object firstObject, Object secondObject) {
        if (firstObject == null) {
            return secondObject == null;
        } else {
            return firstObject.equals(secondObject);
        }
    }

    void validateIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Valid index values for add() methods are between 0 and " + size +
                    " inclusive. Current index value = " + index);
        }
    }

    void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Valid index values are between 0 and " + (size - 1) +
                    " inclusive. Current index value = " + index);
        }
    }

}
