package javafxml;

import java.util.Scanner;

public class Fiche_de_fraie {
    public static void main(String[] args) {

    
        //nuité, kilomètre, repas
        Scanner sc = new Scanner(System.in);   
        System.out.println("Veuillez rentrer vos fraies de kilomètrique");
        double nbkilometre = sc.nextDouble(); 
        
        System.out.println("Veuillez rentrer vos frais de nuité");
        double nbnuité = sc.nextDouble();
    
        System.out.println("Veuillez rentrer vos frais de repas");
        double nbrepas = sc.nextDouble();
    
        System.out.println("Veuillez rentrer vos frais de hors forfait");
        double nbhorsf = sc.nextDouble();
    
        System.out.println("Voici les fraies saisie actuellement");
        System.out.println("Vos frais kilomètrique sont : " + nbkilometre + "€");
        System.out.println("Vos frais de repas sont : " + nbrepas + "€");
        System.out.println("Vos frais de nuité sont : " + nbnuité + "€");
        System.out.println("Vos frais de hors fortait : " + nbhorsf + "€");
    
        System.out.println("Voulez vous entrer de nouveau fraie true/false");
        boolean retry = sc.nextBoolean();
        
        if (retry) {
          
        try { 
    
        System.out.println("Veuillez rentrer vos fraies de kilomètrique");
        nbkilometre = sc.nextDouble(); 
    
        System.out.println("Veuillez rentrer vos frais de nuité");
        nbnuité = sc.nextDouble();
    
        System.out.println("Veuillez rentrer vos frais de repas");
        nbrepas = sc.nextDouble();
    
        System.out.println("Veuillez rentrer vos frais de hors forfait");
        nbhorsf = sc.nextDouble();
        }
    
        catch (NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "valeur numérique");
        }
    
        System.out.println("Voici les fraies saisie actuellement");
        System.out.println("Vos frais kilomètrique sont : " + nbkilometre + "€");
        System.out.println("Vos frais de repas sont : " + nbrepas + "€");
        System.out.println("Vos frais de nuité sont : " + nbnuité + "€");
        System.out.println("Vos frais de hors fortait : " + nbhorsf + "€");
    
        }
    
        boolean validation = false;
        validation = true;
    
        if (validation){
            System.out.println("Votre validation est accepter ");
    
        }
        else {
    
            System.out.println("Vous n'avez pas remplie toutes les cases");
        }   
    
        System.out.println("Voulez vous entrer des nouveaux fraies de hors forfait true/false");
        boolean horsforfait = sc.nextBoolean(); 
    
        if (horsforfait){
        System.out.println("Veuillez rentrer vos frais");
        double nouveaufraie = sc.nextDouble();
        sc.nextLine();
        System.out.println("Veuillez justifier vos frais");
        String justifier = sc.nextLine();
    
        System.out.println("Voicie vos nouveau frais : " + nouveaufraie);
        System.out.println("Voicie votre justification : " + justifier);
    
      }  
}
}