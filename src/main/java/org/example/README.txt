Java Library Management System

A Java console-based library management system that can be used by both librarian and members. The interface allows the
librarians to manage library operations such as member management, book management and fine collection. It allows members
to view, issue and return books as well as pay fines.

## Features

- Librarian Functions:
  - Register a new member
  - Remove a member
  - Add a book to the library
  - Remove a book from the library
  - View all members along with their books and fines
  - View all books

- Member Functions:
  - List available books
  - List books borrowed by the member
  - Issue a book
  - Return a borrowed book
  - Pay fines

## How to Use

1. Start the application.

2. Choose your role:
   - Enter as a librarian. (Enter 1)
   - Enter as a member. (Enter 2)
   - Exit (Enter 3)

### Librarian

- Register a Member:
  Enter the member's name, age, and phone number.
  name and phone number are string inputs and age is an integer input.
  phone number can be any unique string (it is only used to identify unique member)

- Remove a Member:
  Enter the member's ID to remove them from the system.
  ID should be an integer input.

- Add a Book:
  Enter string input book title, string input author, and the number of copies as integer input.
  Each book will be provided a unique ID.

- Remove a Book:
  Enter the book's ID (integer input) to remove it from the library.

- View all Members:
  Displays a list of all registered members.
  Displays their name, age, issued books and due fine.
  The fine is updated as and when the function is called.

- View all Books:
  Displays a list of available books in the library under "Available books"
  Displays a list of issued books under "Issued books"

### Member

Takes member name and phone number in string input format.
If, an object having same attributes as input name and number exists in Member class, enter as member.
Else, takes back to home page.

- List Available Books:
  Displays a list of books available for borrowing.
  It hides books issued by various members.

- List My Books:
  Displays the books currently borrowed by the member.

- Issue a Book:
  Enter the book's ID (integer input) to borrow it.
  Book can only be issued if 2 books aren't already issued.
  Book can only be issued if no fine is due.

- Return a Book:
  Enter the book's ID (integer input) to return it.

- Pay Fines:
  Displays how much fine was paid.
  Pay any fines accrued for late returns.
  Fine is calculated once book has been issued for more than 10 days (seconds)
  Fine payment for issued books which aren't returned cannot be paid.