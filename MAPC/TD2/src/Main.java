/**
 * Jayson MOURIER - 41000228
 *
 * L’objet de cet exercice est de concevoir une application FileSystem permettant de créer une arborescence
 * de fichiers, contenus dans des répertoires.
 *
 * Dans cette application, il existe deux types de fichiers, les fichiers ordinaires et les répertoires.
 * - Un répertoire peut contenir des fichiers et d'autres répertoires.
 * - Chaque fichier possède un nom (non nécessairement unique)
 * - Chaque fichier a un propriétaire, un propriétaire a un nom unique.
 */

public class Main {
    public static void main(String[] args) {
        Owner jayson = new Owner("Jayson");
        Owner clement = new Owner("Clément");
        FileSystem rep1 = new Repertory("rep1", clement);
        FileSystem rep2 = new Repertory("rep2", jayson);
        FileSystem file1 = new File("fichier.txt", jayson);

        // Permissions
        System.out.println(rep1);
        System.out.println(rep2);
        System.out.println(file1);
    }
}