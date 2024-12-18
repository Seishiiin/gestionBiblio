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
        Constructor.Member(new MemberRegular("Dupont", "Jean", "jean.dupont@example.com", "06 12 34 56 78", "1 rue de Paris"), library);
        Constructor.Member(new MemberVisitor("Martin", "Marie", "marie.martin@example.com", "06 23 45 67 89", "2 avenue de Lyon"), library);
        Constructor.Member(new MemberRegular("Bernard", "Luc", "luc.bernard@example.com", "06 34 56 78 90", "3 boulevard de Marseille"), library);
        Constructor.Member(new MemberOccasional("Dubois", "Sophie", "sophie.dubois@example.com", "06 45 67 89 01", "4 place de Lille"), library);
        Constructor.Member(new MemberRegular("Thomas", "Paul", "paul.thomas@example.com", "06 56 78 90 12", "5 allée de Bordeaux"), library);
        Constructor.Member(new MemberVisitor("Petit", "Julie", "julie.petit@example.com", "06 67 89 01 23", "6 impasse de Toulouse"), library);
        Constructor.Member(new MemberRegular("Robert", "Pierre", "pierre.robert@example.com", "06 78 90 12 34", "7 chemin de Nice"), library);
        Constructor.Member(new MemberOccasional("Richard", "Laura", "laura.richard@example.com", "06 89 01 23 45", "8 route de Nantes"), library);
        Constructor.Member(new MemberRegular("Durand", "Antoine", "antoine.durand@example.com", "06 90 12 34 56", "9 rue de Strasbourg"), library);
        Constructor.Member(new MemberVisitor("Leroy", "Emma", "emma.leroy@example.com", "06 01 23 45 67", "10 avenue de Montpellier"), library);
        Constructor.Member(new MemberRegular("Moreau", "Louis", "louis.moreau@example.com", "06 12 34 56 78", "11 boulevard de Rennes"), library);
        Constructor.Member(new MemberOccasional("Simon", "Chloé", "chloe.simon@example.com", "06 23 45 67 89", "12 place de Reims"), library);
        Constructor.Member(new MemberRegular("Laurent", "Lucas", "lucas.laurent@example.com", "06 34 56 78 90", "13 allée de Dijon"), library);
        Constructor.Member(new MemberVisitor("Lefebvre", "Alice", "alice.lefebvre@example.com", "06 45 67 89 01", "14 impasse de Brest"), library);
        Constructor.Member(new MemberRegular("Michel", "Hugo", "hugo.michel@example.com", "06 56 78 90 12", "15 chemin de Le Havre"), library);
        Constructor.Member(new MemberOccasional("Garcia", "Léa", "lea.garcia@example.com", "06 67 89 01 23", "16 route de Saint-Étienne"), library);
        Constructor.Member(new MemberRegular("David", "Maxime", "maxime.david@example.com", "06 78 90 12 34", "17 rue de Toulon"), library);
        Constructor.Member(new MemberVisitor("Martinez", "Camille", "camille.martinez@example.com", "06 89 01 23 45", "18 avenue de Grenoble"), library);
        Constructor.Member(new MemberRegular("Lopez", "Nathan", "nathan.lopez@example.com", "06 90 12 34 56", "19 boulevard de Angers"), library);
        Constructor.Member(new MemberOccasional("Gonzalez", "Sarah", "sarah.gonzalez@example.com", "06 01 23 45 67", "20 place de Nîmes"), library);

        Constructor.Book(new BookRomance("Pride and Prejudice", "Jane Austen", 1813), library);
        Constructor.Book(new BookManga("Naruto", "Masashi Kishimoto", 1999), library);
        Constructor.Book(new BookComic("Spider-Man", "Stan Lee", 1962), library);
        Constructor.Book(new BookMagazine("National Geographic", "National Geographic Society", 1888), library);
        Constructor.Book(new BookRomance("Wuthering Heights", "Emily Brontë", 1847), library);
        Constructor.Book(new BookManga("Dragon Ball", "Akira Toriyama", 1984), library);
        Constructor.Book(new BookComic("Superman", "Jerry Siegel", 1938), library);
        Constructor.Book(new BookMagazine("Time", "Time Inc.", 1923), library);
        Constructor.Book(new BookRomance("Jane Eyre", "Charlotte Brontë", 1847), library);
        Constructor.Book(new BookManga("Attack on Titan", "Hajime Isayama", 2009), library);
        Constructor.Book(new BookComic("X-Men", "Stan Lee", 1963), library);
        Constructor.Book(new BookMagazine("The Economist", "The Economist Group", 1843), library);
        Constructor.Book(new BookRomance("The Great Gatsby", "F. Scott Fitzgerald", 1925), library);
        Constructor.Book(new BookManga("Death Note", "Tsugumi Ohba", 2003), library);
        Constructor.Book(new BookComic("Batman", "Bob Kane", 1939), library);
        Constructor.Book(new BookMagazine("Forbes", "Forbes Media", 1917), library);
        Constructor.Book(new BookRomance("Anna Karenina", "Leo Tolstoy", 1877), library);
        Constructor.Book(new BookManga("One Piece", "Eiichiro Oda", 1997), library);
        Constructor.Book(new BookComic("The Avengers", "Stan Lee", 1963), library);
        Constructor.Book(new BookMagazine("Scientific American", "Springer Nature", 1845), library);

        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.JANUARY, 10);
        Constructor.Rental(new RentalShort(library.getBooks().get(0), library.getMembers().get(0), calendar.getTime()), library);

        calendar.set(2023, Calendar.FEBRUARY, 15);
        Constructor.Rental(new RentalLong(library.getBooks().get(1), library.getMembers().get(1), calendar.getTime()), library);

        calendar.set(2023, Calendar.MARCH, 20);
        Constructor.Rental(new RentalShort(library.getBooks().get(2), library.getMembers().get(2), calendar.getTime()), library);

        calendar.set(2023, Calendar.APRIL, 25);
        Constructor.Rental(new RentalLong(library.getBooks().get(3), library.getMembers().get(3), calendar.getTime()), library);

        calendar.set(2023, Calendar.MAY, 30);
        Constructor.Rental(new RentalShort(library.getBooks().get(4), library.getMembers().get(4), calendar.getTime()), library);

        calendar.set(2023, Calendar.JUNE, 5);
        Constructor.Rental(new RentalLong(library.getBooks().get(5), library.getMembers().get(5), calendar.getTime()), library);

        calendar.set(2023, Calendar.JULY, 10);
        Constructor.Rental(new RentalShort(library.getBooks().get(6), library.getMembers().get(6), calendar.getTime()), library);

        calendar.set(2023, Calendar.AUGUST, 15);
        Constructor.Rental(new RentalLong(library.getBooks().get(7), library.getMembers().get(7), calendar.getTime()), library);

        calendar.set(2023, Calendar.SEPTEMBER, 20);
        Constructor.Rental(new RentalShort(library.getBooks().get(8), library.getMembers().get(8), calendar.getTime()), library);

        calendar.set(2023, Calendar.OCTOBER, 25);
        Constructor.Rental(new RentalLong(library.getBooks().get(9), library.getMembers().get(9), calendar.getTime()), library);
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
                        library.getBooks().get(idBook - 1).setAvailable(false);
                        library.getBooks().get(idBook - 1).setBorrowedBy(library.getMembers().get(idMember - 1));
                        System.out.println(colorize("\n-> Succès : Location courte ajoutée. \n", GREEN));
                    }
                    case "2" -> {
                        library.addRental(new RentalLong(library.getBooks().get(idBook - 1), library.getMembers().get(idMember - 1), new Date()));
                        library.getBooks().get(idBook - 1).setAvailable(false);
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
