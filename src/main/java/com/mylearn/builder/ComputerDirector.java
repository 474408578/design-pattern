package com.mylearn.builder;

/**
 * @author xschen
 */


public class ComputerDirector {

    public Computer constructor(Builder builder) {
        Computer computer;
        builder.buildBrand();
        builder.buildCPU();
        builder.buildDisplayCard();
        builder.buildHardDisk();
        builder.buildMainBoard();
        builder.buildMemory();
        builder.buildPower();
        computer = builder.createComputer();
        return computer;
    }
}
