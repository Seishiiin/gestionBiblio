package fr.seishin.rentals;

import fr.seishin.books.Book;
import fr.seishin.members.Member;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Rental {
    private static int count = 1;

    private final int id;
    private final Book book;
    private final Member member;
    private final Date dateStart;
    protected Date dateEnd;

    public Rental(Book book, Member member, Date dateStart) {
        this.id = count;
        this.book = book;
        this.member = member;
        this.dateStart = dateStart;

        count += 1;
    }

    public boolean isLate() { return dateEnd.before(new Date()); }
    public int getId() { return id; }
    public Book getBook() { return book; }
    public Member getMember() { return member; }
    public String getDateEnd() { return new SimpleDateFormat("dd/MM/yyyy").format(dateEnd); }
}
