package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        // question 2
        int a = 5;
        int b = 10;
        System.out.println("Avant la permutation : a = "+a+" b = "+b);

        int c;
        c = a;
        a = b;
        b = c;

        System.out.println("Après la permutation : a = "+a+" b = "+b);

        // question 3 4 5

        if (args.length != 1){
            System.out.println("Invalid argument...");
        }else {
            //Reader.read(args[0]);
            System.out.println( utf8File.loadFileIntoString(args[0]));
        }

    }
}
