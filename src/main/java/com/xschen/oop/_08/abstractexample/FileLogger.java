package com.xschen.oop._08.abstractexample;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;


/**
 * 抽象类的子类：输出日志到文件
 */
public class FileLogger extends Logger {
    private Writer fileWriter;

    public FileLogger(String name,
                      boolean enabled,
                      Level minPermittedLevel,
                      String filePath) {
        super(name, enabled, minPermittedLevel);
        try {
            this.fileWriter = new FileWriter(filePath) ;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void dolog(Level level, String message) {
        try {
            fileWriter.write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Logger logger = new FileLogger("access-log", true,
                Level.WARNING, "/users/wangzhen/access.log");

        logger.log(Level.WARNING, "this is a test log message");
    }
}
