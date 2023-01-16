import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class Ecriture {

    private Connection connexion;

    public Connection getConnexion () {
        return connexion;
    }

    // Pour initier une connexion
    public void initDb () {        
        try {
            connexion.createStatement();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Pour ajouter dans la table Jour
    public void insertJour(int j, String jour, int dvalue) {
        String sql;

        sql = "INSERT INTO `Jour` (`idJour`, `jour`, `#dvalue`) VALUES (?, ?, ?)";
        try (
        PreparedStatement pstmt = connexion.prepareStatement(sql)) {
            pstmt.setInt(1, j);
            pstmt.setString(2, jour);
            pstmt.setInt(3, dvalue);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Pour ajouter dans la table Heure
    public void insertHeure(int pas, int hvalue, int j) {
        String sql;

        sql = "INSERT INTO `Heure` (`idValue`, `pas`, `hvalue`, `#idJour`) VALUES (NULL, ?, ?, ?)";
        try (
        PreparedStatement pstmt = connexion.prepareStatement(sql)) {

            pstmt.setInt(1, pas);
            pstmt.setInt(2, hvalue);
            pstmt.setInt(3, j);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Pour réinitialiser les tables Jour et Heure
    public void reinitialiser() {
        String sql1;
        String sql2;

        sql1 = "TRUNCATE TABLE `cd006182`.`Jour`";
        sql2 = "TRUNCATE TABLE `cd006182`.`Heure`";
        try (PreparedStatement pstmt = connexion.prepareStatement(sql2)) {
            pstmt.executeUpdate();
            System.out.println("\nRéinitialisation des données Heure");
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        try (PreparedStatement pstmt = connexion.prepareStatement(sql1)) {
            pstmt.executeUpdate();
            System.out.println("Réinitialisation des données Jour");
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Ecriture() throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // À MODIFIER SI LE SERVEUR PHPMYADMIN CHANGE
            // Créer une bd ou l'ouvrir si existante
            //connexion = DriverManager.getConnection("jdbc:mysql://isis.unice.fr:3306/cd006182", "cd006182", "cd0061823efb");
            connexion = DriverManager.getConnection("jdbc:mysql://localhost/cd006182", "root", "");
            System.out.println("\nConnexion à phpMyAdmin établie.");
        }
        //catch(ClassNotFoundException | SQLException e){
        catch (SQLException e) {
            System.err.println(e);
        }
    }
}
