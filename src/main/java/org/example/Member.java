package org.example;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private int age;
    private int member_ID;
    private String ph_Number;
    private long static_fine = 0;
    private List<Book> owned_books;

    public Member(String name, int age, int id, String num){
        this.name = name;
        this.age = age;
        this.member_ID = id;
        this.ph_Number = num;
        this.owned_books = new ArrayList<>();
    }

    public int getMember_ID(){
        return this.member_ID;
    }

    public String getName() {
        return name;
    }

    public String getMember_phno(){
        return this.ph_Number;
    }

    public List<Book> getOwned_books() {
        return owned_books;
    }

    public long dynamicFine() {
        long dynamic_fine;
        for(Book my_book : this.owned_books){
            if(check_issued_book(my_book.getBook_ID()) != null){
                my_book.setMid_time(System.currentTimeMillis());
                dynamic_fine = my_book.getMid_time() - my_book.getIssue_time();
                dynamic_fine /= 1000;
                dynamic_fine -= 10;
                dynamic_fine *= 3;
                if(dynamic_fine >0){
                    return dynamic_fine;
                }
            }
        }
        return 0;
    }

    public long getFine(){
        return this.static_fine + dynamicFine();
    }

    public void print_member_info(){
        System.out.println("Member ID: " + this.member_ID);
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age );
        System.out.println("Fine due: " + getFine());
        this.My_Books();
        System.out.print("\n");
    }

    public Book check_issued_book(int book_id){
        for (Book owned_book : this.owned_books) {
            if (owned_book.getBook_ID() == book_id) {
                return owned_book;
            }
        }
        return null;
    }
    public void Avail_Books(Librarian L){
        L.get_avail_books();
    }
    public void My_Books(){
        System.out.println("\nBooks owned: ");
        if(this.owned_books.isEmpty()){
            System.out.println("None");
        }
        for (Book book_i : this.owned_books) {
            book_i.print_Book_info();
        }
    }
    public void Issue_Book(Librarian L, int book_id){
        if(this.owned_books.size() >=2){
            System.out.println("2 books have already been issued");
        }
        else if(getFine()!=0){
            System.out.println("Fine is due");
        }
        else if(L.check_book(book_id) == null){
            System.out.println("Book not available");
        }
        else{
            L.check_book(book_id).setIssue_time(System.currentTimeMillis());
            this.owned_books.add(L.check_book(book_id));
            L.remove_Book(book_id);
            System.out.println("Book issued");
        }
    }
    public void Return_issued_Book(Librarian L, int book_id){
        long fine_book = 0;
        if(check_issued_book(book_id) == null){
            System.out.println("Book not issued yet");
        }
        else{
            this.check_issued_book(book_id).setReturn_time(System.currentTimeMillis());
            fine_book = this.check_issued_book(book_id).getReturn_time()
                    - this.check_issued_book(book_id).getIssue_time();
            fine_book /= 1000;
            fine_book -= 10;
            fine_book *= 3;

            if(fine_book >0){
                this.static_fine += fine_book;
            }
            else{
                fine_book = 0;
            }

            L.add_Book_special(check_issued_book(book_id));
            this.owned_books.remove(check_issued_book(book_id));
            System.out.println("Book returned");

            System.out.println("Fine to be paid on this book: " + fine_book);
            System.out.println("Total fine to be paid: " + getFine());
        }
    }
    public void Pay_Fine(){
        if(this.static_fine == 0){
            System.out.println("No fine due on returned books");
        }
        else if(this.owned_books.size() == 2){
            System.out.println("Return at least one book before paying fine");
        }
        else {
            System.out.println("Fine of Rs " + this.static_fine + " has been paid");
            this.static_fine = 0;
        }
    }
}

