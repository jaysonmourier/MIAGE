package org.commandes;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.paires.Paire;

public class Commande {
    private List<Paire<Produit, Integer>> lignes;
    private Function<Paire<Produit, Integer>, String> formatteur;

    public Commande() {
        this.lignes = new ArrayList<>();
        this.formatteur = x -> formatteurLigne(x);
    }

    public Commande ajouter(Produit p, int q) {
        lignes.add(new Paire<>(p, q));
        return this;
    }

    public List<Paire<Produit, Integer>> lignes() {
        return lignes;
    }

    @Override
    public String toString() {
        return lignes.stream().map(elt -> this.formatteur.apply(elt)).collect(Collectors.joining("\n"));
    }

    /**
     * cumule les lignes en fonction des produits
     */
    public Commande normaliser() {
        Map<Produit,Integer> lignesCumulees = new HashMap<>();
        for(Paire<Produit,Integer> ligne : lignes) {
            Produit p = ligne.fst();
            int qte = ligne.snd();
            if(lignesCumulees.containsKey(ligne.fst())) {
               lignesCumulees.put(p, lignesCumulees.get(p)+qte);
            }
            else {
                lignesCumulees.put(p, qte);
            }
        }
        Commande commandeNormalisee = new Commande();
        for(Produit p : lignesCumulees.keySet()) {
            commandeNormalisee.ajouter(p, lignesCumulees.get(p));
        }
        return commandeNormalisee;
    }

    public Commande normaliserRefactor() {
        Commande commandeNormalisee = new Commande();
        regrouper(lignes()).forEach((a, b) -> {
            commandeNormalisee.ajouter(a, b.stream().reduce(0, (subtotal, element) -> subtotal + element));
        });
        return commandeNormalisee;
    }

    public Double cout(Function<Paire<Produit,Integer>,Double> calculLigne) {
        return normaliser().lignes.stream()
                .map(l -> calculLigne.apply(l))
                .reduce(0.0, (x,y) -> x+y);       
    }

    public <T, U> Map<T, List<U>> regrouper(List<Paire<T, U>> lignes) {
        Map<T, List<U>> mapA = new HashMap();
        for (Paire<T, U> paire : lignes) {
            if(mapA.containsKey(paire.fst())) {
                mapA.get(paire.fst()).add(paire.snd());
            } else {
                mapA.put(paire.fst(), new ArrayList<>());
                mapA.get(paire.fst()).add(paire.snd());
            }
        }
        return mapA;
    }

    public String affiche(Function<Paire<Produit, Integer>, Double> calculLigne) {
        Commande c = this.normaliser();
        final String HLINE = "+------------+------------+-----+------------+--------+------------+\n";
        StringBuilder str = new StringBuilder();
        str.append("\n\nCommande\n");
        str.append(HLINE);
        str.append("+ nom        + prix       + qté + prix ht    + tva    + prix ttc   +\n");
        str.append(HLINE);
        for (Paire<Produit, Integer> ligne : c.lignes) {
            str.append(String.format("+ %10s + %10.2f + %3d + %10.2f + %5.2f%% + %10.2f +\n", ligne.fst(), // nom
                    ligne.fst().prix(), // prix unitaire
                    ligne.snd(), // qté
                    ligne.fst().prix() * ligne.snd(), // prix ht
                    ligne.fst().cat().tva() * 100, // tva
                    calculLigne.apply(ligne)));
        }
        str.append(HLINE);
        str.append(String.format("Total : %10.2f", c.cout(calculLigne)));
        return str.toString();
    }

    // question 2 : les streams
    public static String formatteurLigne(Paire<Produit, Integer> paire) {
        return "N: " + paire.snd() + ", Nom : " + paire.fst().nom() + ", prix : " + paire.fst().prix();
    }

    public Function<Paire<Produit, Integer>, String> getFormatteur() {
        return formatteur;
    }

    public void setFormatteur(Function<Paire<Produit, Integer>, String> formatteur) {
        this.formatteur = formatteur;
    }
}
