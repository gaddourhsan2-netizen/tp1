package bib;

public abstract class doc {
    private static int compteur = 0;
    private int id ;
    private String titre;
    private String descreption;

    public doc(String titre, String descreption) {
        this.id = ++compteur;
        this.titre = titre;
        this.descreption = descreption;
    }

    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescreption() {
        return descreption;
    }

    public abstract String descriptionCourte();
}
