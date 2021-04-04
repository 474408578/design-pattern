package com.mylearn.builder;

/**
 * @author xschen
 * 使用反射创建
 */


public class ClientReflect {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ComputerDirector director = new ComputerDirector();
        Class c = Class.forName("com.mylearn.builder.ASUSComputerBuilder");
        Builder builder = (Builder) c.newInstance();
        Computer asusComputer = director.constructor(builder);
        System.out.println(asusComputer);
    }
}
