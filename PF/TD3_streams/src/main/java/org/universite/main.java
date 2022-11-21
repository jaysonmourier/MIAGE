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
        return null;
    };

    public static void main(String args[]) {
        System.out.println("hello world");
    }
}
