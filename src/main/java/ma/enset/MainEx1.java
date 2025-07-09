package ma.enset;
import java.util.Scanner;
public class MainEx1 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Entrez une valeur : ");
            int val = sc.nextInt();

            EntierNaturel entier = new EntierNaturel(val);
            System.out.println("Valeur initiale : " + entier.getVal());

            entier.decrementer();
            System.out.println("Après décrémentation : " + entier.getVal());

        } catch (NombreNegatifException e) {
            System.err.println("Exception attrapée : " + e.getMessage());
            System.err.println("Valeur erronée : " + e.getValeurErronee());
        }
    }
}

