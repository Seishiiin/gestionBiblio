package fr.seishin.libs;

import fr.seishin.books.*;
import fr.seishin.members.*;
import fr.seishin.rentals.RentalShort;
import fr.seishin.rentals.RentalLong;

import fr.seishin.librairies.Library;

import java.util.Calendar;
import java.util.Date;

public class AddData {
    public static void addMembers(Library library) {
        Constructor.Member(new MemberRegular("Hallosserie", "Gabin", "gabin.hallosserie@icloud.com", "07 66 78 92 93", "44 rue de Metz 81100 Castres"), library);
        Constructor.Member(new MemberVisitor("Trousseau", "Jean-Gabriel", "jean-gabriel.trousseau@icloud.com", "07 56 78 92 93", "12 rue des Lilas 81100 Castres"), library);
        Constructor.Member(new MemberRegular("Laporte", "Jean", "jean.laporte@icloud.com", "07 66 78 34 24", "23 avenue des Pyrénées 81100 Castres"), library);
    }

    public static void addBooks(Library library) {
        Constructor.Book(new BookRomance("Harry Potter", "J.K. Rowling", 1997), library);
        Constructor.Book(new BookManga("One Piece", "Eiichiro Oda", 1997), library);
        Constructor.Book(new BookComic("Batman", "Bob Kane", 1939), library);
        Constructor.Book(new BookMagazine("Le Monde", "Le Monde", 1944), library);
    }

    public static void addRentals(Library library) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(2001, Calendar.MARCH, 2);
        Constructor.Rental(new RentalShort(library.getBooks().getFirst(), library.getMembers().getFirst(), calendar.getTime()), library);

        Constructor.Rental(new RentalLong(library.getBooks().get(1), library.getMembers().get(1), new Date()), library);
        Constructor.Rental(new RentalShort(library.getBooks().get(2), library.getMembers().get(2), new Date()), library);
    }

    public static void addData(Library library) {
        addMembers(library);
        addBooks(library);
        addRentals(library);
    }
}
