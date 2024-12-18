package fr.seishin.rentals;

import fr.seishin.books.Book;
import fr.seishin.members.Member;

import java.util.Date;

public class RentalShort extends Rental {
    public RentalShort(Book book, Member member, Date dateStart) {
        super(book, member, dateStart);
        this.dateEnd = new Date(dateStart.getTime() + 7 * 24 * 60 * 60 * 1000);
    }
}
