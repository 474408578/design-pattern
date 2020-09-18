package com.xschen.oop._05.polymorphism;

/**
 * @author xschen
 *
 * OOP: 多态
 */


public class Example {
    public static void test(DynamicArray dynamicArray) {
        dynamicArray.add(5);
        dynamicArray.add(1);
        dynamicArray.add(3);
        for (int i = 0; i < dynamicArray.size(); i++) {
            System.out.println(dynamicArray.get(i));
        }
    }

    public static void main(String[] args) {
        DynamicArray dynamicArray = new SortedDynamicArray();
        test(dynamicArray);
    }
}

class DynamicArray {
    private static final int DEFAULT_CAPACITY = 10;
    protected int size = 0;
    protected int capacity = DEFAULT_CAPACITY;
    protected Integer[] elements = new Integer[DEFAULT_CAPACITY];

    public int size() {
        return this.size;
    }

    public void add(Integer element) {
        ensureCapacity();
    }

    public Integer get(int i) {
        return elements[i];
    }

    protected void ensureCapacity() {
        // 如果数组满了就扩容，代码省略
    }
}


class SortedDynamicArray extends DynamicArray {
    @Override
    public void add(Integer element) {
        ensureCapacity();
        int i;
        for (i = size - 1; i >= 0 ; i--) {
            if (elements[i] > element) {
                elements[i+1] = elements[i];
            } else {
                break;
            }
        }
        elements[i+1] = element;
        ++size;
    }
}