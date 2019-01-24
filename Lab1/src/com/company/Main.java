package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        if (args.length != 1){
            System.out.println("Invalid argument...");
        }else {
            //Reader.read(args[0]);
            System.out.println( utf8File.loadFileIntoString(args[0]));
        }

    }
}
