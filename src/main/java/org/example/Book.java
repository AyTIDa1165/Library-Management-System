package org.example;

public class Book {
    private long issue_time;

    private long mid_time;
    private long return_time;
    private String title;
    private String author;
    private int book_ID;

    public long getIssue_time() {
        return issue_time;
    }

    public long getReturn_time() {
        return return_time;
    }

    public long getMid_time() {
        return mid_time;
    }

    public void setMid_time(long mid_time) {
        this.mid_time = mid_time;
    }

    public void setIssue_time(long issue_time) {
        this.issue_time = issue_time;
    }

    public void setReturn_time(long return_time) {
        this.return_time = return_time;
    }

    public Book(String title, String author, int book_ID){
        this.title = title;
        this.author = author;
        this.book_ID = book_ID;
    }

    public int getBook_ID(){
        return this.book_ID;
    }
    public void print_Book_info(){
        System.out.println("Book ID: " + this.book_ID);
        System.out.println("Book title: " + this.title);
        System.out.println("Author: " + this.author + "\n");
    }
}