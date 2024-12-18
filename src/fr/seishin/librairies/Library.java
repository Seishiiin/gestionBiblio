package fr.seishin.librairies;

import fr.seishin.books.Book;
import fr.seishin.members.Member;
import fr.seishin.rentals.Rental;

import java.util.ArrayList;

public class Library {
    private String name;
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<Rental> rentals = new ArrayList<>();

    public Library(String name) {
        this.name = name;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() { return name; }
    public ArrayList<Book> getBooks() { return books; }
    public ArrayList<Member> getMembers() { return members; }
    public ArrayList<Rental> getRentals() { return rentals; }

    public void setName(String name) { this.name = name; }
}
