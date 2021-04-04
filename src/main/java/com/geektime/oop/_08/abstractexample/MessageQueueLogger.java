package com.geektime.oop._08.abstractexample;


import java.util.logging.Level;

// 抽象类的子类: 输出日志到消息中间件(比如kafka)
public class MessageQueueLogger extends Logger {
    private MessageQueueClient msgQueueClient;

    public MessageQueueLogger(String name,
                              boolean enabled,
                              Level minPermittedLevel,
                              MessageQueueClient msgQueueClient) {
        super(name, enabled, minPermittedLevel);
        this.msgQueueClient = msgQueueClient;
    }

    protected void dolog(Level level, String message) {
        // 格式化level和message，输出到消息中间件
        msgQueueClient.send("");
    }
}
