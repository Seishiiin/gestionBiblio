package fr.seishin.libs;

import fr.seishin.books.*;
import fr.seishin.librairies.Library;
import fr.seishin.members.*;
import fr.seishin.rentals.*;

import static fr.seishin.libs.Utils.getMaxLengthBookAndMembresAndRentals;

import java.util.ArrayList;
import java.util.Scanner;

import static fr.seishin.libs.TerminalColor.*;

public class Display {
    public static void displayMainMenu(Library library) {
        int[] maxlength = getMaxLengthBookAndMembresAndRentals(library.getBooks(), library.getMembers(), library.getRentals());

        System.out.println("|---------- " + colorize(library.getName().toUpperCase(), ORANGE) + " -----------");
        System.out.println(colorize("| 1. Gestion des livres", CYAN));
        System.out.println(colorize("| 2. Gestion des membres", BLUE));
        System.out.println(colorize("| 3. Gestion des emprunts", PURPLE));
        System.out.println(colorize("| 4. Gestion de la bibliothèque", YELLOW));
        System.out.println(colorize("| 5. Statistiques", GREEN));
        System.out.println("|");
        System.out.println(colorize("| 9. Quitter", RED));
        System.out.println("|");
        System.out.print("| Faites votre choix : ");

        try {
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            System.out.println("|" + "-".repeat(22 + library.getName().length()) + "|\n");

            Utils.manageChoiceMainMenu(maxlength, library, choice);
        } catch (Exception e) {
            System.out.println("|" + "-".repeat(22 + library.getName().length()) + "|\n");

            System.out.println(colorize("-> Erreur : Veuillez saisir un nombre valide.\n", RED));
            displayMainMenu(library);
        }
    }

    public static void displayMenuBooks(int[] maxlength, Library library) {
        System.out.println("|---------- " + colorize("Gestion des livres".toUpperCase(), CYAN) + " -----------");
        System.out.println(colorize("| 1. Afficher les livres", CYAN));
        System.out.println(colorize("| 2. Ajouter un livre", CYAN));
        System.out.println(colorize("| 3. Modifier un livre", CYAN));
        System.out.println(colorize("| 4. Supprimer un livre", CYAN));
        System.out.println(colorize("| 5. Rechercher un livre", CYAN));
        System.out.println(colorize("| 6. Historique des livres", CYAN));
        System.out.println("|");
        System.out.println(colorize("| 9. Retour", RED));
        System.out.println("|");
        System.out.print("| Faites votre choix : ");

        try {
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            System.out.println("|" + "-".repeat(22 + "Gestion des livres".length()) + "|\n");

            Utils.manageChoiceMenuBooks(maxlength, library, choice);
        } catch (Exception e) {
            System.out.println("|" + "-".repeat(22 + "Gestion des livres".length()) + "|\n");

            System.out.println(colorize("-> Erreur : Veuillez saisir un nombre valide.\n", RED));
            displayMenuBooks(maxlength, library);
        }
    }
    public static void displayMenuMembers(int[] maxlength, Library library) {
        System.out.println("|---------- " + colorize("Gestion des membres".toUpperCase(), BLUE) + " -----------");
        System.out.println(colorize("| 1. Afficher les membres", BLUE));
        System.out.println(colorize("| 2. Ajouter un membre", BLUE));
        System.out.println(colorize("| 3. Modifier un membre", BLUE));
        System.out.println(colorize("| 4. Supprimer un membre", BLUE));
        System.out.println(colorize("| 5. Rechercher un membre", BLUE));
        System.out.println(colorize("| 6. Historique des membres", BLUE));
        System.out.println("|");
        System.out.println(colorize("| 9. Retour", RED));
        System.out.println("|");
        System.out.print("| Faites votre choix : ");

        try {
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            System.out.println("|" + "-".repeat(22 + "Gestion des membres".length()) + "|\n");

            Utils.manageChoiceMenuMembers(maxlength, library, choice);
        } catch (Exception e) {
            System.out.println("|" + "-".repeat(22 + "Gestion des membres".length()) + "|\n");

            System.out.println(colorize("-> Erreur : Veuillez saisir un nombre valide.\n", RED));
            displayMenuMembers(maxlength, library);
        }
    }
    public static void displayMenuRentals(int[] maxlength, Library library) {
        System.out.println("|---------- " + colorize("Gestion des emprunts".toUpperCase(), PURPLE) + " -----------");
        System.out.println(colorize("| 1. Afficher les emprunts", PURPLE));
        System.out.println(colorize("| 2. Ajouter un emprunt", PURPLE));
        System.out.println(colorize("| 3. Impossible de modifier un emprunt", GRAY));
        System.out.println(colorize("| 4. Supprimer un emprunt", PURPLE));
        System.out.println(colorize("| 5. Rechercher un emprunt", PURPLE));
        System.out.println(colorize("| 6. Historique des emprunts", PURPLE));
        System.out.println("|");
        System.out.println(colorize("| 9. Retour", RED));
        System.out.println("|");
        System.out.print("| Faites votre choix : ");

        try {
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            System.out.println("|" + "-".repeat(22 + "Gestion des emprunts".length()) + "|\n");

            Utils.manageChoiceMenuRentals(maxlength, library, choice);
        } catch (Exception e) {
            System.out.println("|" + "-".repeat(22 + "Gestion des emprunts".length()) + "|\n");

            System.out.println(colorize("-> Erreur : Veuillez saisir un nombre valide.\n", RED));
            displayMenuRentals(maxlength, library);
        }
    }
    public static void displayMenuLibrary(Library library) {
        System.out.println("|---------- " + colorize("Gestion de la bibliothèque".toUpperCase(), YELLOW) + " -----------");
        System.out.println(colorize("| 1. Modifier le nom de la bibliothèque", YELLOW));
        System.out.println("|");
        System.out.println(colorize("| 9. Retour", RED));
        System.out.println("|");
        System.out.print("| Faites votre choix : ");

        try {
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            System.out.println("|" + "-".repeat(22 + "Gestion de la bibliothèque".length()) + "|\n");

            Utils.manageChoiceMenuLibrary(library, choice);
        } catch (Exception e) {
            System.out.println("|" + "-".repeat(22 + "Gestion de la bibliothèque".length()) + "|\n");

            System.out.println(colorize("-> Erreur : Veuillez saisir un nombre valide.\n", RED));
            displayMenuLibrary(library);
        }
    }
    public static void displayMenuStats(Library library) {
        System.out.println("|---------- " + colorize("Statistiques".toUpperCase(), GREEN) + " -----------");
        System.out.println(colorize("| 1. Statistiques de la bibliothèque", GREEN));
        System.out.println(colorize("| 2. Statistiques des livres", GREEN));
        System.out.println(colorize("| 3. Statistiques des membres", GREEN));
        System.out.println(colorize("| 4. Statistiques des emprunts", GREEN));
        System.out.println("|");
        System.out.println(colorize("| 9. Retour", RED));
        System.out.println("|");
        System.out.print("| Faites votre choix : ");

        try {
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            System.out.println("|" + "-".repeat(22 + "Statistiques".length()) + "|\n");

            Utils.manageChoiceMenuStats(library, choice);
        } catch (Exception e) {
            System.out.println("|" + "-".repeat(22 + "Statistiques".length()) + "|\n");

            System.out.println(colorize("-> Erreur : Veuillez saisir un nombre valide.\n", RED));
            displayMenuStats(library);
        }
    }

    public static void displayBooks(int[] maxlength, ArrayList<Book> books) {
        System.out.println(" ".repeat(maxlength[0]) + " | " + "Titre" + " ".repeat(maxlength[1] - "Titre".length()) + " | Auteur" + " ".repeat(maxlength[2] - "Auteur".length()) + " | Disponibilité" + " ".repeat(maxlength[3] - "Dispobilité".length()));
        System.out.println(" ".repeat(maxlength[0] + 1) + "|" + "-".repeat(maxlength[1] + 2) + "|" + "-".repeat(maxlength[2] + 2) + "|" + "-".repeat(20));

        for (Book book : books) {
            String message = colorize(String.valueOf(book.getIsbn()), CYAN) + " ".repeat(maxlength[0] - String.valueOf(book.getIsbn()).length()) + " | " +
                    colorize(book.getTitle(), PURPLE) + " ".repeat(maxlength[1] - book.getTitle().length()) + " | " +
                    colorize(book.getAuthor(), YELLOW) + " ".repeat(maxlength[2] - book.getAuthor().length()) + " | " +
                    Utils.getBookAvailabilityColor(book);

            System.out.println(message);
        }
    }

    public static void displayBook(Book book) {
        System.out.println("Titre : " + colorize(book.getTitle(), PURPLE));
        System.out.println("Auteur : " + colorize(book.getAuthor(), YELLOW));
        System.out.println("Année de parution : " + colorize(String.valueOf(book.getYear()), CYAN));
        System.out.println("ISBN : " + colorize(String.valueOf(book.getIsbn()), CYAN));
        System.out.println("Disponibilité : " + Utils.getBookAvailabilityColor(book));
    }

    public static void displayMembers(int[] maxlength, ArrayList<Member> members) {
        System.out.println(" ".repeat(maxlength[0]) + " | " + " NOM Prénom" + " ".repeat(maxlength[1] - " NOM Prénom".length()) + " | Email" + " ".repeat(maxlength[2] - "Email".length()) + " | Type" + " ".repeat(maxlength[3] - "Type".length()));
        System.out.println(" ".repeat(maxlength[0] + 1) + "|" + "-".repeat(maxlength[1] + 2) + "|" + "-".repeat(maxlength[2] + 2) + "|" + "-".repeat(20));

        for (Member member : members) {
            String message = colorize(String.valueOf(member.getId()), CYAN) + " ".repeat(maxlength[0] - String.valueOf(member.getId()).length()) + " | " +
                    colorize(member.getName() + " " + member.getFirstName(), PURPLE) + " ".repeat(maxlength[1] - (member.getName().length() + 1 + member.getFirstName().length())) + " | " +
                    colorize(member.getEmail(), YELLOW) + " ".repeat(maxlength[2] - member.getEmail().length()) + " | " +
                    Utils.getMemberTypeColor(member);

            System.out.println(message);
        }
    }

    public static void displayMember(Member member) {
        System.out.println("Nom : " + colorize(member.getName(), PURPLE));
        System.out.println("Prénom : " + colorize(member.getFirstName(), YELLOW));
        System.out.println("Email : " + colorize(member.getEmail(), CYAN));
        System.out.println("Téléphone : " + colorize(member.getPhone(), CYAN));
        System.out.println("Adresse : " + colorize(member.getAddress(), CYAN));
        System.out.println("Type : " + Utils.getMemberTypeColor(member));
    }

    public static void displayRentals(int[] maxlength, ArrayList<Rental> rentals) {
        System.out.println(" ".repeat(maxlength[0]) + " | " + "Titre" + " ".repeat(maxlength[1] - "Titre".length()) + " | Emprunteur" + " ".repeat(maxlength[2] - "Emprunteur".length()) + " | Date de retour" + " ".repeat(maxlength[3] - "Date de retour".length()));
        System.out.println(" ".repeat(maxlength[0] + 1) + "|" + "-".repeat(maxlength[1] + 2) + "|" + "-".repeat(maxlength[2] + 2) + "|" + "-".repeat(20));

        for (Rental rental : rentals) {
            String message = colorize(String.valueOf(rental.getId()), CYAN) + " ".repeat(maxlength[0] - String.valueOf(rental.getId()).length()) + " | " +
                    colorize(rental.getBook().getTitle(), PURPLE) + " ".repeat(maxlength[1] - rental.getBook().getTitle().length()) + " | " +
                    colorize(rental.getMember().getName() + " " + rental.getMember().getFirstName(), YELLOW) + " ".repeat(maxlength[2] - (rental.getMember().getName().length() + 1 + rental.getMember().getFirstName().length())) + " | " +
                    Utils.getDateLateColor(rental);

            System.out.println(message);
        }
    }

    public static void displayRental(Rental rental) {
        System.out.println("Titre : " + colorize(rental.getBook().getTitle(), PURPLE));
        System.out.println("Emprunteur : " + colorize(rental.getMember().getName() + " " + rental.getMember().getFirstName(), YELLOW));
        System.out.println("Date de retour : " + Utils.getDateLateColor(rental));
    }

    public static void displayStatsLibrary(Library library) {
        System.out.println("Statistiques de la bibliothèque " + colorize(library.getName(), PURPLE));
        System.out.println("Nombre de livres : " + colorize(String.valueOf(library.getBooks().size()), CYAN));
        System.out.println("Nombre de membres : " + colorize(String.valueOf(library.getMembers().size()), CYAN));
        System.out.println("Nombre d'emprunts : " + colorize(String.valueOf(library.getRentals().size()), CYAN));
    }

    public static void displayStatsBooks(Library library) {
        System.out.println("Statistiques des livres de la bibliothèque " + colorize(library.getName(), PURPLE));
        System.out.println("Nombre de livres : " + colorize(String.valueOf(library.getBooks().size()), CYAN));
        System.out.println("Nombre de livres empruntés : " + colorize(String.valueOf(library.getBooks().size() - library.getAvailableBooks().size()), CYAN));
        System.out.println("Nombre de livres disponibles : " + colorize(String.valueOf(library.getAvailableBooks().size()), CYAN));

    }

    public static void displayStatsMembers(Library library) {
        System.out.println("Statistiques des membres de la bibliothèque " + colorize(library.getName(), PURPLE));
        System.out.println("Nombre de membres : " + colorize(String.valueOf(library.getMembers().size()), CYAN));
        System.out.println("Nombre de membres réguliers : " + colorize(String.valueOf(library.getRegularMembers().size()), CYAN));
        System.out.println("Nombre de membres occasionnels : " + colorize(String.valueOf(library.getOccasionalMembers().size()), CYAN));
        System.out.println("Nombre de visiteurs : " + colorize(String.valueOf(library.getVisitorMembers().size()), CYAN));
    }

    public static void displayStatsRentals(Library library) {
        System.out.println("Statistiques des emprunts de la bibliothèque " + colorize(library.getName(), PURPLE));
        System.out.println("Nombre d'emprunts : " + colorize(String.valueOf(library.getRentals().size()), CYAN));
        System.out.println("Nombre d'emprunts en cours : " + colorize(String.valueOf(library.getRentals().size() - library.getHistoryRental().size()), CYAN));
        System.out.println("Nombre d'emprunts terminés : " + colorize(String.valueOf(library.getHistoryRental().size()), CYAN));
    }
}
