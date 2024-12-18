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

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void removeMember(Member member) {
        members.remove(member);
    }

    public void removeRental(Rental rental) {
        rentals.remove(rental);
    }

    public Book getBookByIsbn(int isbn) {
        for (Book book : books) {
            if (book.getIsbn() == isbn) {
                return book;
            }
        }
        return null;
    }

    public Member getMemberById(int i) {
        for (Member member : members) {
            if (member.getId() == i) {
                return member;
            }
        }
        return null;
    }

    public Rental getRentalById(int i) {
        for (Rental rental : rentals) {
            if (rental.getId() == i) {
                return rental;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public ArrayList<Rental> getRentals() {
        return rentals;
    }

    public void setName(String name) {
        this.name = name;
    }
}
