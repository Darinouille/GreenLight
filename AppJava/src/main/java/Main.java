import java.sql.SQLException;

import org.json.*;

public class Main {
    // Pour convertir le format de date ecowattDemo.db en format de date sql
    public static String convertirDate(String date1) {
        String date2;
        // On a quelque chose sous la forme : yyyy-mm-jj-Thh:mm:ss+02:zz
        //                                    01234567890123456789012345

        // On souhaite avoir une forme : yyyy-mm-jj hh:mm:ss.zzzzzz

        date2 = date1.substring(0, 10) + " " + date1.substring(11, 19) + "." + date1.substring(23, 25) + "0000";
        return date2;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        Lecture l;
        l = new Lecture();
        // Afficher le JSON : System.out.println(p.searchIntoDb());
        String jsonString = l.searchIntoDb();

        // On parse l'objet JSON
        JSONObject json = new JSONObject(jsonString);
        
        // On se connecte à la base de données pour écrire
        Ecriture e;
        int pos;

        e = new Ecriture();
        e.initDb();
        e.reinitialiser();
        
        pos = 0;
        int ordreJour[] = {3, 1, 2, 0};

        for (int j : ordreJour) {
            // On récupère la date de génération du fichier : generationFichier
            String dateF = json.getJSONArray("signals").getJSONObject(pos).getString("GenerationFichier");
            String generationFichier = convertirDate(dateF);

            // On récupère la valeur du jour j : dvalue
            int dvalue = json.getJSONArray("signals").getJSONObject(pos).getInt("dvalue");
            // Le timestamp du jour
            String date = json.getJSONArray("signals").getJSONObject(pos).getString("jour");
            String jour = convertirDate(date);

            e.insertJour(j, jour, generationFichier, dvalue);

            System.out.println("\n✽ J+" + j + " (" + jour + ") | valeur : " + dvalue);
            System.out.println("Voici les données pour chaque heure de ce jour");

            // On récupères les valeurs des heures h : hvalue
            JSONArray valeursH = json.getJSONArray("signals").getJSONObject(pos).getJSONArray("values");
            int valeurH1 = json.getJSONArray("signals").getJSONObject(pos).getJSONArray("values").getJSONObject(0).getInt("pas");

            for (int h = valeurH1; h < valeursH.length(); h++) {
                int hvalue = valeursH.getJSONObject(h).getInt("hvalue");
                e.insertHeure(h, hvalue, j);

                System.out.println("• " + h + "h : " + hvalue);
            }

            System.out.println("La génération du fichier date du : " + generationFichier);
            pos = pos + 1;
        }
    }
}
