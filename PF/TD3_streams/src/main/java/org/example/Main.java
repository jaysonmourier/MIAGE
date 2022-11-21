package org.example;

import org.commandes.Categorie;
import org.commandes.Commande;
import org.commandes.Produit;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Produit p1 = new Produit("Jus d'orange", 5.99, Categorie.NORMAL);
        Produit p2 = new Produit("Chocolat", 9.99, Categorie.NORMAL);

        Commande commande = new Commande();
        commande.ajouter(p1, 2);

        Commande commande2 = new Commande();
        commande2.ajouter(p1, 10);
        commande2.ajouter(p1, 1);
        commande2.ajouter(p1, 1);
        commande2.ajouter(p1, 1);
        commande2.ajouter(p2, 1);

        //Map<Produit, List<Integer>> r = commande2.regrouper();

        //System.out.println(r);

        System.out.println(commande2.normaliser());

        //System.out.println(commande2);
    }
}