package ma.enset;

public class CompteCourant extends CompteBancaire {
    private double decouvertAutorise;

    public CompteCourant(String numero, String titulaire, double soldeInitial, double decouvertAutorise) {
        super(numero, titulaire, soldeInitial);
        this.decouvertAutorise = decouvertAutorise;
    }

    @Override
    public void retirer(double montant) throws FondsInsuffisantsException {
        if (montant > solde + decouvertAutorise) {
            throw new FondsInsuffisantsException("Dépassement du découvert autorisé.");
        }
        solde -= montant;
    }

    @Override
    public void afficher() {
        System.out.println("Compte Courant - Numéro : " + numero + ", Titulaire : " + titulaire + ", Solde : " + solde + ", Découvert autorisé : " + decouvertAutorise);
    }
}
