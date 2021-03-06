import javax.swing.*;
import java.awt.*;
import java.util.*;
/**
 * The class to represent the state of the Drawing Board and print it to the terminal window.
 *
 * @author (Tarcisius Daniel Hartanto)
 * @version (Monday, October 23rd 2017)
 */
public class DrawingBoardStateView extends JPanel implements DrawingBoardViewer
{
    //instance variable
    private DrawingBoard db ;
    
    /**
     * Construct an object for class DrawingBoardView
     * @param db the DrawingBoard that will be stored
     */
    public DrawingBoardStateView( DrawingBoard db )
    {
        this.db = db;
        this.db.addViewer(this);
    }
    
    /**
     * Make a representation of the changing state of the viewers list
     * This is also functions to notify the viewers as well
     */
    public void notifyAboutState()
    {
        //Make the representation of the current state of the drawing board on the JPanel
        //the number of shapes, the information following the selected shape will be shown
        String state = "";
        ArrayList<Shape> copy = db.copyDB();
        state += "Here is all the following information about the current state of the drawing board:";
        state += "\n    - Number of shapes : " + copy.size();
        if (copy.size() > 0 && copy.get(copy.size()-1).isSelected())
        {
            state += "\n    - There is a selected shape.";
            state += "\n      Here is the informations about it:";
            state += db.queryMethod().toString();
        }
        else
        {
            state += "\n    - There is no selected shape.\n\n";
        }
        
        //Print it on the terminal window
        System.out.println(state);
    }
}
