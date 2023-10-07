package moyen.transport;

class Voiture extends MoyenTransport {
    private String immatriculation;
    private double cylindree;

    // Constructeur, getters, setters...

    // Exemple de constructeur
    public Voiture(int id, String marque, String modele, double vitesse, double vitesseMax,
                   String immatriculation, double cylindree) {
        super(id, marque, modele, vitesse, vitesseMax);
        this.immatriculation = immatriculation;
        this.cylindree = cylindree;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public double getCylindree() {
        return cylindree;
    }

    public void setCylindree(double cylindree) {
        this.cylindree = cylindree;
    }
}

