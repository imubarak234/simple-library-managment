import java.io.*;
import java.util.*;
/**
 * Write a description of class Tester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tester
{
    //private static Library lib; 
    //private static Scanner lolz = new Scanner(System.in);
    public static void main(String [] args) throws IOException
    {
        BufferedReader lolz = new BufferedReader(new InputStreamReader(System.in));
        //Scanner lolz = new Scanner(System.in);
        Library lib = new Library();
        
        System.out.println("Enter member id number");
        String smt = lolz.readLine();
        System.out.println("Enter name");
        String byc = lolz.readLine();
        System.out.println("first: " + lib.findMember(smt.trim()));
        Member mem = new Member(smt.trim(), byc.trim());
        lib.addMember(mem);
        System.out.println("after: " + lib.findMember(smt.trim()));
        
        System.out.println("Enter member id number");
        String smt2 = lolz.readLine();
        System.out.println("Enter name");
        String byc2 = lolz.readLine();
        System.out.println("second: " + lib.findMember(smt2.trim()));
        Member mem2 = new Member(smt2.trim(), byc2.trim());
        lib.addMember(mem2);
        System.out.println("after: " + lib.findMember(smt2.trim()));
        
        System.out.println("Enter member id number");
        String smt3 = lolz.readLine();
        System.out.println("Enter name");
        String byc3 = lolz.readLine();
        System.out.println("third: " + lib.findMember(smt3.trim()));
        Member mem3 = new Member(smt3.trim(), byc3.trim());
        lib.addMember(mem3);
        System.out.println("after: " + lib.findMember(smt3.trim()));
        
        System.out.println("Enter member id number");
        String smt4 = lolz.readLine();
        System.out.println("Enter name");
        String byc4 = lolz.readLine();
        System.out.println("four: " + lib.findMember(smt4.trim()));
        Member mem4 = new Member(smt4.trim(), byc4.trim());
        lib.addMember(mem4);
        System.out.println("after: " + lib.findMember(smt4.trim()));
        
        lib.listMembers();
        System.out.println("after: " + lib.findMember(smt4.trim()));
        System.out.println("after: " + lib.findMember(smt3.trim()));
        System.out.println("after: " + lib.findMember(smt2.trim()));
    }
}
