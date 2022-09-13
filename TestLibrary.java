import java.util.*;
import java.io.*;
/**
 * Write a description of class TestLibrary here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TestLibrary
{
    private static Scanner lolz = new Scanner(System.in);
    private static Library ace;
    public static void main(String [] args) throws IOException
    {
        ace = new Library();
        int choice = showMenu();
        
        while (choice != 0)
        {
            if(choice == 1){addMember();}
            else if(choice == 2){listMembers();}
            else if(choice == 3){addBook();}
            else if(choice == 4){listBooks();}
            else if(choice == 5){borrowBook();}
            else if(choice == 6){returnBook();}
            else if(choice == 7)
            {
                saveAndExit();
                break;
            }
            choice = showMenu();
        }
        System.out.println("The content of the registerd books and members" +
        " have been save in a file and the programme terminated");
    }
    
    private static int showMenu()
    {
        System.out.println("Library System");
        System.out.println("====================");
        System.out.println("\n1      Add new Member");
        System.out.println("2      List all Members");
        System.out.println("3      Add new Book");
        System.out.println("4      List all Books");
        System.out.println("5      Borrow a Book");
        System.out.println("6      Return a book");
        System.out.println("7      Exit");
        
        System.out.print("\nEnter your choice:");
        int option = lolz.nextInt();
        lolz.nextLine();
        return option;
    }
    
    private static void addMember()
    {
        System.out.println("Enter member id number");
        String smt = lolz.nextLine();
        System.out.println("Enter name");
        String byc = lolz.nextLine();
        
        Member mem = new Member(smt.trim(), byc.trim());
        if(ace.findMember(mem) == -1)
        {
            if((ace.findMember(smt.trim())) == -1)
            {
                ace.addMember(mem);
            }
            else{System.out.println("ERROR: A member with this ID number already exists");}
        }
    }
    
    private static void listMembers()
    {
        System.out.println(ace.listMembers());
    }
    
    private static void addBook()
    {
        System.out.println("Enter book number: ");
        String net = lolz.nextLine();
        System.out.println("Enter the author of the book: ");
        String next = lolz.nextLine();
        System.out.println("Enter the title of the book: ");
        String ups = lolz.nextLine();
        
        Book dm = new Book(net, next, ups);
        
        if(ace.findBook(dm) == -1)
        {
            if(ace.findBook(net) == -1)
            {
                ace.addBook(dm);
            }
            else{System.out.println("ERROR: A book with this book number already exists");}
        }
    }
    
    private static void listBooks()
    {
        System.out.println(ace.listBooks());
    }
    
    private static void borrowBook()
    {
        System.out.println("Enter book number: ");
        String neat = lolz.nextLine();
        System.out.println("Enter member ID number");
        String zest = lolz.nextLine();
        
        if((ace.findBook(neat) != -1) && (ace.findMember(zest) != -1) && 
        (!ace.isBorrowed(ace.findBook(neat))) && 
        ((ace.getMember(ace.findMember(zest)).getNumberOfBooks()) < 3) )
        {
            ace.borrowBook(ace.getBook(ace.findBook(neat)), ace.getMember(ace.findMember(zest)));
        }
        else{System.out.println("Book cannot be borrowed");}
    }
    
    public static void returnBook()
    {
        System.out.println("Enter book number: ");
        String neat = lolz.nextLine();
        System.out.println("Enter member ID number");
        String zest = lolz.nextLine();
        
        if((ace.findBook(neat) != -1) && (ace.findMember(zest) != -1) &&
        (ace.isBorrowed(ace.findBook(neat))))
        {
            ace.returnBook(ace.getBook(ace.findBook(neat)), ace.getMember(ace.findMember(zest)));
        }
        else{System.out.println("Book cannot be returned");}
    }
    
    public static void saveAndExit()
    {
         ace.saveBooks();
         ace.saveMembers();
    }
}
