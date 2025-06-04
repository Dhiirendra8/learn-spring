package com.java.lambdas.interfaces;

public class Main {
    public static void main(String[] args) {
        FIFA obj = () -> "Dhirendra";
        String str = obj.defaultMethod(obj.method());
        System.out.println(str);
    }




}
