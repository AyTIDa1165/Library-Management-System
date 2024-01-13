package org.example;
import java.util.Scanner;

public class Library {
    public static void main(String[] args) {

        Librarian L1 = new Librarian();

        String Home_Page = """
                ---------------------------------
                1. Enter as a librarian
                2. Enter as a member
                3. Exit
                ---------------------------------""";

        System.out.println("Library Portal Initialized...");
        while(true) {
            int home_qn;
            try{
                System.out.println(Home_Page);
                Scanner sc1 = new Scanner(System.in);
                home_qn = sc1.nextInt();
            }
            catch (java.util.InputMismatchException e){
                home_qn = 4;
            }

            if (home_qn == 1) {
                //code for librarian
                while(true) {
                    String Lib_Page = """
                            ---------------------------------
                            1. Register a member
                            2. Remove a member
                            3. Add a book
                            4. Remove a book
                            5. View all members along with their books and fines to be paid
                            6. View all books
                            7. Back
                            ---------------------------------""";
                    int Lib_qn;
                    try {
                        System.out.println(Lib_Page);
                        Scanner sc2 = new Scanner(System.in);
                        Lib_qn = sc2.nextInt();
                    }

                    catch (java.util.InputMismatchException e){
                        Lib_qn = 0;
                    }

                    if (Lib_qn == 1) {
                        //Register a member
                        System.out.print("Registering name: \nName: ");
                        Scanner sc4 = new Scanner(System.in);
                        String mem_name = sc4.nextLine();

                        int mem_age;
                        while(true) {
                            try {
                                System.out.print("Age: ");
                                Scanner sc5 = new Scanner(System.in);
                                mem_age = sc5.nextInt();
                                break;
                            } catch (java.util.InputMismatchException e) {
                                System.out.println("Age should be integer");
                            }
                        }


                        System.out.print("Phone no: ");
                        Scanner sc6 = new Scanner(System.in);
                        String mem_phno = sc6.next();

                        L1.add_member(mem_name, mem_age, L1.getMember_ids(), mem_phno);
                        L1.setMember_ids(L1.getMember_ids()+1);

                    }else if (Lib_qn == 2) {
                        //Remove a member
                        int member_id_input;
                        while(true){
                            try{
                                System.out.print("Removing member: \nMember ID of user: ");
                                Scanner sc10 = new Scanner(System.in);
                                member_id_input = sc10.nextInt();
                                break;
                            }
                            catch (java.util.InputMismatchException e) {
                                System.out.println("Member ID should be integer");
                            }
                        }
                        L1.remove_member(member_id_input);

                    } else if (Lib_qn == 3) {
                        //Add a book
                        System.out.print("Adding books: \nBook title: ");
                        Scanner sc7 = new Scanner(System.in);
                        String book_title = sc7.nextLine();

                        System.out.print("Author: ");
                        Scanner sc8 = new Scanner(System.in);
                        String book_author = sc8.nextLine();

                        int book_copies;
                        while(true){
                            try{
                                System.out.print("Copies: ");
                                Scanner sc9 = new Scanner(System.in);
                                book_copies = sc9.nextInt();
                                break;
                            }
                            catch (java.util.InputMismatchException e) {
                                System.out.println("Number of copies should be integer");
                            }
                        }
                        if(book_copies == 0){
                            System.out.println("No copies have been added");
                        }

                        else{
                            L1.add_Book(book_title, book_author, book_copies, L1.getBook_ids());
                            System.out.println("Book(s) added");
                        }

                    } else if (Lib_qn == 4) {
                        //Remove a book
                        int book_id_input;
                        while(true){
                            try{
                                System.out.print("Removing book: \nBook ID of book: ");
                                Scanner sc11 = new Scanner(System.in);
                                book_id_input = sc11.nextInt();
                                break;
                            }
                            catch (java.util.InputMismatchException e) {
                                System.out.println("Book ID should be integer");
                            }
                        }
                        L1.remove_Book(book_id_input);

                    } else if (Lib_qn == 5) {
                        //view members and their fines
                        System.out.println("Information about registered members: \n");
                        L1.get_members();

                    } else if (Lib_qn == 6) {
                        //View all books
                        System.out.println("List of available books in library: \n");
                        L1.get_avail_books();
                        System.out.println("List of all issued books: \n");
                        L1.get_issued_books();

                    } else if (Lib_qn == 7) {
                        System.out.println("Going back");
                        break;

                    } else {
                        System.out.println("Invalid command, try again");
                    }
                }
            }

            else if (home_qn == 2) {
                //code for member
                //enter member
                System.out.print("Name: ");
                Scanner sc11 = new Scanner(System.in);
                String enter_name = sc11.nextLine();
                System.out.print("Phone No: ");
                Scanner sc12 = new Scanner(System.in);
                String enter_phno = sc12.nextLine();
                int logged_member_ID = L1.check_member(enter_name, enter_phno);
                if (logged_member_ID == 0) {
                    System.out.println("Member with Name: " + enter_name + " and Phone No: " +
                            enter_phno + " doesn't exist.");

                } else {
                    System.out.println("Welcome " + enter_name +
                            ". Member ID: " + logged_member_ID);
                    Member logged_member = L1.return_member(logged_member_ID);
                    while (true) {
                        String Mem_page = """
                                ---------------------------------
                                1. List Available Books
                                2. List My Books
                                3. Issue book
                                4. Return book
                                5. Pay Fine
                                6. Back
                                ---------------------------------""";

                        int mem_qn;
                        try{
                            System.out.println(Mem_page);
                            Scanner sc3 = new Scanner(System.in);
                            mem_qn = sc3.nextInt();
                        }

                        catch (java.util.InputMismatchException e){
                            mem_qn = 0;
                        }

                        if (mem_qn == 1) {
                            System.out.println("List of available books in library: \n");
                            logged_member.Avail_Books(L1);

                        } else if (mem_qn == 2) {
                            //List my books
                            logged_member.My_Books();

                        } else if (mem_qn == 3) {
                            //issue book
                            int book_id;
                            while(true){
                                try{
                                    System.out.print("Enter book ID: ");
                                    Scanner sc13 = new Scanner(System.in);
                                    book_id = sc13.nextInt();
                                    break;
                                }
                                catch (java.util.InputMismatchException e) {
                                    System.out.println("Book ID should be integer");
                                }
                            }
                            logged_member.Issue_Book(L1, book_id);

                        } else if (mem_qn == 4) {
                            //return book
                            int book_id;
                            while(true){
                                try{
                                    System.out.print("Enter Book ID: ");
                                    Scanner sc14 = new Scanner(System.in);
                                    book_id = sc14.nextInt();
                                    break;
                                }
                                catch (java.util.InputMismatchException e) {
                                    System.out.println("Book ID should be integer");
                                }
                            }
                            logged_member.Return_issued_Book(L1, book_id);

                        } else if (mem_qn == 5) {
                            //Pay fine
                            logged_member.Pay_Fine();

                        } else if (mem_qn == 6) {
                            System.out.println("Going back");
                            break;

                        } else {
                            //error
                            System.out.println("Invalid command");
                        }
                    }
                }
            }

            else if (home_qn == 3) {
                System.out.println("""
                        Thanks for visiting!
                        ---------------------------------""");
                break;
            }

            else{
                System.out.println("Invalid command");
            }
        }
    }
}