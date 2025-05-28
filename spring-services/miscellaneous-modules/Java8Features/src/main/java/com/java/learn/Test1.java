package com.java.learn;

class A{
    static{
        System.out.println("Static Block");
    }
    public A(){
        System.out.println("Constructor");
    }
}
public class Test1 {
    public static void main(String[] args) {
        A obj = null;
//        obj = new A();
    }

}
