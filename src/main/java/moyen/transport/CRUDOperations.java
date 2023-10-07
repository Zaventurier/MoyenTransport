package moyen.transport;

import java.sql.*;

public class CRUDOperations {
    private Connection connection;

    public CRUDOperations(Connection connection) {
        this.connection = connection;
    }

    // Méthode pour insérer un moyen de transport
    public void insertMoyenTransport(String type, String marque, String modele, double vitesse, double vitesseMax) throws SQLException {
        String insertQuery = "INSERT INTO moyen_de_transport (marque, modele, vitesse, vitesse_max) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setString(1, marque);
            preparedStatement.setString(2, modele);
            preparedStatement.setDouble(3, vitesse);
            preparedStatement.setDouble(4, vitesseMax);

            preparedStatement.executeUpdate();
            System.out.println("Moyen de transport inséré avec succès.");
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'insertion du moyen de transport : " + e.getMessage());
        }
    }

    // Méthode pour lire un moyen de transport
    public void readMoyenTransport() throws SQLException {
        Statement statement = connection.createStatement();
        String sqlQuery = "SELECT * FROM moyen_de_transport";

        // Exécution de la requête
        ResultSet resultSet = statement.executeQuery(sqlQuery);

        // Parcourir les résultats et afficher les enregistrements
        while (resultSet.next()) {
            int id = resultSet.getInt("id_transport");
            String marque = resultSet.getString("marque");
            String modele = resultSet.getString("modele");
            Double vitesse = resultSet.getDouble("vitesse");
            Double vitesseMax = resultSet.getDouble("vitesse_max");

            System.out.println("ID: " + id + ", Marque: " + marque + ", modele: " + modele + ", vitesse: " + vitesse + " vitesseMax: " + vitesseMax);
        }
    }

    // Méthode pour mettre à jour un moyen de transport
    public void updateMoyenTransport(int type, String marque, String modele, double vitesse, double vitesseMax) throws SQLException {
        String updateQuery = "UPDATE moyen_de_transport SET marque = ?, modele = ?, vitesse = ?, vitesse_max = ? WHERE id_transport = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setString(1, marque);
            preparedStatement.setString(2, modele);
            preparedStatement.setDouble(3, vitesse);
            preparedStatement.setDouble(4, vitesseMax);
            preparedStatement.setInt(5, type);

            preparedStatement.executeUpdate();
            System.out.println("Moyen de transport mis à jour avec succès.");
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour du moyen de transport : " + e.getMessage());
        }
    }

    // Méthode pour supprimer un moyen de transport
    public void deleteMoyenTransport(int id) throws SQLException {
        String deleteQuery = "DELETE FROM moyen_de_transport WHERE id_transport = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, id);

            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Moyen de transport supprimé avec succès.");
            } else {
                System.out.println("Aucun moyen de transport trouvé avec l'ID : " + id);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression du moyen de transport : " + e.getMessage());
        }
    }
}
