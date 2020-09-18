package com.xschen.oop._10;

/**
 * @author xschen
 *
 * 演示利用组合，接口，委托解决继承存在过深的问题
 */


public class Ostrich implements Tweetable, EggLayable { // 鸵鸟只会叫和飞
    private TweetAblity tweetAblity = new TweetAblity(); // 组合
    private EggLayAblity eggLayAblity = new EggLayAblity(); // 组合

    // 省略其他属性和方法


    @Override
    public void layEgg() {
        eggLayAblity.layEgg(); // 委托
    }

    @Override
    public void tweet() {
        tweetAblity.tweet(); // 委托
    }
}
