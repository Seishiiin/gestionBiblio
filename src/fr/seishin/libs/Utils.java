package fr.seishin.libs;

import fr.seishin.books.*;
import fr.seishin.librairies.Library;
import fr.seishin.libs.data.*;
import fr.seishin.members.*;
import fr.seishin.rentals.*;

import java.util.ArrayList;

import static fr.seishin.libs.TerminalColor.*;

public class Utils {
    public static int[] getMaxLengthBookAndMembresAndRentals(ArrayList<Book> books, ArrayList<Member> members, ArrayList<Rental> rentals) {
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

    public static void manageChoiceMainMenu(int[] maxlength, Library library, int choice) {
        switch (choice) {
            case 1 -> {
                System.out.println(colorize("-> Entrée dans le menu de gestion des livres \n", CYAN));
                Display.displayMenuBooks(maxlength, library);
            }
            case 2 -> {
                System.out.println(colorize("-> Entrée dans le menu de gestion des membres \n", BLUE));
                Display.displayMenuMembers(maxlength, library);
            }
            case 3 -> {
                System.out.println(colorize("-> Entrée dans le menu de gestion des emprunts \n", PURPLE));
                Display.displayMenuRentals(maxlength, library);
            }
            case 4 -> {
                System.out.println(colorize("-> Entrée dans le menu de gestion de la bibliothèque \n", YELLOW));
                Display.displayMenuLibrary(library);
            }
            case 5 -> {
                System.out.println(colorize("-> Entrée dans le menu de statistiques \n", GREEN));
                Display.displayMenuStats(library);
            }
            case 9 -> {
                System.out.println(colorize("-> Fermeture de l'application", RED));
                System.exit(0);
            }
            default -> System.out.println(colorize("-> Erreur : Veuillez saisir un nombre valide. \n", RED));
        }

        System.out.println();
    }

    public static void manageChoiceMenuBooks(int[] maxlength, Library library, int choice) {
        switch (choice) {
            case 1 -> Display.displayBooks(maxlength, library.getBooks());
            case 2 -> AddData.addBook(library);
            case 3 -> UpdateData.updateBook(library);
            case 4 -> DeleteData.deleteBook(library);
            case 5 -> SearchData.searchBook(library);
            case 6 -> Display.displayBooks(maxlength, library.getHistoryBook());

            case 9 -> Display.displayMainMenu(library);

            default -> System.out.println(colorize("-> Erreur : Veuillez saisir un nombre valide.", RED));
        }

        System.out.println();
    }

    public static void manageChoiceMenuMembers(int[] maxlength, Library library, int choice) {
        switch (choice) {
            case 1 -> Display.displayMembers(maxlength, library.getMembers());
            case 2 -> AddData.addMember(library);
            case 3 -> UpdateData.updateMember(library);
            case 4 -> DeleteData.deleteMember(library);
            case 5 -> SearchData.searchMember(library);
            case 6 -> Display.displayMembers(maxlength, library.getHistoryMember());

            case 9 -> Display.displayMainMenu(library);

            default -> System.out.println(colorize("-> Erreur : Veuillez saisir un nombre valide.", RED));
        }

        System.out.println();
    }

    public static void manageChoiceMenuRentals(int[] maxlength, Library library, int choice) {
        switch (choice) {
            case 1 -> Display.displayRentals(maxlength, library.getRentals());
            case 2 -> AddData.addRental(library);
            case 3 -> DeleteData.deleteRental(library);
            case 4 -> SearchData.searchRental(library);
            case 5 -> Display.displayRentals(maxlength, library.getHistoryRental());

            case 9 -> Display.displayMainMenu(library);

            default -> System.out.println(colorize("-> Erreur : Veuillez saisir un nombre valide.", RED));
        }

        System.out.println();
    }

    public static void manageChoiceMenuLibrary(Library library, int choice) {
        switch (choice) {
            case 1 -> UpdateData.updateLibrary(library);

            case 9 -> Display.displayMainMenu(library);

            default -> System.out.println(colorize("-> Erreur : Veuillez saisir un nombre valide.", RED));
        }

        System.out.println();
    }

    public static void manageChoiceMenuStats(Library library, int choice) {
        switch (choice) {
            case 1 -> Display.displayStatsLibrary(library);
            case 2 -> Display.displayStatsBooks(library);
            case 3 -> Display.displayStatsMembers(library);
            case 4 -> Display.displayStatsRentals(library);

            case 9 -> Display.displayMainMenu(library);

            default -> System.out.println(colorize("-> Erreur : Veuillez saisir un nombre valide.", RED));
        }

        System.out.println();
    }

    public static String getMemberTypeColor(Member member) {
        return switch (member) {
            case MemberRegular memberRegular -> colorize("(membre régulier)", GREEN);
            case MemberOccasional memberOccasional -> colorize("(membre occasionnel)", RED);
            case MemberVisitor memberVisitor -> colorize("(visiteur)", BLUE);
            default -> "";
        };
    }

    public static String getBookAvailabilityColor(Book book) {
        return switch (String.valueOf(book.isAvailable())) {
            case "true" -> colorize("(disponible)", GREEN);
            case "false" ->
                    colorize("(emprunté par " + book.getBorrowedBy().getName() + " " + book.getBorrowedBy().getFirstName() + ")", RED);
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