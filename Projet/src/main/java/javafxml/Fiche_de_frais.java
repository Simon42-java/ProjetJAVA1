package javafxml;

import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class Fiche_de_frais {

    static String nbkilometre;
    static String nbnuite;
    static String nbrepas;
    static String nbhorsf;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        entrerfrais();
        modifierfrais();
        fraissupp();
    }

    public static void entrerfrais() {

        System.out.println("Veuillez rentrer vos fraies de kilomètrique");
        nbkilometre = sc.nextLine();

        System.out.println("Veuillez rentrer vos frais de nuité");
        nbnuite = sc.nextLine();

        System.out.println("Veuillez rentrer vos frais de repas");
        nbrepas = sc.nextLine();

        System.out.println("Veuillez rentrer vos frais de hors forfait");
        nbhorsf = sc.nextLine();

        System.out.println("Voici les fraies saisie actuellement");
        System.out.println("Vos frais kilomètrique sont : " + nbkilometre + "€");
        System.out.println("Vos frais de repas sont : " + nbrepas + "€");
        System.out.println("Vos frais de nuité sont : " + nbnuite + "€");
        System.out.println("Vos frais de hors fortait : " + nbhorsf + "€");
    }

    public static boolean modifierfrais() {

        System.out.println("Voulez vous entrer de nouveau fraie true/false");
        boolean retry = sc.nextBoolean();
        sc.nextLine();

        if (retry == true) {

            double kilomedouble = 0;
            double nuitedouble = 0;
            double repasdouble = 0;
            double horsfdouble = 0;
            boolean pasok;
            pasok = true;

            while (pasok) {

                pasok = false;
                try {
                    System.out.println("Veuillez rentrer vos fraies de kilomètrique");
                    nbkilometre = sc.nextLine();
                    kilomedouble = Double.parseDouble(nbkilometre);

                    System.out.println("Veuillez rentrer vos frais de nuité");
                    nbnuite = sc.nextLine();
                    nuitedouble = Double.parseDouble(nbnuite);

                    System.out.println("Veuillez rentrer vos frais de repas");
                    nbrepas = sc.nextLine();
                    repasdouble = Double.parseDouble(nbrepas);
                    System.out.println("Veuillez rentrer vos frais de hors forfait");
                    nbhorsf = sc.nextLine();
                    horsfdouble = Double.parseDouble(nbhorsf);
                }

                catch (NumberFormatException e) {
                    System.out.println("Veuillez entrer des valeurs numériques");
                    pasok = true;
                }
            }

            System.out.println("Voici les fraies saisie actuellement");
            System.out.println("Vos frais kilomètrique sont : " + kilomedouble + "€");
            System.out.println("Vos frais de repas sont : " + nuitedouble + "€");
            System.out.println("Vos frais de nuité sont : " + repasdouble + "€");
            System.out.println("Vos frais de hors fortait : " + horsfdouble + "€");
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
            System.out.println("Saisir une date JJ/MM/AAAA");
            String str = sc.nextLine();

            if (str.matches("dd/MM/yyyy")) {

                System.out.println("bonne date");

            } else {
                System.out.println("erreur entrer une date valide");
            }

            System.out.println("Veuillez justifier vos frais");
            String justifier = sc.nextLine();
            System.out.println("Voici vos nouveau frais : " + nouveaufraie);
            System.out.println("Voici la date des frais : " + str);
            System.out.println("Voici votre justification : " + justifier);
            // } catch (NumberFormatException a) {
            // System.out.println("Veillez remplir les champs si dessus");
        }

    }
}
