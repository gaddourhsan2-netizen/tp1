package bib;


public class rev extends doc{

    public rev(String titre, String description) {
        super(titre, description);
    }

    @Override
    public String descriptionCourte() {
        return "Revue #" + getId() + " : " + getTitre();
    }

}