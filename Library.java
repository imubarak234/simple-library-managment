import java.io.*;
import java.util.*;
/**
 * Write a description of class Library here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Library
{
    private Book[] books = new Book[20];
    private Member[] members = new Member[20];
    private int numberOfBooks;
    private int numberOfMembers;
    private BufferedReader ins = new BufferedReader(new FileReader("books.txt"));
    private BufferedReader wtf = new BufferedReader(new FileReader("members.txt"));
    private PrintWriter outs = new PrintWriter(new FileWriter("books.txt"));
    private PrintWriter lol = new PrintWriter(new FileWriter("members.txt"));
    public Library() throws IOException
    {
        
        String semi, circle;
        StringTokenizer next, level;
        int count1 = 0, count2 = 0;
        while((semi = ins.readLine()) != null)
        {
            next = new StringTokenizer(semi, "#");
            
            String first = next.nextToken().trim();
            String second = next.nextToken().trim();
            String third = next.nextToken().trim();
            boolean fourth = Boolean.parseBoolean(next.nextToken().trim());
            String fifth = next.nextToken().trim();
            
            books[count1] = new Book(first, second, third, fourth, fifth);
            count1++;
        }
        
        while((circle = wtf.readLine()) != null)
        {
            level = new StringTokenizer(circle);
            
            String first = level.nextToken().trim();
            String second = level.nextToken().trim();
            int third = Integer.parseInt(level.nextToken().trim());
            
            members[count2] = new Member(first, second, third);
            count2++;
        }
    }
    
    public Book getBook(int index)
    {
        if(books[index] != null){return books[index];}
        else{return null;}
    }
    
    public Member getMember(int index)
    {
        if(members[index] != null){return members[index];}
        else{return null;}
    }
    
    public boolean isBorrowed(int index)
    {
        if(books[index] != null){return books[index].isBorrowed();}
        else{return false;}
    }
   
    public void addBook(Book boo)
    {
            for(int xy = 0; xy < books.length; xy++)
            {
                if(books[xy] == null)
                {
                    books[xy] = boo;      
                    break;
                }
            }
    }
    
    public void addMember(Member mems)
    {
        for(int xy = 0; xy < members.length; xy++)
        {
            if(members[xy] == null)
            {
                members[xy] = mems;
                break;
            }
        }
    }
    
    public int findBook(String nums)
    {
        int eigh = -1;
        for(int x = 0; x < books.length; x++)
        {
            if((books[x] != null) && (books[x].getBookNumber().equalsIgnoreCase(nums)))
            {
                eigh = x;
                break;
            }
        }
        return eigh;
    }
    
    public int findBook(Book boom)
    {
        int next = -1;
        for(int y = 0; y < books.length; y++)
        {
            if(books[y] == boom)
            {
                next = y;
                break;
            }
        }
        return next;
    }
    
    public int findMember(String id)
    {
        int neno = -1;
        for(int xy = 0; xy < members.length; xy++)
        {
            if((members[xy] != null)  && (members[xy].getIDNumber().equalsIgnoreCase(id)))
            {
                neno = xy;
                break;
            }
        }
        return neno; 
    }
    
    public int findMember(Member memes)
    {
        int mean = -1;
        for(int xx = 0; xx < members.length; xx++)
        {
            if(members[xx] == memes)
            {
                mean = xx;
                break;
            }
        }
        return mean;
    }
    
    public void borrowBook(Book boy, Member girl)
    {
        for(int x = 0; x < books.length; x++)
        {
            if(books[x] == boy)
            {
                books[x].borrowBook(girl.getIDNumber());
            }
        }
        
        for(int xy = 0; xy < members.length; xy++)
        {
            if(members[xy] == girl)
            {
                members[xy].addBook(1);
            }
        }
    }
    
    public void returnBook(Book belt, Member shirt)
    {
        for(int x = 0; x < books.length; x++)
        {
            if(books[x] == belt)
            {
                books[x].returnBook();
            }
        }
        
        for(int xy = 0; xy < members.length; xy++)
        {
            if(members[xy] == shirt)
            {
                members[xy].removeBook(1);
            }
        }
    }
    
    public String listBooks()
    {
        String mean = "";
        for(int xy = 0; xy < books.length; xy++)
        {
            if(books[xy] != null)
            {
                mean += books[xy].toString() + "\n";
            }
        }
        return mean;
    }
    
    public String listMembers()
    {
        String milk = "";
        for(int xx = 0; xx < members.length; xx++)
        {
            if(members[xx] != null)
            {
                milk += members[xx].toString() + "\n";
            }
        }
        return milk;
    }
    
    public void saveBooks()
    {
        for(int x = 0; x < books.length; x++)
        {
            if(books[x] != null)
            {
                outs.println(books[x].toString2());
            } 
        }
        outs.close();
    }
    
    public void saveMembers()
    {
        for(int xyz = 0; xyz < members.length; xyz++)
        {
            if(members[xyz] != null)
            {
                lol.println(members[xyz].toString2());
            }
        }
        lol.close();
    }
    
    // public static void main(String [] args)
    // {
        // int[] test = new int[10];
        // test[0] = 12;
        // test[1] = 13;
        // test[2] = 14;
        // test[3] = 15;
        // test[4] = 16;
        // test[5] = 17;
        
        // Member[] test2 = new Member[5];
        // test2[0] = new Member("67755", "mubarak", 2);
        // test2[1] = new Member("68795", "ibrahim", 5);
        // test2[3] = new Member("75849", "mohammed", 10);
        // for(int i = 0; i < test.length; i++)
        // {
            // System.out.println(test[i]);
        // }
        
        // for(int x = 0; x < test.length; x++)
        // {
            // if(test2[x] == null)
            // {
                // System.out.println("whats up");
                // break;
            // }
        // }
    // }
}
