package fr.seishin.libs.data;

import fr.seishin.books.*;
import fr.seishin.librairies.Library;
import fr.seishin.libs.Constructor;
import fr.seishin.members.*;
import fr.seishin.rentals.*;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import static fr.seishin.libs.TerminalColor.*;

public class AddData {
    public static void addData(Library library) {
        Constructor.Member(new MemberRegular("Hallosserie", "Gabin", "gabin.hallosserie@icloud.com", "07 66 78 92 93", "44 rue de Metz 81100 Castres"), library);
        Constructor.Member(new MemberVisitor("Trousseau", "Jean-Gabriel", "jean-gabriel.trousseau@icloud.com", "07 56 78 92 93", "12 rue des Lilas 81100 Castres"), library);
        Constructor.Member(new MemberRegular("Laporte", "Jean", "jean.laporte@icloud.com", "07 66 78 34 24", "23 avenue des Pyrénées 81100 Castres"), library);

        Constructor.Book(new BookRomance("Harry Potter", "J.K. Rowling", 1997), library);
        Constructor.Book(new BookManga("One Piece", "Eiichiro Oda", 1997), library);
        Constructor.Book(new BookComic("Batman", "Bob Kane", 1939), library);
        Constructor.Book(new BookMagazine("Le Monde", "Le Monde", 1944), library);

        Calendar calendar = Calendar.getInstance();
        calendar.set(2001, Calendar.MARCH, 2);
        Constructor.Rental(new RentalShort(library.getBooks().getFirst(), library.getMembers().getFirst(), calendar.getTime()), library);

        Constructor.Rental(new RentalLong(library.getBooks().get(1), library.getMembers().get(1), new Date()), library);
        Constructor.Rental(new RentalShort(library.getBooks().get(2), library.getMembers().get(2), new Date()), library);
    }

    public static void addBook(Library library) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quel est le type de livre que vous voulez ajouter ? (1: Romance, 2: BD, 3: Manga, 4: Magazine) : ");
        String choice = scanner.nextLine();

        System.out.print("Titre : ");
        String title = scanner.nextLine();

        System.out.print("Auteur : ");
        String author = scanner.nextLine();

        try {
            System.out.print("Année de parution : ");
            int year = scanner.nextInt();

            switch (choice) {
                case "1" -> {
                    library.addBook(new BookRomance(title, author, year));
                    System.out.println(colorize("\n-> Succès : Roman ajouté. \n", GREEN));
                }
                case "2" -> {
                    library.addBook(new BookComic(title, author, year));
                    System.out.println(colorize("\n-> Succès : BD ajoutée. \n", GREEN));
                }
                case "3" -> {
                    library.addBook(new BookManga(title, author, year));
                    System.out.println(colorize("\n-> Succès : Manga ajouté. \n", GREEN));
                }
                case "4" -> {
                    library.addBook(new BookMagazine(title, author, year));
                    System.out.println(colorize("\n-> Succès : Magazine ajouté. \n", GREEN));
                }
                default -> System.out.println(colorize("\n-> Erreur : Ce type de livre n'est pas pris en compte. \n", RED));
            }
        } catch (Exception e) {
            System.out.println(colorize("\n-> Erreur : L'année de parution doit être un nombre valide. \n", RED));
        }
    }

    public static void addMember(Library library) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quel est le type de membre que vous voulez ajouter ? (1: Régulier, 2: Occasionnel, 3: Visiteur) : ");
        String choice = scanner.nextLine();

        System.out.print("Nom : ");
        String name = scanner.nextLine();

        System.out.print("Prénom : ");
        String firstName = scanner.nextLine();

        System.out.print("Email : ");
        String email = scanner.nextLine();

        System.out.print("Téléphone : ");
        String phone = scanner.nextLine();

        System.out.print("Adresse : ");
        String address = scanner.nextLine();

        switch (choice) {
            case "1" -> {
                library.addMember(new MemberRegular(name, firstName, email, phone, address));
                System.out.println(colorize("\n-> Succès : Membre régulier ajouté. \n", GREEN));
            }
            case "2" -> {
                library.addMember(new MemberOccasional(name, firstName, email, phone, address));
                System.out.println(colorize("\n-> Succès : Membre occasionnel ajouté. \n", GREEN));
            }
            case "3" -> {
                library.addMember(new MemberVisitor(name, firstName, email, phone, address));
                System.out.println(colorize("\n-> Succès : Visiteur ajouté. \n", GREEN));
            }
            default -> System.out.println(colorize("\n-> Erreur : Ce type de membre n'est pas pris en compte. \n", RED));
        }
    }

    public static void addRental(Library library) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quel est le type de location que vous voulez ajouter ? (1: Court, 2: Long) : ");
        String choice = scanner.nextLine();

        try {
            System.out.print("ID du livre : ");
            int idBook = scanner.nextInt();

            try {
                System.out.print("ID du membre : ");
                int idMember = scanner.nextInt();

                if (!library.getBookByIsbn(idBook).isAvailable()) {
                    System.out.println(colorize("\n-> Erreur : Ce livre est déjà emprunté. \n", RED));
                    return;
                }

                switch (choice) {
                    case "1" -> {
                        library.addRental(new RentalShort(library.getBooks().get(idBook - 1), library.getMembers().get(idMember - 1), new Date()));
                        library.getBooks().get(idBook - 1).setIsAvailable(false);
                        library.getBooks().get(idBook - 1).setBorrowedBy(library.getMembers().get(idMember - 1));
                        System.out.println(colorize("\n-> Succès : Location courte ajoutée. \n", GREEN));
                    }
                    case "2" -> {
                        library.addRental(new RentalLong(library.getBooks().get(idBook - 1), library.getMembers().get(idMember - 1), new Date()));
                        library.getBooks().get(idBook - 1).setIsAvailable(false);
                        library.getBooks().get(idBook - 1).setBorrowedBy(library.getMembers().get(idMember - 1));
                        System.out.println(colorize("\n-> Succès : Location longue ajoutée. \n", GREEN));
                    }
                    default -> System.out.println(colorize("\n-> Erreur : Ce type de location n'est pas pris en compte. \n", RED));
                }
            } catch (Exception e) {
                System.out.println(colorize("\n-> Erreur : L'ID du membre doit être un nombre valide. \n", RED));
            }
        } catch (Exception e) {
            System.out.println(colorize("\n-> Erreur : L'ID du livre doit être un nombre valide. \n", RED));
        }
    }
}
