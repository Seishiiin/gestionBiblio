import java.util.Scanner;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Bibliotheque bibliotheque = new Bibliotheque();
        JeuEssai.chargerJeuEssai(bibliotheque);

        Scanner sc = new Scanner(System.in);
        int choix;

        do {
            afficherMenu();
            choix = Integer.parseInt(sc.nextLine());
            switch (choix) {
                case 1 -> ajouterLivre(bibliotheque, sc);
                case 2 -> ajouterAdherent(bibliotheque, sc);
                case 3 -> bibliotheque.getLivres();
                case 4 -> bibliotheque.getAdherents();
                case 5 -> bibliotheque.getEmprunts();
                case 6 -> ajouterEmprunt(bibliotheque, sc);
                case 8 -> System.exit(0);
                default -> System.out.println("Choix invalide");
            }
        } while (choix != 8);
    }

    private static void afficherMenu() {
        System.out.println("\n|---------- MENU ----------|");
        System.out.println("| 1. Ajouter un livre      |");
        System.out.println("| 2. Ajouter un adherent   |");
        System.out.println("| 3. Afficher livres       |");
        System.out.println("| 4. Afficher adherents    |");
        System.out.println("| 5. Afficher emprunts     |");
        System.out.println("| 6. Ajouter un emprunt    |");
        System.out.println("| 8. Quitter               |");
        System.out.println("|--------------------------|");
        System.out.print("| Votre choix : ");
    }

    private static void ajouterLivre(Bibliotheque b, Scanner sc) {
        System.out.print("Titre : ");
        String titre = sc.nextLine();
        System.out.print("Auteur : ");
        String auteur = sc.nextLine();
        System.out.print("ISBN : ");
        String isbn = sc.nextLine();
        System.out.print("Annee : ");
        int annee = Integer.parseInt(sc.nextLine());
        b.ajouterLivre(new Livres(titre, auteur, isbn, annee));
    }

    private static void ajouterAdherent(Bibliotheque b, Scanner sc) {
        System.out.print("Nom : ");
        String nom = sc.nextLine();
        System.out.print("Prenom : ");
        String prenom = sc.nextLine();
        System.out.print("Adresse : ");
        String adresse = sc.nextLine();
        b.ajouterAdherent(new Adherents(nom, prenom, adresse, "", ""));
    }

    private static void ajouterEmprunt(Bibliotheque b, Scanner sc) {
        System.out.print("ISBN du livre : ");
        String isbn = sc.nextLine();
        Livres livre = b.searchLivreByIsbn(isbn);

        if (livre == null || livre.isEmprunte()) {
            System.out.println("Livre indisponible ou introuvable.");
            return;
        }

        System.out.print("Nom de l'adherent : ");
        String nom = sc.nextLine();
        Adherents adherent = b.searchAdherentByNom(nom);

        if (adherent == null) {
            System.out.println("Adherent introuvable.");
            return;
        }

        livre.setEmprunte(true);
        b.ajouterEmprunt(new Emprunts(new Date().toString(), "", livre, adherent));
        System.out.println("Emprunt ajoute avec succes.");
    }
}