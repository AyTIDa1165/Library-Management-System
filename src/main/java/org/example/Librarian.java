package org.example;

import java.util.ArrayList;
import java.util.List;

class Librarian{
    static private List<Book> avail_books;
    static private List <Member> my_members;

    private int member_ids = 1;

    private int book_ids = 1;
    public Librarian(){
        my_members = new ArrayList<>();
        avail_books = new ArrayList<>();
    }

    public int getMember_ids() {
        return member_ids;
    }

    public void setMember_ids(int member_id) {
        member_ids = member_id;
    }

    public int getBook_ids() {
        return book_ids;
    }

    public void add_Book(String title, String author, int copies, int book_ID){

        for (int i = 0; i<copies; i++){
            Book book = new Book(title, author, book_ID+i);
            avail_books.add(book);
        }
        book_ids += copies;
    }

    public void add_Book_special(Book B){
        avail_books.add(B);
    }

    public void remove_Book(int book_id){
        if(check_book(book_id) == null){
            System.out.println("Book not found");
        }
        else{
            avail_books.remove(check_book(book_id));
        }
    }
    public void add_member(String name, int age, int id, String num){
        Member member = new Member(name, age, id, num);

        int flag3 = 0;
        for (Member my_member : my_members) {
            if (my_member.getMember_phno().equals(num)) {
                System.out.println("This phone number is already registered");
                flag3 = 1;
                member_ids++;
                break;
            }
        }
        if (flag3 == 0){
            my_members.add(member);
            System.out.println("Member added");
        }
    }

    public void remove_member(int member_id){
        if(return_member(member_id) == null){
            System.out.println("Member not found");
        }
        else{
            if(!return_member(member_id).getOwned_books().isEmpty()){
                System.out.println("Cannot remove as member has not returned issued books");
            }
            else if(return_member(member_id).getFine() != 0){
                System.out.println("Cannot remove as member has not paid fine");
            }
            else{
                my_members.remove(return_member(member_id));
                System.out.println("Member removed");
            }
        }
    }

    public int check_member(String name, String mem_ph_no){
        for (Member my_member : my_members) {
            if (my_member.getMember_phno().equals(mem_ph_no) && my_member.getName().equals(name)) {
                return my_member.getMember_ID();
            }
        }
        return 0;
    }

    public Member return_member(int member_id){
        for (Member my_member : my_members) {
            if (my_member.getMember_ID() == member_id) {
                return my_member;
            }
        }
        return null;
    }

    public Book check_book(int book_id){
        for (Book avail_book : avail_books) {
            if (avail_book.getBook_ID() == book_id) {
                return avail_book;
            }
        }
        return null;
    }
    public void get_members(){
        for (Member member_i : my_members) {
            member_i.print_member_info();
        }
    }

    public void get_avail_books(){
        for (Book book_i : avail_books) {
            book_i.print_Book_info();
        }
    }

    public void get_issued_books(){
        for(Member my_member : my_members){
            for(Book my_book: my_member.getOwned_books()){
                my_book.print_Book_info();
            }
        }
    }
}