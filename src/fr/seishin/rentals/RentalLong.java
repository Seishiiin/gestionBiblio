package fr.seishin.rentals;

import fr.seishin.books.Book;
import fr.seishin.members.Member;

import java.util.Date;

public class RentalLong extends Rental {
    public RentalLong(Book book, Member member, Date dateStart) {
        super(book, member, dateStart);
        this.dateEnd = new Date(dateStart.getTime() + 21 * 24 * 60 * 60 * 1000);
    }
}