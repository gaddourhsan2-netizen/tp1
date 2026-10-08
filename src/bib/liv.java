package bib;

public class liv extends doc implements emprutable{
    private boolean emprunte = false;

    public liv(String titre, String descreption) {

        super(titre, descreption);
    }

    @Override
    public String descriptionCourte() {
        return "Livre #" + getId() + " : " + getTitre();
    }

    @Override
    public void emprunter() {
        if (emprunte) {
            throw new IllegalStateException(
                    "Le livre est déjà emprunté."
            );
        }

        emprunte = true;

    }

    @Override
    public void retourner() {
        emprunte =false;
    }

    @Override
    public boolean estEmprunte() {
        return emprunte;
    }

}
