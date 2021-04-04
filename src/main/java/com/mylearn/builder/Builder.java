package com.mylearn.builder;

/**
 * @author xschen
 * todo: 抽象建造者builder
 */


public abstract class Builder {
    protected Computer computer = new Computer();

    public abstract void buildBrand();

    public abstract void buildCPU();

    public abstract void buildMainBoard();

    public abstract void buildHardDisk();

    public abstract void buildDisplayCard();

    public abstract void buildPower();

    public abstract void buildMemory();

    public Computer createComputer(){
        return computer;
    }
}
