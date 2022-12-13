package org.universite;

import org.paires.Paire;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class main {
    public static final Function<Annee, Stream<Matiere>> matieresA = a -> {
        return a.ues().stream().flatMap(ue -> ue.ects().keySet().stream());
    };

    public static final Function<Etudiant, Stream<Matiere>> matieresE = etudiant -> {
        return etudiant.annee().ues().stream().flatMap(ue -> ue.ects().keySet().stream());
    };

    public static final Function<Etudiant, Stream<Map.Entry<Matiere, Integer>>> matieresCoefE_ = etudiant -> {
      return etudiant.annee().ues().stream().flatMap(ue -> ue.ects().entrySet().stream());
    };

    public static final Function<Map.Entry<Matiere, Integer>, Paire<Matiere, Integer>> entry2paire = e -> {
        return new Paire<>(e.getKey(), e.getValue());
    };

    public static final Function<Etudiant, Stream<Paire<Matiere, Integer>>> matieresCoefE = e -> {
      return e.annee().ues().stream().flatMap(ue -> ue.ects().entrySet().stream().map(elt -> new Paire<>(elt.getKey(), elt.getValue())));
    };

    public static final BinaryOperator<Paire<Double, Integer>> accumulateurMoyenne = (a, b) -> { return new Paire<>(a.fst()+b.fst()*b.snd(), a.snd()+b.snd()); };

    public static final Paire<Double, Integer> zero = new Paire<>(0.0, 0);

    public static final Function<Etudiant, List<Paire<Double, Integer>>> notesPonderees = e -> {
        return matieresE.apply(e).map(matiere -> new Paire(matiere.nom(), e.notes().get(matiere.nom()))).collect(Collectors.toList());
    };

    public static final Function<Etudiant, List<Paire<Double, Integer>>> notesPondereesIndicatives = e -> {
        return matieresE.apply(e).map(matiere -> new Paire(matiere.nom(), e.notes().get(matiere.nom()))).collect(Collectors.toList());
    };

    public static final Function<List<Paire<Double, Integer>>, Paire<Double, Integer>> reduit = l -> {
      return l.stream().reduce(new Paire<Double, Integer>(0.0, 0), (a, b) -> new Paire<>(a.fst() + b.fst(), a.snd() + b.snd()));
    };

    public static final Function<Paire<Double, Integer>, Double> divise = p -> {
        return p.fst() / p.snd();
    };

    public static final Function<Etudiant, Double> moyenne = e -> (e == null || aDef.test(e)) ? null : computeMoyenne.apply(e);

    public static final Function<Etudiant, Double> computeMoyenneIndicative =  e -> {
        return null;
    };


    public static void main(String args[]) {
        System.out.println("hello world");
    }
}
