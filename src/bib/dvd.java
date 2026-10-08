package bib;

public class dvd extends doc implements emprutable{
    private Boolean emprunte = false;
    public dvd(String titre, String description) {

        super(titre, description);
    }

    @Override
    public String descriptionCourte() {
        return "DVD #" + getId() + " : " + getTitre();
    }

    @Override
    public void emprunter() {
        if (emprunte) {
            throw new IllegalStateException(
                    "Le DVD est déjà emprunté."
            );
        }

        emprunte = true;
    }

    @Override
    public void retourner() {
        emprunte= false;
    }

    @Override
    public boolean estEmprunte() {
        return emprunte;
    }


    public void setEmprunte(Boolean emprunte) {
        this.emprunte = emprunte;
    }
}

