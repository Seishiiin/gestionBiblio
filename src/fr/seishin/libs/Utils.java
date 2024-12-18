package fr.seishin.libs;

import fr.seishin.books.Book;
import fr.seishin.members.*;
import fr.seishin.rentals.Rental;

import java.util.ArrayList;

import static fr.seishin.libs.TerminalColor.*;

public class Utils {
    public static int[] getMaxLenghtBookAndMembresAndRentals(ArrayList<Book> books, ArrayList<Member> members, ArrayList<Rental> rentals) {
        int maxfirst = 0, maxsecond = 0, maxthird = 0, maxfourth = 0;

        for (Book book : books) {
            maxfirst = Math.max(maxfirst, String.valueOf(book.getIsbn()).length());
            maxsecond = Math.max(maxsecond, book.getTitle().length());
            maxthird = Math.max(maxthird, book.getAuthor().length());
            maxfourth = Math.max(maxfourth, getBookAvailabilityColor(book).length());
        }

        for (Member member : members) {
            maxfirst = Math.max(maxfirst, String.valueOf(member.getId()).length());
            maxsecond = Math.max(maxsecond, (member.getName() + " " + member.getFirstName()).length());
            maxthird = Math.max(maxthird, member.getEmail().length());
            maxfourth = Math.max(maxfourth, getMemberTypeColor(member).length());
        }

        for (Rental rental : rentals) {
            maxfirst = Math.max(maxfirst, String.valueOf(rental.getId()).length());
            maxsecond = Math.max(maxsecond, rental.getBook().getTitle().length());
            maxthird = Math.max(maxthird, (rental.getMember().getName() + " " + rental.getMember().getFirstName()).length());
            maxfourth = Math.max(maxfourth, getDateLateColor(rental).length());
        }

        return new int[]{maxfirst, maxsecond, maxthird, maxfourth};
    }

    public static void manageChoiceMenu(int choice) {
        switch (choice) {
            case 10 -> System.out.println("Vous avez choisi d'afficher les livres.");
            case 11 -> System.out.println("Vous avez choisi d'ajouter un livre.");
            case 12 -> System.out.println("Vous avez choisi de supprimer un livre.");

            case 20 -> System.out.println("Vous avez choisi d'afficher les membres.");
            case 21 -> System.out.println("Vous avez choisi d'ajouter un membre.");
            case 22 -> System.out.println("Vous avez choisi de supprimer un membre.");

            case 30 -> System.out.println("Vous avez choisi d'afficher les emprunts.");
            case 31 -> System.out.println("Vous avez choisi d'ajouter un emprunt.");
            case 32 -> System.out.println("Vous avez choisi de supprimer un emprunt.");

            case 90 -> System.exit(0);

            default -> System.out.println("Choix invalide.");
        }

        System.out.println();
    }

    public static String getMemberTypeColor(Member member) {
        return switch (member) {
            case MemberRegular memberRegular -> colorize("(membre régulier)", ORANGE);
            case MemberOccasional memberOccasional -> colorize("(membre occasionnel)", RED);
            case MemberVisitor memberVisitor -> colorize("(visiteur)", BLUE);
            default -> "";
        };
    }

    public static String getBookAvailabilityColor(Book book) {
        return switch (String.valueOf(book.isAvailable())) {
            case "true" -> colorize("(disponible)", GREEN);
            case "false" -> colorize("(emprunté par " + book.getBorrowedBy().getName() + " " + book.getBorrowedBy().getFirstName() + ")", RED);
            default -> "";
        };
    }

    public static String getDateLateColor(Rental rental) {
        return switch (String.valueOf(rental.isLate())) {
            case "true" -> colorize(rental.getDateEnd(), RED);
            case "false" -> colorize(rental.getDateEnd(), GREEN);
            default -> "";
        };
    }
}