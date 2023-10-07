package moyen.transport;

public abstract class MoyenTransport {
    protected int id;
    protected String marque;
    protected String modele;
    protected double vitesse;
    protected double vitesseMax;

    public MoyenTransport(int id, String marque, String modele, double vitesse, double vitesseMax) {
        this.id = id;
        this.marque = marque;
        this.modele = modele;
        this.vitesse = vitesse;
        this.vitesseMax = vitesseMax;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public double getVitesse() {
        return vitesse;
    }

    public void setVitesse(double vitesse) {
        this.vitesse = vitesse;
    }

    public double getVitesseMax() {
        return vitesseMax;
    }

    public void setVitesseMax(double vitesseMax) {
        this.vitesseMax = vitesseMax;
    }
}
