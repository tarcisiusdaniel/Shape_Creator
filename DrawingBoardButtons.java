import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
/**
 * The button listener class.
 *
 * @author (Tarcisius Daniel Hartanto)
 * @version (Monday, October 23rd 2017)
 */
public class DrawingBoardButtons extends JTextArea implements ActionListener
{
    //instance variable
    private DrawingBoard db;
    private String clicked;
    private boolean tf;
    private Color c;
    
    //constructor
    /**
     * Construct object for DrawingBoardButtons class
     * @param db the drawing board
     */
    public DrawingBoardButtons(DrawingBoard db)
    {
        this.db = db;
    }
    //method
    /**
     * Process the button so it can be clicked and access an order
     * @param ae the event that is made from clicking the button
     */
    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getActionCommand( ).equals("Circle") ) 
        {
            clicked = "Circle";
            tf = true;
        } 
        else if (ae.getActionCommand( ).equals("Delta") ) 
        {
            clicked = "Delta"; 
            tf = true;
        } 
        else if (ae.getActionCommand( ).equals("Tee") ) 
        {
            clicked = "Tee";
            tf = true;
        }
        else if (ae.getActionCommand( ).equals("Select The Selected Shape") ) 
        {
            clicked = "Select";
            tf = false;
        }
        else if (ae.getActionCommand( ).equals("Remove The Selected Shape") ) 
        {
            db.removeSelected();
        }
        else if (ae.getActionCommand( ).equals("Remove All The Shape") ) 
        {
            db.clearAll();
        }
        else if (ae.getActionCommand( ).equals("Change Color") ) 
        {
            //print a message if there is no selected shape
            if (db.queryMethod() == null)
            {
                System.out.println("Oops sorry -- there is no selected shape yet.");
            }
            else if(db.queryMethod() != null)
            {
                c = JColorChooser.showDialog(null,"Choose one", db.queryMethod().getColor());
                db.changeColorSelected(c);
            }
        }
    }
    
    /**
     * Get the state of a drawing
     * @return the state
     */
    public boolean getTFState() {
        return tf;
    }

    /**
     * Get the name of the button that will be clicked
     * @return the name of the button
     */
    public  String getClicked() {
        return clicked;
    }
}
