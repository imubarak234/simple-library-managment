
/**
 * Write a description of class Member here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Member
{
    private String iDNumber;
    private String name;
    private int numberOfBooks;
    
    public Member(String idnumber, String name, int number)
    {
        iDNumber = idnumber;
        this.name = name;
        numberOfBooks = number;
    }
    
    public Member(String idnumber, String name)
    {
        iDNumber = idnumber;
        this.name = name;
        numberOfBooks = 0;
    }
    
    public String getIDNumber()
    {
        return iDNumber;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getNumberOfBooks()
    {
        return numberOfBooks;
    }
    
    public void addBook(int book)
    {
        numberOfBooks += book;
    }
    
    public void removeBook(int remove)
    {
        numberOfBooks -= remove;
    }
    
    public String toString()
    {
        return iDNumber + " " + name + " " + numberOfBooks;
    }
    
    public String toString2()
    {
        return iDNumber + "#" + name + "#" + numberOfBooks;
    }
}
