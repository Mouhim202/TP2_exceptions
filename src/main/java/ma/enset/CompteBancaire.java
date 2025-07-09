package ma.enset;

public abstract class CompteBancaire {
    protected String numero;
    protected double solde;
    protected String titulaire;

    public CompteBancaire(String numero, String titulaire, double soldeInitial) {
        this.numero = numero;
        this.titulaire = titulaire;
        this.solde = soldeInitial;
    }
    public double getSolde() {
        return solde;
    }
    public void setSolde(double solde) {
        this.solde = solde;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getTitulaire() {
        return titulaire;
    }

    public void setTitulaire(String titulaire) {
        this.titulaire = titulaire;
    }

    public void depot(double montant) {
        solde += montant;
    }

    public void retirer(double montant) throws FondsInsuffisantsException {
        if (montant > solde) {
            throw new FondsInsuffisantsException("Fonds insuffisants pour le retrait.");
        }
        solde -= montant;
    }

    public abstract void afficher();

    public void transfertVers(CompteBancaire autreCompte, double montant) throws FondsInsuffisantsException, CompteInexistantException {
        if (autreCompte == null) {
            throw new CompteInexistantException("Compte de destination inexistant.");
        }
        this.retirer(montant);
        autreCompte.depot(montant);
    }
}

