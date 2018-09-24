package ua.com.bpgdev.javabegins.datastructures.list;

abstract class AbstractList {
    int size;

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
