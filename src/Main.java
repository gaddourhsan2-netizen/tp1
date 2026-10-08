import bib.cat;
import bib.dvd;
import bib.liv;
import bib.rev;


void main() {
    // ==========================================
    // TEST 1 : Création des documents + ID
    // ==========================================

    System.out.println("========== TEST 1 : DOCUMENTS ==========");

    liv livre1 = new liv(
            "Java pour débutants",
            "Introduction à la programmation Java"
    );

    liv livre2 = new liv(
            "Programmation Java avancée",
            "Java niveau avancé"
    );

    dvd dvd1 = new dvd(
            "Inception",
            "Film de science-fiction"
    );

    dvd dvd2 = new dvd(
            "The Matrix",
            "Film de science-fiction"
    );

    rev revue1 = new rev(
            "Science & Vie",
            "Magazine scientifique"
    );

    rev revue2 = new rev(
            "National Geographic",
            "Magazine sur la nature"
    );

    System.out.println(livre1.descriptionCourte());
    System.out.println(livre2.descriptionCourte());
    System.out.println(dvd1.descriptionCourte());
    System.out.println(dvd2.descriptionCourte());
    System.out.println(revue1.descriptionCourte());
    System.out.println(revue2.descriptionCourte());


    // ==========================================
    // TEST 2 : Vérification des ID
    // ==========================================

    System.out.println("\n========== TEST 2 : ID ==========");

    System.out.println("ID Livre 1 : " + livre1.getId());
    System.out.println("ID Livre 2 : " + livre2.getId());
    System.out.println("ID DVD 1   : " + dvd1.getId());
    System.out.println("ID DVD 2   : " + dvd2.getId());
    System.out.println("ID Revue 1 : " + revue1.getId());
    System.out.println("ID Revue 2 : " + revue2.getId());


    // ==========================================
    // TEST 3 : Emprunt nominal
    // ==========================================

    System.out.println("\n========== TEST 3 : EMPRUNT NOMINAL ==========");

    System.out.println(
            "Avant emprunt : " + livre1.estEmprunte()
    );

    livre1.emprunter();

    System.out.println(
            "Après emprunt : " + livre1.estEmprunte()
    );


    // ==========================================
    // TEST 4 : Double emprunt
    // ==========================================

    System.out.println("\n========== TEST 4 : DOUBLE EMPRUNT ==========");

    try {

        livre1.emprunter();

        System.out.println(
                "ERREUR : le double emprunt est accepté !"
        );

    } catch (IllegalStateException e) {

        System.out.println(
                "SUCCÈS : exception détectée."
        );

        System.out.println(
                "Message : " + e.getMessage()
        );
    }


    // ==========================================
    // TEST 5 : Retour du livre
    // ==========================================

    System.out.println("\n========== TEST 5 : RETOUR ==========");

    System.out.println(
            "Avant retour : " + livre1.estEmprunte()
    );

    livre1.retourner();

    System.out.println(
            "Après retour : " + livre1.estEmprunte()
    );


    // ==========================================
    // TEST 6 : Réemprunt après retour
    // ==========================================

    System.out.println(
            "\n========== TEST 6 : RÉEMPRUNT =========="
    );

    try {

        livre1.emprunter();

        System.out.println(
                "SUCCÈS : le livre peut être réemprunté."
        );

        System.out.println(
                "État : " + livre1.estEmprunte()
        );

    } catch (IllegalStateException e) {

        System.out.println(
                "ERREUR : impossible de réemprunter le livre."
        );
    }


    // ==========================================
    // TEST 7 : Emprunt DVD
    // ==========================================

    System.out.println("\n========== TEST 7 : EMPRUNT DVD ==========");

    dvd1.emprunter();

    System.out.println(
            dvd1.descriptionCourte()
    );

    System.out.println(
            "DVD emprunté : " + dvd1.estEmprunte()
    );


    // ==========================================
    // TEST 8 : Double emprunt DVD
    // ==========================================

    System.out.println(
            "\n========== TEST 8 : DOUBLE EMPRUNT DVD =========="
    );

    try {

        dvd1.emprunter();

        System.out.println(
                "ERREUR : double emprunt accepté !"
        );

    } catch (IllegalStateException e) {

        System.out.println(
                "SUCCÈS : IllegalStateException détectée."
        );
    }


    // ==========================================
    // TEST 9 : Catalogue de livres
    // ==========================================

    System.out.println(
            "\n========== TEST 9 : CATALOGUE LIVRES =========="
    );

    cat<liv> catalogueLivres = new cat<>();

    catalogueLivres.ajouter(livre1);
    catalogueLivres.ajouter(livre2);

    catalogueLivres.afficherTout();


    // ==========================================
    // TEST 10 : Catalogue DVD
    // ==========================================

    System.out.println(
            "\n========== TEST 10 : CATALOGUE DVD =========="
    );

    cat<dvd> catalogueDvd = new cat<>();

    catalogueDvd.ajouter(dvd1);
    catalogueDvd.ajouter(dvd2);

    catalogueDvd.afficherTout();


    // ==========================================
    // TEST 11 : Catalogue revues
    // ==========================================

    System.out.println(
            "\n========== TEST 11 : CATALOGUE REVUES =========="
    );

    cat<rev> catalogueRevues = new cat<>();

    catalogueRevues.ajouter(revue1);
    catalogueRevues.ajouter(revue2);

    catalogueRevues.afficherTout();


    // ==========================================
    // TEST 12 : Recherche réussie
    // ==========================================

    System.out.println(
            "\n========== TEST 12 : RECHERCHE =========="
    );

    catalogueLivres
            .rechercherParTitre("Java pour débutants")
            .ifPresentOrElse(

                    document -> System.out.println(
                            "Document trouvé : "
                                    + document.descriptionCourte()
                    ),

                    () -> System.out.println(
                            "Document introuvable."
                    )
            );


    // ==========================================
    // TEST 13 : Recherche infructueuse
    // ==========================================

    System.out.println(
            "\n========== TEST 13 : RECHERCHE INFRUCTUEUSE =========="
    );

    catalogueLivres
            .rechercherParTitre("Python")
            .ifPresentOrElse(

                    document -> System.out.println(
                            "Document trouvé : "
                                    + document.descriptionCourte()
                    ),

                    () -> System.out.println(
                            "SUCCÈS : Document introuvable."
                    )
            );


    // ==========================================
    // TEST 14 : Vérification Revue
    // ==========================================

    System.out.println(
            "\n========== TEST 14 : REVUE =========="
    );

    System.out.println(
            revue1.descriptionCourte()
    );

    System.out.println(
            "Une revue est consultée sur place."
    );


    // ==========================================
    // FIN
    // ==========================================

    System.out.println("\n========== TOUS LES TESTS TERMINÉS ==========");
}
