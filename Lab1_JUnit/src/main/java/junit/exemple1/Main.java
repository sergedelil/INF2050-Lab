package junit.exemple1;

import java.util.Scanner;

public class Main {
    public static void main (String[] args) {

        long total = 0;

        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer un montant en sous");
        long montant = sc.nextLong();

        System.out.println("Taxe fédérale ? true/false");
        boolean tps = sc.nextBoolean();

        System.out.println("Taxe provinciale ? true/false");
        boolean tvq = sc.nextBoolean();

        try {
            total = Facture.ajouterTaxe(montant, tps, tvq);
            System.out.println("Le montant avant taxe est       : " + montant);
            System.out.println("Le montant taxes incluses est   : " + total);
        }catch (IllegalArgumentException e){
            System.out.println(e.toString());
        }
    }
}
