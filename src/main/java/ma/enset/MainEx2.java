package ma.enset;

import java.util.ArrayList;
import java.util.Scanner;

public class MainEx2 {
    public static void main(String[] args) {
        ArrayList<CompteBancaire> comptes = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        // Ajout de comptes
        comptes.add(new CompteCourant("1", "Meryem", 1000, 500));
        comptes.add(new CompteEpargne("2", "Asmaa", 1500, 0.02));

        try {
            // Affichage initial
            System.out.println("Liste des comptes :");
            for (CompteBancaire c : comptes) {
                c.afficher();
            }

            // Dépôt
            comptes.get(0).depot(200);
            System.out.println("\nDépôt de 200 DH effectué sur le compte de Meryem.");

            // Retrait
            comptes.get(1).retirer(300);
            System.out.println("Retrait de 300 DH effectué sur le compte d'Asmaa.");

            // Transfert entre comptes existants
            comptes.get(0).transfertVers(comptes.get(1), 400);
            System.out.println("Transfert de 400 DH de Meryem vers Asmaa.");

            //  Transfert vers un compte inexistant (null)
            comptes.get(0).transfertVers(null, 100);

        } catch (FondsInsuffisantsException | CompteInexistantException e) {
            System.err.println("Erreur : " + e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Compte non trouvé dans la liste.");
        }

        // Suppression d’un compte par numéro
        String numeroASupprimer = "1";
        comptes.removeIf(c -> c.getNumero().equals(numeroASupprimer));
        System.out.println("\nCompte " + numeroASupprimer + " supprimé.");


        System.out.println("\nÉtat final des comptes :");
        for (CompteBancaire c : comptes) {
            c.afficher();
        }

        sc.close();
    }
}
