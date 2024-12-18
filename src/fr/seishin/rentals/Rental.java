package fr.seishin.rentals;

import fr.seishin.books.Book;
import fr.seishin.members.Member;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Rental {
    private static int count = 1;

    private int id;
    private Book book;
    private Member member;
    private Date dateStart;
    protected Date dateEnd;

    public Rental(Book book, Member member, Date dateStart) {
        this.id = count;
        this.book = book;
        this.member = member;
        this.dateStart = dateStart;

        count += 1;
    }

    public boolean isLate() {
        return dateEnd.before(new Date());
    }

    public int getId() { return id; }
    public Book getBook() { return book; }
    public Member getMember() { return member; }
    public String getDateStart() { return new SimpleDateFormat("dd/MM/yyyy").format(dateStart); }
    public String getDateEnd() { return new SimpleDateFormat("dd/MM/yyyy").format(dateEnd); }
}
