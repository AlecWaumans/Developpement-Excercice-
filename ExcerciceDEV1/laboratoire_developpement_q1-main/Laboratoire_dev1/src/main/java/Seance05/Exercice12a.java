/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seance05;

import java.util.Scanner;

/**
 *
 * @author alecw
 */
public class Exercice12a {

    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Entrez un mot : ");
        String mot = clavier.nextLine();
        int i = 0;
        int voyelle = 0;
        int consomne = 0;

        while (i < mot.length()) {
            if (mot.charAt(i) == 'a' || mot.charAt(i) == 'e' || mot.charAt(i) == 'i' || mot.charAt(i) == 'o' || mot.charAt(i) == 'u' || mot.charAt(i) == 'y') {
                voyelle = voyelle + 1;
            } else {
                consomne = consomne + 1;
            }
            i++;
        }
        System.out.println("Dans le mot il y a " + voyelle + "voyelle(s) et " + consomne + "Consomne(s)");
    }
}

