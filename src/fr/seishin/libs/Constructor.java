package fr.seishin.libs;

import fr.seishin.books.Book;
import fr.seishin.librairies.Library;
import fr.seishin.members.Member;
import fr.seishin.rentals.Rental;

public class Constructor {
    public static void Book(Book book, Library library) {
        library.addBook(book);
    }

    public static void Member(Member member, Library library) {
        library.addMember(member);
    }

    public static void Rental(Rental rental, Library library) {
        library.addRental(rental);

        rental.getBook().setIsAvailable(false);
        rental.getBook().setBorrowedBy(rental.getMember());
    }
}
