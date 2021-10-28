package ru.devopshelp.shildt;

import java.util.Arrays;
import java.util.Comparator;

interface MyValue {
    double getValue();
}

interface MyParamValue {
    double getValue(double v);
}

interface MyIntValue {
    int getValue();
}

public class LambdaDemo {
    public static void main(String[] args) {
        MyValue myVal;
        myVal = () -> 98.6;
        System.out.println("Persistent value: " + myVal.getValue());

        MyParamValue myPval = (n) -> 1.0 / n;
        System.out.println("Inverse value 4 equal " +
                            myPval.getValue(4.0));
        System.out.println("Inverse value 8 equal " +
                myPval.getValue(8.0));
        MyIntValue myIntVal = () -> Integer.parseInt("123");
        System.out.println(myIntVal.getValue());

        String[] numbers = {
                "1. Task",
                "2. Task",
                "11. Task"
        };
        Comparator<String> numStr = (left, right) -> {
            int first = Integer.parseInt(left.substring(0, left.indexOf(".")));
            int second = Integer.valueOf(right.substring(0, right.indexOf(".")));
            return second - first;
        };
        Arrays.sort(numbers, numStr);
        System.out.println(Arrays.toString(numbers));

    }
}
