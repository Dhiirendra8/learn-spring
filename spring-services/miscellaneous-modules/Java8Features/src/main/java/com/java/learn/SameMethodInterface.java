package com.java.learn;

interface IFA{
    void method();
}
interface IFB{
//    int method();
}
public class SameMethodInterface implements IFA, IFB {

    @Override
    public void method() {

    }
}
