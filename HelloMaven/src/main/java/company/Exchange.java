package company;

public class Exchange {

    public static void permuter(int a, int b){

        System.out.println("\n=====================================");
        System.out.println("Avant la permutation : A = "+a+" B = "+b);
        int c;
        c = a;
        a = b;
        b = c;
        System.out.println("Après la permutation : A = "+a+" B = "+b);
        System.out.println("=====================================\n");
    }
}
