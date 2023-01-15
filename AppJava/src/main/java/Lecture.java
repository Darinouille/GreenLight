import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class Lecture {

    private Connection connexion;

    public Connection getConnexion () {
        return connexion;
    }

    public void initDb () {        
        try {
            connexion.createStatement();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String searchIntoDb () throws SQLException {
        String sql;
        ResultSet rs;
        String resultat;

        sql = "select * from Infos";
        rs = null;
        resultat = null;

        try (
        PreparedStatement pstmt  = connexion.prepareStatement(sql)) {
            rs  = pstmt.executeQuery();
            // Traitement du résultat
            while (rs.next()) {
                // On récupère l'objet JSON
                resultat = rs.getString("data");
            }
        }
        catch (SQLException e) {
        resultat = e.getMessage();
        }
        return resultat;
    }

    public Lecture() {
        try {
            // L'url d'accès
            // À MODIFIER SI LA SOURCE DE LA BASE DE DONNÉES CHANGE
            String url = "jdbc:sqlite:sqlite/ecowattDemo.db";
            // Créer une bd ou l'ouvrir si existante
            connexion = DriverManager.getConnection(url);
            System.out.println("\nConnexion au fichier ecowattDemo.db établie.");    
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}