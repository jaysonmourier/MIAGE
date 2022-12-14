import td2.universite.Matiere;
import td2.universite.Annee;
import td2.universite.UE;
import td2.universite.Etudiant;

import java.util.*;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        /** QUESTION 1 **/
        Somme<Integer> intSum = (a, b) -> a + b;
        Somme<Double> doubleSum = (a, b) -> a + b;
        Somme<Long> longSum = (a, b) -> a + b;
        Somme<String> stringSum = (a, b) -> a + " " + b;

        System.out.println(
                "Résultat:\n- intSum = " + intSum.apply(5, 5)
                + "\n- doubleSum = " + doubleSum.apply(15.68, 9.12)
                + "\n- longSum = " + longSum.apply(5456452L, 8754L)
                + "\n- stringSum = " + stringSum.apply("Hello", "World!")
        );
        /*****/

        /** QUESTION 2 **/
        // test
        ToString<Integer, String> intToString = (a) -> a.toString();
        ToString<List<String>, String> l2s = (l) -> {
            String root = "";
            for (String elt : l)
            {
                root += elt + " ";
            }
            return root;
        };
        ToString<Map<String, Integer>, String> m2s = (m) -> {
            String root = "";
            int counter = 0;
            for (Map.Entry<String, Integer> entry : m.entrySet())
            {
                if(counter++ > 0) root += ", ";
                root += entry.getKey() + ": " + entry.getValue().toString();
            }
            return root;
        };
        System.out.println("intToString = " + intToString.apply(50));
        List<String> strList = new ArrayList<>();
        strList.add("Hello");
        strList.add("World");
        strList.add("!");
        Map<String, Integer> m = new HashMap<>();
        m.put("Clément", 10);
        m.put("Jayson", 50);
        m.put("Test", 41);
        System.out.println("l2s => " + l2s.apply(strList));
        System.out.println("m2s => " + m2s.apply(m));
        /*****/

        /** QUESTION 3 **/

        // Function: Convertie (map) un type vers un autre. Lambda avec une variable
        //           Argument: Oui (type: T)
        //           Retour: Oui (type: R)

        // Predicate: Tests l’argument selon un critère et renvoie vrai ou faux. Stockage Lambda expression
        //           Argument: Oui (type: T)
        //           Retour: Oui (type: boolean)

        // Consume: Consume une entrée et ne retourne rien
        //           Argument: Oui (type: T)
        //           Retour: Non

        // Supplier: Générer une sortie
        //           Argument: Non
        //           Retour: Oui (type: T)

        /*****/

        /** EXERCICE 2 **/
        /** Q1 **/
        Predicate<Integer> tailleTropPetite = (x) -> x < 100;
        Predicate<Integer> tailleTropGrande = (x) -> x > 200;
        Predicate<Integer> tailleIncorrect = (x) -> tailleTropPetite.test(x) || tailleTropGrande.test(x);
        Predicate<Integer> tailleCorrect = (x) -> !tailleIncorrect.test(x);
        Predicate<Double> poidTropLourd = (x) -> x > 150.0;
        Predicate<Double> poidCorrect = (x) -> !poidTropLourd.test(x);
        Predicate<Paire<Integer, Double>> accessAutorise = (x) -> tailleCorrect.test(x.fst) && poidCorrect.test(x.snd);

        Predicate<Paire<Integer, Double>> tailleTP = x -> x.fst < 100;
        Predicate<Paire<Integer, Double>> tailleTG = x -> x.fst > 200;
        Predicate<Paire<Integer, Double>> tailleIC = x -> tailleTP.test(x) || tailleTG.test(x);
        Predicate<Paire<Integer, Double>> tailleC = x -> !tailleIC.test(x);
        Predicate<Paire<Integer, Double>> poidTL = x -> x.snd > 150.0;
        Predicate<Paire<Integer, Double>> poidC = x -> !poidTL.test(x);

        Paire<Integer, Double> test1 = new Paire(180, 75.0);
        Paire<Integer, Double> test2 = new Paire(180, 365.0);

        System.out.println("test1 = " + accessAutorise.test(test1));
        System.out.println("test2 = " + accessAutorise.test(test2));
        /*****/

        /** Q2 **/
        List<Predicate<Paire<Integer, Double>>> predicats = new ArrayList<>();
        List<Paire<Integer, Double>> paires = new ArrayList<>();
        paires.add(new Paire<Integer, Double>(180, 45.0));
        paires.add(new Paire<Integer, Double>(160, 55.0));
        paires.add(new Paire<Integer, Double>(200, 456.0));
        paires.add(new Paire<Integer, Double>(145, 40.0));

        predicats.add(tailleC);
        predicats.add(poidC);

        Predicate fpredicate = Main.aggregatePredicate(predicats);
        System.out.printf("final test = " + fpredicate.test(new Paire<Integer, Double>(180, 452.0)));
        /*****/
        /*****/

        Main.exercice3();
    }

    public static <T> Predicate<T> aggregatePredicate(List<Predicate<T>> predicates)
    {
        if(predicates.size() < 1) return null;
        else if(predicates.size() < 2) return predicates.get(0);

        Iterator<Predicate<T>> iterator = predicates.iterator();
        Predicate f = iterator.next();
        while(iterator.hasNext())
        {
            f = f.and(iterator.next());
        }

        return f;
    }

    public static void exercice3()
    {
        Matiere m1 = new Matiere("MAT1");
        Matiere m2 = new Matiere("MAT2");
        UE ue1 = new UE("UE1", Map.of(m1, 2, m2, 2));
        Matiere m3 = new Matiere("MAT3");
        UE ue2 = new UE("UE2", Map.of(m3, 1));
        Annee a1 = new Annee(Set.of(ue1, ue2));
        Etudiant e1 = new Etudiant("39001", "Alice", "Merveille", a1); e1.noter(m1, 12.0);
        e1.noter(m2, 14.0);
        e1.noter(m3, 10.0);
        System.out.println(e1);
        Etudiant e2 = new Etudiant("39002", "Bob", "Eponge", a1); e2.noter(m1, 14.0);
        e2.noter(m3, 14.0);
        Etudiant e3 = new Etudiant("39003", "Charles", "Chaplin", a1); e3.noter(m1, 18.0);
        e3.noter(m2, 5.0);
        e3.noter(m3, 14.0);

        Predicate<Etudiant> aDEF = x -> x.notes().size() < 3;
        Predicate<Etudiant> noteEliminatoire = x -> {
            for(Map.Entry<Matiere, Double> entry : x.notes().entrySet())
            {
                if(entry.getValue() < 6.0) return true;
            }
            return false;
        };

        Predicate<Etudiant> pasLaMoyenneV1 = x -> moyenne(x, aDEF) < 10;

        Predicate<Etudiant> pasLaMoyenneV2 = x -> {
            Double m = moyenne(x, aDEF);
            if(m == null) return true;
            else return m < 10;
        };


        Main.afficheSi("**Les défaillants\n", aDEF, a1);
        Main.afficheSi("**ETUDIANTS AVEC NOTE ELIMINATOIRE\n", noteEliminatoire, a1);
        Main.afficheSi("**ETUDIANTS PAS LA MOYENNE\n", pasLaMoyenneV2, a1);
    }

    public static void afficheSi(final String entete, Predicate<Etudiant> predicate, Annee annee)
    {
        Etudiant tmp;
        List<Etudiant> etudiants = new ArrayList<>();
        etudiants.addAll((Collection) annee.etudiants());
        System.out.println(entete);
        for(int i = 0; i < etudiants.size(); ++i)
        {
            tmp = etudiants.get(i);
            if(predicate.test(tmp))
            {
                System.out.println(tmp);
            }
        }
    }

    public static Double moyenne(Etudiant etudiant, Predicate predicate)
    {
        if(predicate.test(etudiant)) return null;
        Double s=0.0;
        Integer c=0;
        for (UE ue : etudiant.annee().ues()) {
            for (Map.Entry<Matiere, Integer> ects : ue.ects().entrySet()) {
                Matiere matiere = ects.getKey();
                Integer credits = ects.getValue();
                s += etudiant.notes().get(matiere) * credits;
                c += credits;
            }
        }
        return s/c;
    }

}