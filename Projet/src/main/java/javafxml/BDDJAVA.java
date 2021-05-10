package javafxml;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class BDDJAVA {
    
    static String url = "jdbc:mysql://127.0.0.1:3306/ap2_gsb ?useUnicode=true"
            + "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&" + "serverTimezone=UTC";
    static String utilisateur = "root";
    static String motDePasse = "Simon59300sql";
    static Connection connexion = null;
    static String login;
    static String motdepasse;
    static String nom;
    static ResultSet rs = null;

    public static void main(String[] args) {
        //tester le code
        selectBDD();
    }

    public static void selectBDD() {

        try {
            connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
            String sql = "SELECT ag_nom_utilisateur, ag_password FROM agents where ag_nom_utilisateur LIKE'" + login
                    + "'and ag_password like'" + motdepasse + "';";
            PreparedStatement statement = connexion.prepareStatement(sql);
            rs = statement.executeQuery(sql);
            System.out.println("A new user was inserted successfully!" + sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());

        }
    }

    public static void InsertBDD() {
        try {
            connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
            String sql = "INSERT INTO agents (ag_nom_utilisateur, ag_password, fk_se, fk_ta, fk_ve) "
                    + "VALUE(?, ?, ?, ?, ?)";
            PreparedStatement statement = connexion.prepareStatement(sql);
            statement.setString(1, "lucas");
            statement.setString(2, "lucas");
            statement.setInt(3, 2);
            statement.setInt(4, 1);
            statement.setString(5, "AAAAAAF");

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
    }

    public static void UpdateBDD() {
        try {
            System.out.println("sairir votre nouveau nom");
            Scanner newnom = new Scanner(System.in);
            nom = newnom.nextLine();
            connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
            String sql = "UPDATE agents SET ag_nom_utilisateur='" + nom + "' WHERE ag_matricule= 5";
            PreparedStatement statement = connexion.prepareStatement(sql);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing user was updated successfully!");

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
    }
}
