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

    public static void manageChoiceMenu(int[] maxlength, Library library, int choice) {
        switch (choice) {
            case 10 -> Display.displayBooks(maxlength, library.getBooks());
            case 11 -> AddData.addBook(library);
            case 12 -> UpdateData.updateBook(library);
            case 13 -> DeleteData.deleteBook(library);
            case 14 -> SearchData.searchBook(library);
            case 15 -> Display.displayBooks(maxlength, library.getHistoryBook());

            case 20 -> Display.displayMembers(maxlength, library.getMembers());
            case 21 -> AddData.addMember(library);
            case 22 -> UpdateData.updateMember(library);
            case 23 -> DeleteData.deleteMember(library);
            case 24 -> SearchData.searchMember(library);
            case 25 -> Display.displayMembers(maxlength, library.getHistoryMember());

            case 30 -> Display.displayRentals(maxlength, library.getRentals());
            case 31 -> AddData.addRental(library);
            case 33 -> DeleteData.deleteRental(library);
            case 34 -> SearchData.searchRental(library);
            case 35 -> Display.displayRentals(maxlength, library.getHistoryRental());

            case 99 -> System.exit(0);

            default -> System.out.println(colorize("-> Erreur : Veuillez saisir un nombre valide.", RED));
        }

        System.out.println();
    }

    private static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
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