/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seance07;

import java.util.Scanner;

/**
 *
 * @author alecw
 */
public class Calendrier {

    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        System.out.println("introduisez le chiffre du mois : ");
        int mois = clavier.nextInt();

        System.out.println("Introduisez l'année sous forme AAAA : ");
        int année = clavier.nextInt();

        afficherTitre(mois, année);
        afficherEntête();
        int nbJours = nombreJours(mois, année);
        int décalage = numéroJour(1, mois, année);
        afficherMois(décalage, nbJours);

    }

    public static String nomMois(int mois) {
        String nom = null;
        switch (mois) {
            case 1:
                nom = "Janvier";
                break;
            case 2:
                nom = "Fevrier";
                break;
            case 3:
                nom = "Mars";
                break;
            case 4:
                nom = "Avril";
                break;
            case 5:
                nom = "Mai";
                break;
            case 6:
                nom = "Juin";
                break;
            case 7:
                nom = "Juillet";
                break;
            case 8:
                nom = "Aout";
                break;
            case 9:
                nom = "Septembre";
                break;
            case 10:
                nom = "Octobre";
                break;
            case 11:
                nom = "Novembre";
                break;
            case 12:
                nom = "Decembre";
                break;
            default:
        }
        return nom;
    }

    public static void afficherTitre(int mois, int année) {
        System.out.println("==========================");
        System.out.println("      " + nomMois(mois) + " " + année + "   ");
        System.out.println("==========================");
    }

    public static void afficherEntête() {
        System.out.println("Lu  Ma  Me  Je  Ve  Sa  Di");
    }

    public static void afficherMois(int décalage, int nombreJours) {
        for (int i = 0; i < décalage; i++) {
            System.out.print("    ");
        }
        for (int jour = 1; jour <= nombreJours; jour++) {
            if (jour < 10) {
                System.out.print("0" + jour + "  ");
            } else {
                System.out.print(jour + "  ");
            }
            if ((jour + décalage) % 7 == 0) {
                System.out.println("");
            }
        }
        System.out.println();
    }

    public static boolean estBissextile(int année) {
        return ((année % 4 == 0) && ((année % 100 != 0) || (année % 400 == 0)));
    }

    public static int nombreJours(int mois, int année) {
        int nbJours = 31;
        if (mois == 4 || mois == 6 || mois == 9 || mois == 11) {
            nbJours = 30;
        } else if (mois == 2) {
            if (estBissextile(année)) {
                nbJours = 29;
            } else {
                nbJours = 28;
            }
        }
        return nbJours;
    }

    public static int numéroJour(int jour, int mois, int année) {
        int annéeCorrigée = année;
        int m = mois;
        int q = jour;

        if (mois == 1 || mois == 2) {
            annéeCorrigée = année - 1;
            m = mois + 12;
        }

        int j = annéeCorrigée / 100;
        int k = annéeCorrigée % 100;

        return (q + ((m + 1) * 13) / 5 + k + k / 4 + j / 4 + 5 * j + 5) % 7;
    }

}
