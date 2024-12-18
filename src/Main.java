import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bibliotheque bibliotheque = new Bibliotheque("Bibliothèque de Saint-Sauveur de Peyre");
        bibliotheque.addData();

        do {
            afficherMenu(bibliotheque);
        } while (true);
    }

    public static void afficherMenu (Bibliotheque bibliotheque){
        int nb = bibliotheque.getNom().length();

        System.out.println("|--------------- " + bibliotheque.getNom() + " ---------------|");
        System.out.println("| 1. Afficher les livres de la bibliothèque");
        System.out.println("| 2. Afficher les adhérents de la bibliothèque");
        System.out.println("| 3. Afficher l'historique des emprunts");
        System.out.println("| 4. Afficher les emprunts d'un adhérent");
        System.out.println("| 5. Ajouter un livre");
        System.out.println("| 6. Ajouter un adhérent");
        System.out.println("| 7. Emprunter un livre");
        System.out.println("| 8. Rendre un livre");
        System.out.println("| 9. Quitter");
        System.out.print("| Veuillez saisir le numéro de l'option souhaitée : ");

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();

        System.out.println("|----------------" + "-".repeat(nb) + "----------------|");

        switch (option) {
            case 1 -> bibliotheque.afficherLivres();
            case 2 -> bibliotheque.afficherAdherents();
            case 3 -> bibliotheque.afficherHistoriqueEmprunts();
            case 4 -> {
                System.out.print("Veuillez saisir le numéro de l'adhérent : ");
                int numeroAdherent = scanner.nextInt();
                bibliotheque.afficherEmpruntsAdherent(numeroAdherent);
            }
            case 5 -> {
                System.out.print("Quel est le type du livre ? (1. Roman, 2. Revue) ? ");
                int typeLivre = scanner.nextInt();

                System.out.print("Quel est le titre du livre ? ");
                String titre = scanner.nextLine();
                System.out.print("Quel est l'auteur du livre ? ");
                String auteur = scanner.nextLine();
                System.out.print("Quelle est l'année de publication du livre ? ");
                int annee = scanner.nextInt();
                switch (typeLivre) {
                    case 1 -> {
                        System.out.print("Quel est le nombre de pages du livre ? ");
                        int nbPages = scanner.nextInt();
                        System.out.print("Quelle est la langue du livre ? ");
                        String langue = scanner.nextLine();
                        bibliotheque.ajouterLivre(new Roman(titre, auteur, annee, nbPages, langue));
                    }
                    case 2 -> {
                        System.out.print("Quel est le thème de la revue ? ");
                        String theme = scanner.nextLine();
                        bibliotheque.ajouterLivre(new Revue(titre, auteur, annee, theme));
                    }
                }
            }
            case 6 -> {
                System.out.print("Quel est le prénom de l'adhérent ? ");
                String prenom = scanner.nextLine();
                System.out.print("Quel est le nom de l'adhérent ? ");
                String nom = scanner.nextLine();
                System.out.print("Quelle est l'adresse de l'adhérent ? ");
                String adresse = scanner.nextLine();
                System.out.print("Quel est le numéro de téléphone de l'adhérent ? ");
                String telephone = scanner.nextLine();
                System.out.print("Quelle est l'année de naissance de l'adhérent ? ");
                int anneeNaissance = scanner.nextInt();
                bibliotheque.ajouterAdherent(new Adherents(prenom, nom, adresse, telephone, anneeNaissance));
            }
            case 7 -> {
                System.out.print("Veuillez saisir le numéro de l'adhérent :");
                int numeroAdherent = scanner.nextInt();
                System.out.print("Veuillez saisir le numéro du livre :");
                int numeroLivre = scanner.nextInt();
                bibliotheque.ajouterReservation(new Reservations(bibliotheque.getLivre(numeroLivre), bibliotheque.getAdherent(numeroAdherent), new Date()));
            }
            case 8 -> {
                System.out.print("Veuillez saisir le numéro de l'adhérent :");
                int numeroAdherent = scanner.nextInt();
                System.out.print("Veuillez saisir le numéro du livre :");
                int numeroLivre = scanner.nextInt();

                for (Reservations reservation : bibliotheque.getReservations()) {
                    if (reservation.getAdherent().getId() == numeroAdherent && reservation.getLivre().getIsbn() == numeroLivre) {
                        reservation.setEnCours(false);
                        bibliotheque.supprimerReservation(reservation);
                        break;
                    }
                }
            }
            case 9 -> System.exit(0);
            default -> System.out.println("Option invalide");
        }
    }
}