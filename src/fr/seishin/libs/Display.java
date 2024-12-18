package fr.seishin.libs;

import fr.seishin.books.*;
import fr.seishin.members.*;
import fr.seishin.rentals.*;

import static fr.seishin.libs.Utils.getMaxLenghtBookAndMembresAndRentals;

import fr.seishin.librairies.Library;

import java.util.ArrayList;
import java.util.Scanner;

import static fr.seishin.libs.TerminalColor.*;

public class Display {
    public static void displayMenu(Library library) {
        int[] maxlenght = getMaxLenghtBookAndMembresAndRentals(library.getBooks(), library.getMembers(), library.getRentals());

        System.out.println("|--------------- " + (colorize(library.getName(), PURPLE)) + " ---------------|");
        System.out.println("| 10. " + colorize("Afficher les livres", CYAN));
        System.out.println("| 11. " + colorize("Ajouter un livre", CYAN));
        System.out.println("| 12. " + colorize("Supprimer un livre", CYAN));
        System.out.println("|");
        System.out.println("| 20. " + colorize("Afficher les membres", BLUE));
        System.out.println("| 21. " + colorize("Ajouter un membre", BLUE));
        System.out.println("| 22. " + colorize("Supprimer un membre", BLUE));
        System.out.println("|");
        System.out.println("| 30. " + colorize("Afficher les emprunts", PURPLE));
        System.out.println("| 31. " + colorize("Ajouter un emprunt", PURPLE));
        System.out.println("| 32. " + colorize("Supprimer un emprunt", PURPLE));
        System.out.println("|");
        System.out.println("| 90. " + colorize("Quitter", RED));
        System.out.println("|");
        System.out.print("| Faites votre choix : ");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        System.out.println("|" + "-".repeat(32 + library.getName().length()) + "|\n");

        Utils.manageChoiceMenu(choice);
    }

    public static void displayBook(int[] maxlenght, ArrayList<Book> books) {
        System.out.println(" ".repeat(maxlenght[0]) + " | " + "Titre" + " ".repeat(maxlenght[1] - "Titre".length()) + " | Auteur" + " ".repeat(maxlenght[2] - "Auteur".length()) + " | Disponibilité" + " ".repeat(maxlenght[3] - "Dispobilité".length()));
        System.out.println(" ".repeat(maxlenght[0] + 1) + "|" + "-".repeat(maxlenght[1] + 2) + "|" + "-".repeat(maxlenght[2] + 2) + "|" + "-".repeat(20));

        for (Book book : books) {
            String message = colorize(String.valueOf(book.getIsbn()), CYAN) + " ".repeat(maxlenght[0] - String.valueOf(book.getIsbn()).length()) + " | " +
                             colorize(book.getTitle(), PURPLE) + " ".repeat(maxlenght[1] - book.getTitle().length()) + " | " +
                             colorize(book.getAuthor(), YELLOW) + " ".repeat(maxlenght[2] - book.getAuthor().length()) + " | " +
                             Utils.getBookAvailabilityColor(book);

            System.out.println(message);
        }

        System.out.println("\n");
    }

    public static void displayMember(int[] maxlenght, ArrayList<Member> members) {
        System.out.println(" ".repeat(maxlenght[0]) + " | " + " NOM Prénom" + " ".repeat(maxlenght[1] - " NOM Prénom".length()) + " | Email" + " ".repeat(maxlenght[2] - "Email".length()) + " | Type" + " ".repeat(maxlenght[3] - "Type".length()));
        System.out.println(" ".repeat(maxlenght[0] + 1) + "|" + "-".repeat(maxlenght[1] + 2) + "|" + "-".repeat(maxlenght[2] + 2) + "|" + "-".repeat(20));

        for (Member member : members) {
            String message = colorize(String.valueOf(member.getId()), CYAN) + " ".repeat(maxlenght[0] - String.valueOf(member.getId()).length()) + " | " +
                             colorize(member.getName() + " " + member.getFirstName(), PURPLE) + " ".repeat(maxlenght[1] - (member.getName().length() + 1 + member.getFirstName().length())) + " | " +
                             colorize(member.getEmail(), YELLOW) + " ".repeat(maxlenght[2] - member.getEmail().length()) + " | " +
                             Utils.getMemberTypeColor(member);

            System.out.println(message);
        }

        System.out.println("\n");
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

        System.out.println("\n");
    }
}
