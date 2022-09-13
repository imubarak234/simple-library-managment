
/**
 * Write a description of class Book here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Book
{
    private String bookNumber;
    private String author;
    private String title;
    private boolean borrowed;
    private String borrower;
    
    public Book(String books, String authors, String title, boolean borrowed, String borrows)
    {
        bookNumber = books;
        authors = author;
        this.title = title;
        this.borrowed = borrowed;
        borrower = borrows;
    }
    
    public Book(String books, String author, String title)
    {
        bookNumber = books;
        this.author = author;
        this.title = title;
        borrowed = false;
        borrower = "none";
    }
    
    public String getBookNumber()
    {
        return bookNumber;
    }
    
    public boolean isBorrowed()
    {
        return borrowed;
    }
    
    public String getBorrower()
    {
        return borrower;
    }
    
    public void setBorrowed(boolean wme)
    {
        borrowed = wme;
    }
    
    public void setBorrower(String next)
    {
        borrower = next;
    }
    
    public void borrowBook(String id)
    {
        borrower = id;
        borrowed = true;
    }
    
    public void returnBook()
    {
        borrower = "none";
        borrowed = false;
    }
    
    public String toString()
    {
        String ava;
        if(isBorrowed()){ava = "Unavailable";}
        else{ava = "Available";}
        return bookNumber + " " + author + " " + title + " " + ava;
    }
    
    public String toString2()
    {
        return bookNumber + "#" + author + "#" + title + " " + borrowed + " " + borrower;
    }
}
