package fr.seishin.libs;

import fr.seishin.books.*;
import fr.seishin.librairies.Library;
import fr.seishin.members.*;
import fr.seishin.rentals.*;

import static fr.seishin.libs.Utils.getMaxLenghtBookAndMembresAndRentals;

import java.util.ArrayList;
import java.util.Scanner;

import static fr.seishin.libs.TerminalColor.*;

public class Display {
    public static void displayMenu(Library library) {
        int[] maxlenght = getMaxLenghtBookAndMembresAndRentals(library.getBooks(), library.getMembers(), library.getRentals());

        System.out.println("|--------------- " + (colorize(library.getName(), PURPLE)) + " ---------------|");
        System.out.println("| 10. " + colorize("Afficher", CYAN) + " les livres");
        System.out.println("| 11. " + colorize("Ajouter", CYAN) + " un livre");
        System.out.println("| 12. " + colorize("Modifier", CYAN) + " un livre");
        System.out.println("| 13. " + colorize("Supprimer", CYAN) + " un livre");
        System.out.println("| 14. " + colorize("Rechercher", CYAN) + " un livre");
        System.out.println("|");
        System.out.println("| 20. " + colorize("Afficher", BLUE) + " les membres");
        System.out.println("| 21. " + colorize("Ajouter", BLUE) + " un membre");
        System.out.println("| 22. " + colorize("Modifier", BLUE) + " un membre");
        System.out.println("| 23. " + colorize("Supprimer", BLUE) + " un membre");
        System.out.println("| 24. " + colorize("Rechercher", BLUE) + " un membre");
        System.out.println("|");
        System.out.println("| 30. " + colorize("Afficher", PURPLE) + " les emprunts");
        System.out.println("| 31. " + colorize("Ajouter", PURPLE) + " un emprunt");
        System.out.println("| 32. " + colorize("Aucun option", GRAY));
        System.out.println("| 33. " + colorize("Supprimer", PURPLE) + " un emprunt");
        System.out.println("| 34. " + colorize("Rechercher", PURPLE) + " un emprunt");
        System.out.println("|");
        System.out.println("| 90. " + colorize("Quitter", RED) + " le programme");
        System.out.println("|");
        System.out.print("| Faites votre choix : ");

        try {
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            System.out.println("|" + "-".repeat(32 + library.getName().length()) + "|\n");

            Utils.manageChoiceMenu(maxlenght, library, choice);
        } catch (Exception e) {
            System.out.println("|" + "-".repeat(32 + library.getName().length()) + "|\n");

            System.out.println(colorize("-> Erreur : Veuillez saisir un nombre valide.\n", RED));
            displayMenu(library);
        }
    }

    public static void displayBooks(int[] maxlenght, ArrayList<Book> books) {
        System.out.println(" ".repeat(maxlenght[0]) + " | " + "Titre" + " ".repeat(maxlenght[1] - "Titre".length()) + " | Auteur" + " ".repeat(maxlenght[2] - "Auteur".length()) + " | Disponibilité" + " ".repeat(maxlenght[3] - "Dispobilité".length()));
        System.out.println(" ".repeat(maxlenght[0] + 1) + "|" + "-".repeat(maxlenght[1] + 2) + "|" + "-".repeat(maxlenght[2] + 2) + "|" + "-".repeat(20));

        for (Book book : books) {
            String message = colorize(String.valueOf(book.getIsbn()), CYAN) + " ".repeat(maxlenght[0] - String.valueOf(book.getIsbn()).length()) + " | " +
                    colorize(book.getTitle(), PURPLE) + " ".repeat(maxlenght[1] - book.getTitle().length()) + " | " +
                    colorize(book.getAuthor(), YELLOW) + " ".repeat(maxlenght[2] - book.getAuthor().length()) + " | " +
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

    public static void displayMembers(int[] maxlenght, ArrayList<Member> members) {
        System.out.println(" ".repeat(maxlenght[0]) + " | " + " NOM Prénom" + " ".repeat(maxlenght[1] - " NOM Prénom".length()) + " | Email" + " ".repeat(maxlenght[2] - "Email".length()) + " | Type" + " ".repeat(maxlenght[3] - "Type".length()));
        System.out.println(" ".repeat(maxlenght[0] + 1) + "|" + "-".repeat(maxlenght[1] + 2) + "|" + "-".repeat(maxlenght[2] + 2) + "|" + "-".repeat(20));

        for (Member member : members) {
            String message = colorize(String.valueOf(member.getId()), CYAN) + " ".repeat(maxlenght[0] - String.valueOf(member.getId()).length()) + " | " +
                    colorize(member.getName() + " " + member.getFirstName(), PURPLE) + " ".repeat(maxlenght[1] - (member.getName().length() + 1 + member.getFirstName().length())) + " | " +
                    colorize(member.getEmail(), YELLOW) + " ".repeat(maxlenght[2] - member.getEmail().length()) + " | " +
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

    public static void displayRentals(int[] maxlenght, ArrayList<Rental> rentals) {
        System.out.println(" ".repeat(maxlenght[0]) + " | " + "Titre" + " ".repeat(maxlenght[1] - "Titre".length()) + " | Emprunteur" + " ".repeat(maxlenght[2] - "Emprunteur".length()) + " | Date de retour" + " ".repeat(maxlenght[3] - "Date de retour".length()));
        System.out.println(" ".repeat(maxlenght[0] + 1) + "|" + "-".repeat(maxlenght[1] + 2) + "|" + "-".repeat(maxlenght[2] + 2) + "|" + "-".repeat(20));

        for (Rental rental : rentals) {
            String message = colorize(String.valueOf(rental.getId()), CYAN) + " ".repeat(maxlenght[0] - String.valueOf(rental.getId()).length()) + " | " +
                    colorize(rental.getBook().getTitle(), PURPLE) + " ".repeat(maxlenght[1] - rental.getBook().getTitle().length()) + " | " +
                    colorize(rental.getMember().getName() + " " + rental.getMember().getFirstName(), YELLOW) + " ".repeat(maxlenght[2] - (rental.getMember().getName().length() + 1 + rental.getMember().getFirstName().length())) + " | " +
                    Utils.getDateLateColor(rental);

            System.out.println(message);
        }
    }

    public static void displayRental(Rental rental) {
        System.out.println("Titre : " + colorize(rental.getBook().getTitle(), PURPLE));
        System.out.println("Emprunteur : " + colorize(rental.getMember().getName() + " " + rental.getMember().getFirstName(), YELLOW));
        System.out.println("Date de retour : " + Utils.getDateLateColor(rental));
    }
}
