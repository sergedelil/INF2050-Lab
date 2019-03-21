package junit.exemple2;

public class Monnaie {

    private int totalCents = 0;

    public Monnaie (int dollars, int cents)throws IllegalArgumentException  {

        if(dollars < 0 || cents < 0 || cents > 99){
            throw new IllegalArgumentException("Illegal argument exception");
        }else{
            totalCents = dollars * 100 + cents;
        }
    }
    public Monnaie(){}

    public int getDollars (){

        return this.totalCents / 100;
    }

    public int getCents(){

        return this.totalCents % 100;
    }

    public int getTotalCents(){

        return this.totalCents;
    }

    public void additionner (Monnaie autre){

        this.totalCents += autre.getTotalCents();
    }

    public String convertir(){

        return getDollars() + "." + getCents() + "$";
    }

    public void pourcentage(int taux){

        int valeur = this.totalCents * taux;
        totalCents = (valeur / 100) + (valeur % 100);
    }

    public void soustraire (Monnaie autre) throws OperationInvalideException {

        verifierOperandes(autre);
        this.totalCents -= autre.totalCents;
    }

    private void verifierOperandes(Monnaie autre) throws OperationInvalideException {

        if ( this.totalCents < autre.getTotalCents()) {

            throw new OperationInvalideException("Opération impossible : "
                    + this.totalCents + " - " + autre.totalCents);
        }
    }
}