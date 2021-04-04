package com.geektime.designandparadigm._56.support;

/**
 * @author xschen
 */
public class Message {
    private String name;

    public Message(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Message{" +
                "name='" + name + '\'' +
                '}';
    }
}
