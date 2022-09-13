import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.util.*;
import java.io.*;

/**
 * Write a description of class Library_GUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Library_GUI
{
    private Library lime;
    private JFrame frames = new JFrame("Library Check");
    
    Container conts = frames.getContentPane();
    
    JLabel west = new JLabel(new ImageIcon("LIBRARY.jpg"));
    JPanel pane = new JPanel();
    JPanel east = new JPanel();
    private JTextArea text = new JTextArea();
    private JScrollPane scroll = new JScrollPane(text);
    
    private JButton clearButton = new JButton("Clear");
    private JButton addBookButton = new JButton("Add Book");
    private JButton addMemberButton = new JButton("Add Member");
    private JButton borrowButton = new JButton("Borrow Book");
    private JButton returnButton = new JButton("Return Book");
    private JButton searchBookButton = new JButton("Search for book");
    private JButton searchMemberButton = new JButton("Search for member");
    
    public Library_GUI() throws IOException
    {
        lime = new Library();
        frames.setSize(1000, 1000);
        
        makeMenuBar();
        
        conts.setLayout(new BorderLayout());
        conts.add(west, BorderLayout.WEST);
        conts.add(scroll, BorderLayout.EAST);
        conts.add(pane, BorderLayout.SOUTH);
        // conts.add(east, BorderLayout.EAST);
        pane.setLayout(new BorderLayout());
        pane.add(clearButton);
        pane.add(searchBookButton);
        pane.add(searchMemberButton);
        // east.setLayout(new FlowLayout());
        // east.add(borrowButton);
        // east.add(returnButton);
        // east.setVisible(true);
        
        west.setLayout(new FlowLayout());
        west.add(addBookButton);
        west.add(addMemberButton);
        west.add(borrowButton, FlowLayout.CENTER);
        west.add(returnButton, FlowLayout.CENTER);
        
        scroll.setVisible(true);
        frames.pack();
        frames.setVisible(true);
        text.setVisible(true);
        //clearButton
        frames.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        clearButton.addActionListener(new clearHandler());
        addBookButton.addActionListener(new addBookHandler());
        addMemberButton.addActionListener(new addHandler());
        borrowButton.addActionListener(new borrowHandler());
        returnButton.addActionListener(new returnHandler());
        
        
    }
    
    private void makeMenuBar()
    {
        JMenuBar menu = new JMenuBar();
        menu.setVisible(true);
        frames.setJMenuBar(menu);
        
        JMenu lists = new JMenu("Lists");
        menu.add(lists);
        
        JMenuItem books = new JMenuItem("List books in records");
        lists.add(books);
        books.addActionListener(new listBookHandler());
        
        JMenuItem member = new JMenuItem("List all members");
        lists.add(member);
        member.addActionListener(new listMemberHandler());
    }
    
    private class addHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String id = JOptionPane.showInputDialog(null, "Enter member id number: ");
            String name = JOptionPane.showInputDialog(null, "Enter Name:  ");
            
            Member mem = new Member(id.trim(), name.trim());
            if(lime.findMember(mem) == -1)
            {
                if((lime.findMember(id.trim())) == -1)
                {
                    lime.addMember(mem);
                }
                else{JOptionPane.showMessageDialog(null, "ERROR: A member with this ID number already exists");}
            }
            JOptionPane.showMessageDialog(null, "Member added");
        }
    }
    
    private class listMemberHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            text.setText(lime.listMembers());
        }
    }
    
    private class addBookHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String numb = JOptionPane.showInputDialog(null, "Enter book number:  ");
            String auth = JOptionPane.showInputDialog(null, "Enter author of book:  ");
            String tit = JOptionPane.showInputDialog(null, "Enter title:  ");
            
                Book dm = new Book(numb, auth, tit);
            
            if(lime.findBook(dm) == -1)
            {
                if(lime.findBook(numb) == -1)
                {
                    lime.addBook(dm);
                }
                else{JOptionPane.showMessageDialog(null, "ERROR: A member with this ID number already exists");}
            }
            JOptionPane.showMessageDialog(null, "Book added");
        }
    }
    
    private class listBookHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            text.setText(lime.listBooks());
        }
    }
    
    private class borrowHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String numb = JOptionPane.showInputDialog(null, "Enter book number:  ");
            String id = JOptionPane.showInputDialog(null, "Enter member id number:  ");
            
            if((lime.findBook(numb) != -1) && (lime.findMember(id) != -1) && 
            (!lime.isBorrowed(lime.findBook(numb))) && 
            ((lime.getMember(lime.findMember(id)).getNumberOfBooks()) < 3) )
            {
                lime.borrowBook(lime.getBook(lime.findBook(numb)), lime.getMember(lime.findMember(id)));
            }
            else{JOptionPane.showMessageDialog(null, "Book cannot be borrowed");}
        }
    }
    
    private class returnHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String numb = JOptionPane.showInputDialog(null, "Enter book number:  ");
            String id = JOptionPane.showInputDialog(null, "Enter member id number:  ");
            
            if((lime.findBook(numb) != -1) && (lime.findMember(id) != -1) &&
            (lime.isBorrowed(lime.findBook(numb))))
            {
                lime.returnBook(lime.getBook(lime.findBook(numb)), lime.getMember(lime.findMember(id)));
            }
            else{JOptionPane.showMessageDialog(null, "Book cannot be returned");}
        }
    }
    
    private class clearHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            text.setText("");
        }
    }

}
