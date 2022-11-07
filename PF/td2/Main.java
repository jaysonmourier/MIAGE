import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

        Paire<Integer, Double> test1 = new Paire(180, 75.0);
        Paire<Integer, Double> test2 = new Paire(180, 365.0);

        System.out.println("test1 = " + accessAutorise.test(test1));
        System.out.println("test2 = " + accessAutorise.test(test2));
        /*****/
        /*****/
    }
}