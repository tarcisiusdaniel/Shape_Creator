import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
/**
 * Controller for the main program.
 *
 * @author (Tarcisius Daniel Hartanto)
 * @version (Monday, October 23rd 2017)
 */
public class DrawingBoardControl extends JPanel
{
    //instance variable
    private DrawingBoard db;
    
    //constructor
    /**
     * Construct object for DrawingBoardControl class
     * @param db the drawing board
     */
    public DrawingBoardControl(DrawingBoard db)
    {
        this.db = db;
        
        //set the layout for JPanel to BorderLayout
        setLayout(new BorderLayout());
        
        //create the graphics view(DrawingBoardGraphicView) so the shapes will be visible and put it on the center
        DrawingBoardGraphicView db_graph = new DrawingBoardGraphicView(db);
        this.add(db_graph, BorderLayout.CENTER);
        
        //create the text view of the drawing board's state(DrawingBoardStateJTextAreaView) and put it on the left-side
        DrawingBoardStateJTextAreaView db_textview = new DrawingBoardStateJTextAreaView(db);
        this.add(db_textview, BorderLayout.WEST);
        
        //create the text view of the drawing board's state(DrawingBoardStateView) and print it on the terminal window
        DrawingBoardStateView db_printview = new DrawingBoardStateView(db);
        
        //create the buttons to run the program and add it to the JPanel, put it on the top
        JButton circle = new JButton("Circle");
        JButton delta = new JButton("Delta");
        JButton tee = new JButton("Tee");
        JButton select = new JButton("Select The Selected Shape");
        JButton remove = new JButton("Remove The Selected Shape");
        JButton removeAll = new JButton("Remove All The Shape");
        JButton setColor = new JButton("Change Color");
        JPanel choice = new JPanel();
        choice.add(circle);
        choice.add(delta);
        choice.add(tee);
        choice.add(select);
        choice.add(remove);
        choice.add(removeAll);
        choice.add(setColor);
        this.add(choice, BorderLayout.NORTH);
        
        //create the button listener and connect it with all the buttons that have already been made
        DrawingBoardButtons db_buttons = new DrawingBoardButtons(db);
        circle.addActionListener(db_buttons);
        delta.addActionListener(db_buttons);
        tee.addActionListener(db_buttons);
        select.addActionListener(db_buttons);
        remove.addActionListener(db_buttons);
        removeAll.addActionListener(db_buttons);
        setColor.addActionListener(db_buttons);
        
        //create the mouse listener
        DrawingBoardMouse db_mouse = new DrawingBoardMouse(db_buttons,db);
        db_graph.addMouseListener(db_mouse);
        db_graph.addMouseMotionListener(db_mouse);
    }
}
