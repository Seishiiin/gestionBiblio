package fr.seishin.books;

import fr.seishin.members.Member;

public abstract class Book {
    private static int count = 1;

    private int isbn;
    private String title;
    private String author;
    private int year;
    private boolean isAvailable = true;
    private Member borrowedBy = null;

    public Book(String title, String author, int year) {
        this.isbn = count;
        this.title = title;
        this.author = author;
        this.year = year;

        count += 1;
    }

    public int getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getYear() { return year; }
    public boolean isAvailable() { return isAvailable; }
    public Member getBorrowedBy() { return borrowedBy; }

    public void setIsbn(int isbn) { this.isbn = isbn; }
    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setYear(int year) { this.year = year; }
    public void setAvailable(boolean isAvailable) { this.isAvailable = isAvailable; }
    public void setBorrowedBy(Member borrowedBy) { this.borrowedBy = borrowedBy; }
}
