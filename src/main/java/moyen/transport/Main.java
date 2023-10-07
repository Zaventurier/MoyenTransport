package moyen.transport;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        DatabaseConnector connector = new DatabaseConnector();
        int choix;
        do {
            System.out.println("Menu :");
            System.out.println("1. Se connecter à la base de données");
            System.out.println("2. Créer un moyen de transport");
            System.out.println("3. Lire les moyens de transport");
            System.out.println("4. Mettre à jour un moyen de transport");
            System.out.println("5. Supprimer un moyen de transport");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");
            choix = sc.nextInt();
            sc.nextLine();  // Pour consommer la ligne après le choix

            switch (choix) {
                case 1:
                    /**
                     * Cas 1 : Se connecter à la base de données : on demande à l'utilisateur de saisir la bdd, nom d'utilisateur et mdp pour se connecter à la bdd
                     */
                    String bdd = "transport";
                    String util = "root";
                    String passwd = "";

                    System.out.println(" - Connexion à la base de données (saisie de vos identifiants de connexion) - ");

                    /*System.out.println("Connexion à la base de données - Veuillez entrer vos identifiants\n");

                    System.out.print("Saisissez l'identifiant de la base de données : ");
                    bdd = sc.nextLine();

                    System.out.print("Saisissez votre nom d'utilisateur : ");
                    util = sc.nextLine();

                    System.out.print("Saisissez votre mot de passe : ");
                    passwd = sc.nextLine();*/

                    // Construire l'URL JDBC avec le nouvel identifiant de base de données
                    String jdbcUrl = "jdbc:mysql://localhost:3306/" + bdd;

                    // Créer un nouveau connecteur avec les nouvelles informations

                    try {
                        connector.connect(jdbcUrl, util, passwd);
                        System.out.println("Connexion réussie à la base de données.");
                    } catch (SQLException e) {
                        System.err.println("Erreur lors de la connexion à la base de données : " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println(" - Création d'un moyen de transport (saisie de vos données) - ");
                    // Saisie des détails du moyen de transport à créer
                    System.out.print("Saisissez le type de moyen de transport (Voiture, Bateau, Avion) : ");
                    String type = sc.nextLine();

                    System.out.print("Saisissez la marque du moyen de transport (String attendu) : ");
                    String marque = sc.nextLine();

                    System.out.print("Saisissez le modèle du moyen de transport (String attendu) : ");
                    String modele = sc.nextLine();

                    System.out.print("Saisissez la vitesse du moyen de transport (Double attendu): ");
                    double vitesse = Double.parseDouble(sc.nextLine());

                    System.out.print("Saisissez la vitesse maximale du moyen de transport (Double attendu) : ");
                    double vitesseMax = Double.parseDouble(sc.nextLine());

                    // Appel à la fonction pour créer un moyen de transport
                    Connection connection = connector.getConnection();
                    CRUDOperations crudOperations = new CRUDOperations(connection);
                    crudOperations.insertMoyenTransport(type, marque, modele, vitesse, vitesseMax);
                    break;

                case 3:
                    System.out.println(" - Affichage des données - ");
                    Connection connectionRead = connector.getConnection();
                    CRUDOperations crudOperationsRead = new CRUDOperations(connectionRead);
                    crudOperationsRead.readMoyenTransport();
                    //System.out.println("En développement...");
                    break;
                case 4:
                    // Saisie des détails du moyen de transport à créer
                    System.out.print("Saisissez l'ID");
                    int UpdateType = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Saisissez la marque du moyen de transport (String attendu) : ");
                    String UpdateMarque = sc.nextLine();

                    System.out.print("Saisissez le modèle du moyen de transport (String attendu) : ");
                    String UpdateModele = sc.nextLine();

                    System.out.print("Saisissez la vitesse du moyen de transport (Double attendu): ");
                    double UpdateVitesse = Double.parseDouble(sc.nextLine());

                    System.out.print("Saisissez la vitesse maximale du moyen de transport (Double attendu) : ");
                    double UpdateVitesseMax = Double.parseDouble(sc.nextLine());

                    Connection connectionUpdate = connector.getConnection();
                    CRUDOperations crudOperationsUpdated = new CRUDOperations(connectionUpdate);
                    crudOperationsUpdated.updateMoyenTransport(UpdateType, UpdateMarque, UpdateModele, UpdateVitesse, UpdateVitesseMax);
                    break;
                case 5:
                    System.out.println("En développement...");
                    System.out.println("Saisir un id : ");
                    int id = sc.nextInt();
                    Connection connectionDelete = connector.getConnection();
                    CRUDOperations crudOperationsDelete = new CRUDOperations(connectionDelete);
                    crudOperationsDelete.deleteMoyenTransport(id);
                    break;
                case 0:
                    connector.close();
                    System.out.println("Au revoir !");
                    break;

                default:
                    System.out.println("Choix non valide. Veuillez réessayer.");
                    break;
            }
        } while (choix != 0);

    }
}

