package com.geektime.oop._05.polymorphism;

/**
 * @author xschen
 *
 * 使用接口类实现多态，多态提高了代码的可扩展性。
 */


public class UseInteface {
    private static void print(Iterator iterator) {
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void main(String[] args) {
        Iterator array = new Array();
        print(array);

        Iterator linkedList = new LinkedList();
        print(linkedList);
    }
}

interface Iterator {
    boolean hasNext();
    String next();
    String remove();
}


class Array implements Iterator {
    public boolean hasNext() {
        return false;
    }

    public String next() {
        return null;
    }

    public String remove() {
        return null;
    }
    // 省略其他方法
}


class LinkedList implements Iterator {
    public boolean hasNext() {
        return false;
    }

    public String next() {
        return null;
    }

    public String remove() {
        return null;
    }
}
