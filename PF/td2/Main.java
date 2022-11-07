import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        /*****/
    }
}