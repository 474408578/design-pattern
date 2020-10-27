package com.xschen.mylearn.builder;

/**
 * @author xschen
 */


public class Client {
    public static void main(String[] args) {
        ComputerDirector director = new ComputerDirector();

        Builder asusBuilder = new ASUSComputerBuilder();
        Computer asusComputer = director.constructor(asusBuilder);
        System.out.println(asusComputer);

        Builder dellBuilder = new DellComputerBuilder();
        Computer dellComputer = director.constructor(dellBuilder);
        System.out.println(dellComputer);
    }
}
