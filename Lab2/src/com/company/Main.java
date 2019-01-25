package com.company;


import java.io.FileNotFoundException;
import java.util.ArrayList;

import static javafx.application.Platform.exit;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, LabINF2050Exception {

        if (args.length != 1){
            System.out.println("nombre d'arguments invalide...");
            exit();
        }

        JSONHash obj = new JSONHash(args[0]);
        obj.load();
        System.out.println("Le nombre d'albums : " + obj.countAlbum());
        System.out.println("Le nombre de singles : " + obj.countSingle());


        System.out.println("La liste des albums publiés depuis 2003 : " );
        obj.getListAlbumFrom2003();

        System.out.println("La liste des albums avec une note de 5 : " );
        obj.getListAlbumNote5();

        System.out.println("La liste des 3 albums préferés : " );
        obj.getListAlbumPreferes();


    }
}
