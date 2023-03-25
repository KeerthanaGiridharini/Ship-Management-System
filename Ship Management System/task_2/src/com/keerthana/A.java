package com.keerthana;

public class A {
    static int numA = 4, numB = 5;

    public static void main(String[] args) {
        int numA = 3, numB = 2;
        theCode(numA,numB);
        System.out.println(numA + " " + numB);
    }

    public static void theCode(int numB,int numA) {
        numA = numA + 1;
        numB = numB + 1;
        System.out.println(numA + " " + numB);

    }

}


