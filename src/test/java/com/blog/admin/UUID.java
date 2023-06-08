package com.blog.admin;

/**
 * @author:艾宾如
 * @createDate:2023/6/5
 * @description:
 **/
public class UUID {
    public static void main(String[] args) {
        java.util.UUID uuid= java.util.UUID.randomUUID();
        System.out.println("uuid = "+uuid.toString());
    }
}
