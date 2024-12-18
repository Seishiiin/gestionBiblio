package fr.seishin.libs.data;

import fr.seishin.librairies.Library;

import java.util.Scanner;

import static fr.seishin.libs.TerminalColor.*;

public class UpdateData {
    public static void updateBook(Library library) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Quel est l'ISBN du livre que vous voulez modifier ? : ");
            String isbn = scanner.nextLine();

            if (library.getBookByIsbn(Integer.parseInt(isbn)) != null) {
                System.out.print("Nouveau titre : ");
                String title = scanner.nextLine();

                System.out.print("Nouvel auteur : ");
                String author = scanner.nextLine();

                System.out.print("Nouvelle année de publication : ");
                int year = scanner.nextInt();

                library.getBookByIsbn(Integer.parseInt(isbn)).setTitle(title);
                library.getBookByIsbn(Integer.parseInt(isbn)).setAuthor(author);
                library.getBookByIsbn(Integer.parseInt(isbn)).setYear(year);

                System.out.println(colorize("\n-> Succès : Livre modifié. \n", GREEN));
            } else {
                System.out.println(colorize("\n-> Erreur : Aucun livre n'est lié à cet ISBN. \n", RED));
            }
        } catch (NumberFormatException e) {
            System.out.println(colorize("\n-> Erreur : L'ISBN doit être un nombre valide. \n", RED));
        }
    }

    public static void updateMember(Library library) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Quel est l'ID du membre que vous voulez modifier ? : ");
            String id = scanner.nextLine();

            if (library.getMemberById(Integer.parseInt(id)) != null) {
                System.out.print("Nouveau nom : ");
                String name = scanner.nextLine();

                System.out.print("Nouveau prénom : ");
                String firstName = scanner.nextLine();

                System.out.print("Nouvel email : ");
                String email = scanner.nextLine();

                System.out.print("Nouveau téléphone : ");
                String phone = scanner.nextLine();

                System.out.print("Nouvelle adresse : ");
                String address = scanner.nextLine();

                library.getMemberById(Integer.parseInt(id)).setName(name);
                library.getMemberById(Integer.parseInt(id)).setFirstName(firstName);
                library.getMemberById(Integer.parseInt(id)).setEmail(email);
                library.getMemberById(Integer.parseInt(id)).setPhone(phone);
                library.getMemberById(Integer.parseInt(id)).setAddress(address);

                System.out.println(colorize("\n-> Succès : Membre modifié. \n", GREEN));
            } else {
                System.out.println(colorize("\n-> Accès : Aucun membre n'est lié à cet ID. \n", RED));
            }
        } catch (NumberFormatException e) {
            System.out.println(colorize("\n-> Erreur : L'ID doit être un nombre valide. \n", RED));
        }
    }

    public static void updateLibrary(Library library) {

    }
}
