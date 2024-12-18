package fr.seishin.libs.data;

import fr.seishin.librairies.Library;

import java.util.Scanner;

import static fr.seishin.libs.Display.*;
import static fr.seishin.libs.TerminalColor.*;

public class SearchData {

    public static void searchBook(Library library) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Quel est l'ISBN du livre que vous voulez rechercher ? : ");
            String isbn = scanner.nextLine();

            if (library.getBookByIsbn(Integer.parseInt(isbn)) != null) {
                displayBook(library.getBookByIsbn(Integer.parseInt(isbn)));
            } else {
                System.out.println(colorize("\n-> Erreur : Aucun livre n'est lié à cet ISBN. \n", RED));
            }
        } catch (NumberFormatException e) {
            System.out.println(colorize("\n-> Erreur : L'ISBN du livre doit être un nombre valide. \n", RED));
        }
    }

    public static void searchMember(Library library) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Quel est l'ID du membre que vous voulez rechercher ? : ");
            String id = scanner.nextLine();

            if (library.getMemberById(Integer.parseInt(id)) != null) {
                displayMember(library.getMemberById(Integer.parseInt(id)));
            } else {
                System.out.println(colorize("\n-> Erreur : Aucun membre n'est lié à cet ID. \n", RED));
            }
        } catch (NumberFormatException e) {
            System.out.println(colorize("\n-> Erreur : L'ID du membre doit être un nombre valide. \n", RED));
        }
    }

    public static void searchRental(Library library) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Quel est l'ID de la location que vous voulez rechercher ? : ");
            String id = scanner.nextLine();

            if (library.getRentalById(Integer.parseInt(id)) != null) {
                displayRental(library.getRentalById(Integer.parseInt(id)));
            } else {
                System.out.println(colorize("\n-> Erreur : Aucune location n'est liée à cet ID. \n", RED));
            }
        } catch (NumberFormatException e) {
            System.out.println(colorize("\n-> Erreur : L'ID de la location doit être un nombre valide. \n", RED));
        }
    }
}
