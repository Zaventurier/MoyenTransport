package moyen.transport;

class Bateau extends MoyenTransport {
    private double tirantEau;
    private int nbrVoiles;

    // Constructeur, getters, setters...

    // Exemple de constructeur
    public Bateau(int id, String marque, String modele, double vitesse, double vitesseMax,
                  double tirantEau, int nbrVoiles) {
        super(id, marque, modele, vitesse, vitesseMax);
        this.tirantEau = tirantEau;
        this.nbrVoiles = nbrVoiles;
    }

    public double getTirantEau() {
        return tirantEau;
    }

    public void setTirantEau(double tirantEau) {
        this.tirantEau = tirantEau;
    }

    public int getNbrVoiles() {
        return nbrVoiles;
    }

    public void setNbrVoiles(int nbrVoiles) {
        this.nbrVoiles = nbrVoiles;
    }
}

