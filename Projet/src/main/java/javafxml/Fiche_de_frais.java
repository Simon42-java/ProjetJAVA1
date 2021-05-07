package javafxml;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class Fiche_de_frais {

    static int montant;
    static String datefrai;
    static double nbkilometre;
    static double nbnuite;
    static double nbrepas;
    static double nbhorsf;
    static Scanner sc = new Scanner(System.in);
    static String url = "jdbc:mysql://127.0.0.1:3306/ap2_gsb?useUnicode=true"
    + "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&" + "serverTimezone=UTC";
    static String utilisateur = "root";
    static String motDePasse = "Simon59300sql";
    static Connection connexion = null;
    static String login;
    static String motdepasse;
    static String nom;
    static ResultSet rs = null;
    static double rsrepas = 0;
    static double nbkilometreprix;

    public static void main(String[] args) {

        entrerfrais();
        modifierfrais();
        fraissupp();
        supprimerfrais();
    }

    public static void entrerfrais() {

        System.out.println("Veuillez rentrer votre prenom");
        String prenom = sc.nextLine();

        System.out.println("Veuillez rentrer la date");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Saisir une date JJ.MM.AAAA");
        datefrai = sc.nextLine();
        if (datefrai.matches("[0-31]{2}[.][010203040506070809101112]{2}[.][2021-2021]{4}")) {

            // code de la base de donnée

        }

        System.out.println("Veuillez rentrer vos fraies de kilomètrique");
        nbkilometre = sc.nextDouble();
        double prixkilometre = nbkilometre * 0.67;

        
        System.out.println("Veuillez rentrer vos frais de nuité");
        nbnuite = sc.nextDouble();
        double prixnuite = nbnuite * 66;

        System.out.println("Veuillez rentrer vos frais de repas");
        nbrepas = sc.nextDouble();
/*
        try {
            connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
            String sql = "SELECT mfr_libelle" 
            + "FROM modele_frais;";
            PreparedStatement statement = connexion.prepareStatement(sql);
            rs = statement.executeQuery(sql);
            rsrepas = rs;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());

        }*/

        double prixrepas = nbrepas*23;

        System.out.println("Veuillez rentrer vos frais de hors forfait");
        nbhorsf = sc.nextDouble();

        System.out.println("Voici les fraies saisie actuellement");
        System.out.println("Vos frais kilomètrique sont : " + nbkilometre );
        System.out.println("Vos frais de repas sont : " + nbrepas );
        System.out.println("Vos frais de nuité sont : " + nbnuite );
        System.out.println("Vos frais de hors fortait : " + nbhorsf );

        double nbprixtotal = prixkilometre + prixrepas + prixnuite + nbhorsf;
        double frai = nbprixtotal *0.20;

        try {
            connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
            String sql = "INSERT INTO frais (fr_libelle_libre, fr_date, fr_quantite, fr_montant, fr_taxe, fk_tre, fk_fdrm_ag, fk_fdrm_mois)"
                    + "VALUE(?, ?, ?, ?, ?)";
            PreparedStatement statement = connexion.prepareStatement(sql);
            statement.setString(1, "frais kilometrique de"+prenom);
            statement.setString(2, datefrai);
            statement.setInt(3, 1);
            statement.setDouble(4, nbprixtotal);
            statement.setDouble(5, frai);
            statement.setString(6, null);
            statement.setDouble(7, 0);
            statement.setDouble(8, 1);
            statement.setString(9, datefrai);


            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }

    }

    public static boolean modifierfrais() {

        System.out.println("Voulez vous entrer de nouveau fraie true/false");
        boolean retry = sc.nextBoolean();
        sc.nextLine();

        if (retry == true) {

            double kilomedouble = nbkilometre;
            double nuitedouble = nbnuite;
            double repasdouble = nbrepas;
            double horsfdouble = nbhorsf;
            boolean pasok;
            String test = "null";
            pasok = true;

            while (pasok) {

                pasok = false;
                try {
                    System.out.println("Veuillez rentrer vos fraies de kilomètrique");
                    nbkilometre = sc.nextDouble();
                    kilomedouble = Double.parseDouble(test);

                    System.out.println("Veuillez rentrer vos frais de nuité");
                    nbnuite = sc.nextDouble();
                    nuitedouble = Double.parseDouble(test);

                    System.out.println("Veuillez rentrer vos frais de repas");
                    nbrepas = sc.nextDouble();
                    repasdouble = Double.parseDouble(test);

                    System.out.println("Veuillez rentrer vos frais de hors forfait");
                    nbhorsf = sc.nextDouble();
                    horsfdouble = Double.parseDouble(test);
                }

                catch (NumberFormatException e) {
                    System.out.println("Veuillez entrer des valeurs numériques");
                    pasok = true;
                }
            }

            System.out.println("Voici les fraies saisie actuellement");
            System.out.println("Vos frais kilomètrique sont : " + kilomedouble );
            System.out.println("Vos frais de repas sont : " + nuitedouble);
            System.out.println("Vos frais de nuité sont : " + repasdouble);
            System.out.println("Vos frais de hors fortait : " + horsfdouble);
        }
        return true;
    }

    public static void fraissupp() {

        boolean validation = false;
        validation = true;

        if (validation) {
            System.out.println("Votre validation est accepter ");
        } else {
            System.out.println("Vous n'avez pas remplie toutes les cases");
        }

        System.out.println("Voulez vous entrer des nouveaux fraies de hors forfait true/false");
        boolean horsforfait = sc.nextBoolean();

        if (horsforfait) {

            // try {
            SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println("Veuillez rentrer vos frais");
            double nouveaufraie = sc.nextDouble();
            sc.nextLine();
            String str = "null";
            boolean valide = true;

            while (valide) {
                valide = false;
                System.out.println("Saisir une date JJ.MM.AAAA");
                str = sc.nextLine();

                if (str.matches("[0-31]{2}[.][010203040506070809101112]{2}[.][2021-2021]{4}")) {

                    System.out.println("bonne date");

                }

                /*
                 * if (str == "dd/MM/2019") { System.out.
                 * println(" La date d'engagement doit se situer dans l’année écoulée"); }
                 */ else {
                    System.out.println("erreur entrer une date valide");
                    valide = true;

                }
            }
            System.out.println("Veuillez justifier vos frais");
            String justifier = sc.nextLine();
            System.out.println("Voici vos nouveau frais : " + nouveaufraie);
            System.out.println("Voici la date des frais : " + str);
            System.out.println("Voici votre justification : " + justifier);

        }
    }

    public static void supprimerfrais() {
        System.out.println("Voulez vous supprimer un frai de hros forfait");
        boolean supp = sc.nextBoolean();
        sc.nextLine();

        if (supp == true) {
            // Code pour supprimer une donnée dans la BDD
            System.out.println("Le frai est correctement supprimé");

        }

    }
}
