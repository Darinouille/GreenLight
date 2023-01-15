import java.sql.SQLException;

import org.json.*;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        Lecture l;
        l = new Lecture();
        // Afficher le JSON : System.out.println(p.searchIntoDb());
        String jsonString = l.searchIntoDb();

        // On parse l'objet JSON
        JSONObject json = new JSONObject(jsonString);
        
        // On se connecte à la base de données pour écrire
        Ecriture e;
        String jour;
        int pos;

        e = new Ecriture();
        e.initDb();
        e.reinitialiser();
        
        pos = 0;
        int ordreJour[] = {3, 1, 2, 0};

        for (int j : ordreJour) {
            // On récupère la valeur du jour j : dvalue
            int dvalue = json.getJSONArray("signals").getJSONObject(pos).getInt("dvalue");
            // Le timestamp du jour
            // On a quelque chose sous la forme : yyyy-mm-jj-Thh:mm:ss+02:zz
            //                                    01234567890123456789012345
            // On souhaite avoir une forme : yyyy-mm-jj hh:mm:ss.zzzzzz

            String date = json.getJSONArray("signals").getJSONObject(pos).getString("jour");
            jour = date.substring(0, 10) + " " + date.substring(11, 19) + "." + date.substring(23, 25) + "0000";

            e.insertJour(j, jour, dvalue);

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
            pos = pos + 1;
        }
    }
}