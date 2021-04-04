package com.geektime.oop._08.abstractexample;

import java.util.logging.Level;

/**
 * Logger记录日志的抽象类
 *
 * 抽象类不允许被实例化，只能被继承
 *
 * 抽象类可以包含属性和方法，方法既可以包含代码实现，也可以不包含
 *
 * 子类继承抽象类，必须实现抽象类的所有抽象方法
 *
 */
public abstract class Logger {
    private String name;
    private boolean enabled;
    private Level minPermittedLevel;

    public Logger(String name, boolean enabled, Level minPermittedLevel) {
        this.name = name;
        this.enabled = enabled;
        this.minPermittedLevel = minPermittedLevel;
    }

    public void log(Level level, String message) {
        boolean loggable = enabled && (minPermittedLevel.intValue() <= level.intValue());
        if (!loggable) return;
        dolog(level, message);
    }

    protected abstract void dolog(Level level, String message);
}
