package java8;

import util.DataUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class FunctionalInterfaceImpleClassDemo implements FunctionalInterfaceDemo {

    @Override
    public void logData() {
    }

    // We can override default methods in implementation classes,
    // Since default methods has default implementation,
    // We can call default method using 'super' like shown below.
    @Override
    public void testData(int i, String str) {
        FunctionalInterfaceDemo.super.testData(i, str);
    }

    // If we try to override static method, we will get compile time error
    // Although we can declare a method with same signature without @override method like shown below.
    //@Override
    static void sendData() {
        System.out.println("Send");
    }

    public static void main(String[] args) {

    }
}
