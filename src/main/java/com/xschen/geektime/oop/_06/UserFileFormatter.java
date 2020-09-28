package com.xschen.geektime.oop._06;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * OOP：面向对象
 *
 * 假设我们有一个记录了用户信息的文本文件 users.txt，
 * 每行文本的格式是 name&age&gender（比如，小王 &28& 男）。
 * 我们希望写一个程序，从 users.txt 文件中逐行读取用户信息，
 * 然后格式化成 name\tage\tgender（其中，\t 是分隔符）这种文本格式，
 * 并且按照 age 从小到大排序之后，重新写入到另一个文本文件 formatted_users.txt 中
 */
public class UserFileFormatter {
    public void format(String userFile, String formattedUserFile) throws IOException {
        List<User> users = new ArrayList<>();
        // open files
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(userFile));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(formattedUserFile));
        int len;
        byte[] arr = new byte[1024];
        while ((len = bis.read(arr)) != -1) { // read until file is empty
            User user = User.parseFromFile(new String(arr));
            users.add(user);
        }

        // sort users by age...

        for (int i = 0; i < users.size(); i++) {
            String formattedUserText = users.get(i).formatToText();
            // write to new file
            bos.write(formattedUserText.getBytes());

        }
        // close files
        bis.close();
        bos.close();

    }

    public static void main(String[] args) throws IOException {
        UserFileFormatter userFileFormatter = new UserFileFormatter();
        userFileFormatter.format("/home/zheng/users.txt", "/home/zheng/formatted_users.txt");
    }
}

class User {
    private String name;
    private String gender;
    private int age;

    public User(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public static User parseFromFile(String userInfoText) {
        // 将text(“小王&28&男”)解析成类User
        return null;
    }

    public String formatToText() {
        // 将类User格式化为文本（"小王\t28\t男"）
        return null;
    }
}
