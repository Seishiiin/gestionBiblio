package fr.seishin.libs.data;

import fr.seishin.librairies.Library;

import java.util.Scanner;

import static fr.seishin.libs.TerminalColor.*;

public class DeleteData {
    public static void deleteBook(Library library) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Quel est l'ISBN du livre que vous voulez supprimer ? ");
            String isbn = scanner.nextLine();

            if (library.getBookByIsbn(Integer.parseInt(isbn)) != null) {
                library.addHistoryBook(library.getBookByIsbn(Integer.parseInt(isbn)));
                library.removeBook(library.getBookByIsbn(Integer.parseInt(isbn)));
                System.out.println(colorize("\n-> Succès : Livre supprimé. \n", GREEN));
            } else {
                System.out.println(colorize("\n-> Erreur : Aucun livre n'est lié à cet ISBN. \n", RED));
            }
        } catch (NumberFormatException e) {
            System.out.println(colorize("\n-> Erreur : L'ISBN du livre doit être un nombre valide. \n", RED));
        }
    }

    public static void deleteMember(Library library) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Quel est l'ID du membre que vous voulez supprimer ? ");
            int id = scanner.nextInt();

            if (library.getMemberById(id) != null) {
                library.addHistoryMember(library.getMemberById(id));
                library.removeMember(library.getMemberById(id));
                System.out.println(colorize("\n-> Succès : Membre supprimé. \n", GREEN));
            } else {
                System.out.println(colorize("\n-> Erreur : Aucun membre n'est lié à cet ID. \n", RED));
            }
        } catch (Exception e) {
            System.out.println(colorize("\n-> Erreur : L'ID du membre doit être un nombre valide. \n", RED));
        }
    }

    public static void deleteRental(Library library) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Quel est l'ID de la location que vous voulez supprimer ? ");
            int id = scanner.nextInt();

            if (library.getRentalById(id) != null) {
                library.addHistoryRental(library.getRentalById(id));
                library.getRentalById(id).getBook().setAvailable(true);
                library.getRentalById(id).getBook().setBorrowedBy(null);
                library.removeRental(library.getRentalById(id));
                System.out.println(colorize("\n-> Succès : Location supprimée. \n", GREEN));
            } else {
                System.out.println(colorize("\n-> Erreur : Aucune location n'est liée à cet ID. \n", RED));
            }
        } catch (Exception e) {
            System.out.println(colorize("\n-> Erreur : L'ID de la location doit être un nombre valide. \n", RED));
        }
    }
}
