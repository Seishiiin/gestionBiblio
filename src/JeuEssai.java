public class JeuEssai {
    public static void chargerJeuEssai(Bibliotheque bibliotheque) {
        bibliotheque.ajouterLivre(new Livres("Harry Potter à l'école des sorciers", "J.K. Rowling", "978-2070643028", 1997));
        bibliotheque.ajouterLivre(new Livres("Le Seigneur des anneaux", "J.R.R. Tolkien", "978-2266182690", 1954));
        bibliotheque.ajouterLivre(new Livres("1984", "George Orwell", "978-0451524935", 1949));
        bibliotheque.ajouterLivre(new Livres("Fahrenheit 451", "Ray Bradbury", "978-2070368227", 1953));
        bibliotheque.ajouterLivre(new Livres("Le Petit Prince", "Antoine de Saint-Exupéry", "978-0156012195", 1943));
        bibliotheque.ajouterLivre(new Livres("Les Misérables", "Victor Hugo", "978-2070406709", 1862));

        bibliotheque.ajouterAdherent(new Adherents("Martin", "Jean", "10 rue de Paris", "0601020304", "jean.martin@gmail.com"));
        bibliotheque.ajouterAdherent(new Adherents("Dupont", "Claire", "12 avenue des Champs", "0611223344", "claire.dupont@hotmail.com"));
        bibliotheque.ajouterAdherent(new Adherents("Durand", "Sophie", "5 impasse du Soleil", "0622334455", "sophie.durand@yahoo.com"));
        bibliotheque.ajouterAdherent(new Adherents("Bernard", "Luc", "34 boulevard Haussmann", "0633445566", "luc.bernard@orange.fr"));
        bibliotheque.ajouterAdherent(new Adherents("Lemoine", "Nathalie", "7 rue du Marché", "0644556677", "nathalie.lemoine@gmail.com"));
        bibliotheque.ajouterAdherent(new Adherents("Morel", "Thomas", "3 allée des Rosiers", "0655667788", "thomas.morel@laposte.net"));

        Livres livre1 = bibliotheque.searchLivreByIsbn("978-2070643028");
        Adherents adherent1 = bibliotheque.searchAdherentByNom("Martin");
        if (livre1 != null && adherent1 != null) {
            livre1.setEmprunte(true);
            bibliotheque.ajouterEmprunt(new Emprunts("2024-06-01", "", livre1, adherent1));
        }

        Livres livre2 = bibliotheque.searchLivreByIsbn("978-0451524935");
        Adherents adherent2 = bibliotheque.searchAdherentByNom("Dupont");
        if (livre2 != null && adherent2 != null) {
            livre2.setEmprunte(true);
            bibliotheque.ajouterEmprunt(new Emprunts("2024-06-03", "", livre2, adherent2));
        }

        System.out.println("Jeu d'essai chargé avec succès !");
    }
}