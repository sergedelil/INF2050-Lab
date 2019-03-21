package junit.exemple1;

public class Facture {



    private static final double TPS = 0.05;
    private static final double TVQ = 0.09975;

    public static long ajouterTaxe(long montant, boolean tps, boolean tvq) throws IllegalArgumentException {

        if(montant < 0 || montant == 0 )
            throw new IllegalArgumentException("Illegal argument exception");

        double taxe = 0;
        if (tps && tvq)
            taxe = (montant * TPS) + (montant * TVQ);
        else if (tps)
            taxe = montant * TPS;
        else if (tvq)
            taxe = montant * TVQ;
        return (long)(taxe + montant);
    }




}
