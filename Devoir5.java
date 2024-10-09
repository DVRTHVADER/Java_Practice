import java.util.ArrayList;
import java.util.List;

// Document class
class Devoir5 {
    private String numEnregistrement;
    private String titre;
    private int nbCopies;

    public Document(String numEnregistrement, String titre, int nbCopies) {
        this.numEnregistrement = numEnregistrement;
        this.titre = titre;
        this.nbCopies = nbCopies;
    }

    public void incrementCopies() {
        nbCopies++;
    }

    public void decrementCopies() {
        if (nbCopies > 0) {
            nbCopies--;
        }
    }
}

// Livre class
class Livre extends Document {
    private String auteur;
    private int nbPages;

    public Livre(String numEnregistrement, String titre, int nbCopies, String auteur, int nbPages) {
        super(numEnregistrement, titre, nbCopies);
        this.auteur = auteur;
        this.nbPages = nbPages;
    }
}

// Roman class
class Roman extends Livre {
    private List<String> prixLitteraires;

    public Roman(String numEnregistrement, String titre, int nbCopies, String auteur, int nbPages) {
        super(numEnregistrement, titre, nbCopies, auteur, nbPages);
        this.prixLitteraires = new ArrayList<>();
    }

    public void addPrixLitteraire(String prix) {
        prixLitteraires.add(prix);
    }
}

// Manuel class
class Manuel extends Livre {
    private String domaine;

    public Manuel(String numEnregistrement, String titre, int nbCopies, String auteur, int nbPages, String domaine) {
        super(numEnregistrement, titre, nbCopies, auteur, nbPages);
        this.domaine = domaine;
    }
}

// Revue class
class Revue extends Document {
    private int moisPublication;
    private int anneePublication;

    public Revue(String numEnregistrement, String titre, int nbCopies, int moisPublication, int anneePublication) {
        super(numEnregistrement, titre, nbCopies);
        this.moisPublication = moisPublication;
        this.anneePublication = anneePublication;
    }
}

// Dictionnaire class
class Dictionnaire extends Document {
    private String langue;

    public Dictionnaire(String numEnregistrement, String titre, int nbCopies, String langue) {
        super(numEnregistrement, titre, nbCopies);
        this.langue = langue;
    }
}

// Interface Descriptible
interface Descriptible {
    String getDescription();
}

// Implementation of Descriptible in each specific class
class RomanDescription implements Descriptible {
    @Override
    public String getDescription() {
        return "Ce document est de type roman, un roman est ...";
    }
}

class ManuelDescription implements Descriptible {
    @Override
    public String getDescription() {
        return "Ce document est de type manuel, un manuel est ...";
    }
}

class RevueDescription implements Descriptible {
    @Override
    public String getDescription() {
        return "Ce document est de type revue, une revue est ...";
    }
}

class DictionnaireDescription implements Descriptible {
    @Override
    public String getDescription() {
        return "Ce document est de type dictionnaire, un dictionnaire est ...";
    }
}

public class DocumentManagementSystem {
    public static void main(String[] args) {
        // Sample usage
        Roman roman = new Roman("1234567890", "Le Roman", 5, "Auteur Roman", 300);
        roman.addPrixLitteraire("Prix Goncourt");

        Manuel manuel = new Manuel("0987654321", "Le Manuel", 10, "Auteur Manuel", 200, "Informatique");

        Revue revue = new Revue("5678901234", "La Revue", 20, 3, 2023);

        Dictionnaire dictionnaire = new Dictionnaire("4567890123", "Le Dictionnaire", 15, "Français");

        // Output descriptions
        System.out.println(new RomanDescription().getDescription());
        System.out.println(new ManuelDescription().getDescription());
        System.out.println(new RevueDescription().getDescription());
        System.out.println(new DictionnaireDescription().getDescription());
    }
}