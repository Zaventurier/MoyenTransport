package moyen.transport;

class Avion extends MoyenTransport {
    private double altitude;
    private double altitudeMax;
    private double portee;

    // Constructeur, getters, setters...

    // Exemple de constructeur
    public Avion(int id, String marque, String modele, double vitesse, double vitesseMax,
                 double altitude, double altitudeMax, double portee) {
        super(id, marque, modele, vitesse, vitesseMax);
        this.altitude = altitude;
        this.altitudeMax = altitudeMax;
        this.portee = portee;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public double getAltitudeMax() {
        return altitudeMax;
    }

    public void setAltitudeMax(double altitudeMax) {
        this.altitudeMax = altitudeMax;
    }

    public double getPortee() {
        return portee;
    }

    public void setPortee(double portee) {
        this.portee = portee;
    }
}

