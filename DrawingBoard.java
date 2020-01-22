import java.awt.*;
import java.util.ArrayList;
import java.awt.Color;

/**
 * The class that is used to keep track of list of Shapes.
 *
 * @author (Tarcisius Daniel Hartanto)
 * @version (Monday, October 23rd 2017)
 */
public class DrawingBoard
{
    //instance variable
    private ArrayList<Shape> los = new ArrayList<Shape>();//the ArrayList to store the AbstractShape objects
    private ArrayList<DrawingBoardViewer> viewers = new ArrayList<DrawingBoardViewer>(); //The ArrayList to store the list of viewers
    
    //named constants
    public static final String WARNING = "There are no selected shape."; //the sentence for IllegalStateException
    /**
     * Construct a DrawingBoard object
     */
    public DrawingBoard()
    {
        this.los = los;
        this.viewers = viewers;
    }
    
    /**
     * Add an AbstractShape object to the DrawingBoard
     * Change the AbstractShape object to become deselected
     * @param shape the AbstractShape object that will be added
     */
    public void addShape(Shape shape)
    {
        //add the shape and make it as the selected shape
        los.add(shape);
        shape.setSelected(true);
        //make all the other shape to be deselected (except the newly selected shape)
        if (los.size() > 1)
        {   
            los.get(los.size()-2).setSelected(false);
        }
        notifyViewers();
    }
    
    /**
     * Make the topmost Shape that has the x and y point (in the parameter) on it 
     * as the selected shape
     * @param x the x point that will be identified
     * @param y the y point that will be identified
     */
    public void topmostShape(int x, int y)
    {
        //make all the specifier 
        boolean tm = true;
        int start = los.size()-1;
        //make all AbstractShape object inside the DrawingBoard to be deselected
        for (int i=0; i<los.size(); i++)
        {
            los.get(i).setSelected(false);
        }
        //start the identifying process, begins from the top of the ArrayList
        while( tm && start >= 0)
        {
            if(los.get(start).isOn(x,y) == true)
            {
                //if found, select the Shape and put the Shape at the end of the DrawingBoard
                tm = false;
                los.get(start).setSelected(true);
                Shape store = los.get(start);
                los.remove(los.get(start));
                los.add(store);
            }
            start--;
        }
        notifyViewers();
    }
    
    /**
     * Select the selected shape and make a reference of it
     * @return null if all the shapes is not selected
     * @return the selected shape
     */
    public Shape queryMethod()
    {
        int start = 0;
        boolean spec = true;
        int theSelect = 0;
        //while loop to get the index of the selected shape inside a DrawingBoard
        while(start < los.size() && spec)
        {
            if(los.get(start).isSelected() == true)
            {
                spec = false;
                theSelect = los.indexOf(los.get(start));
            }
            start++;
        }
        //if statement to return the selected shape, return null if there is no selected shape
        if(spec)
        {
            return null;
        }
        else
        {
            return los.get(theSelect);
        }
    }
    
    /**
     * Remove the selected shape
     * @throws IllegalStateException if there is no selected shape
     */
    public void removeSelected()
    {
        
        if(queryMethod() == null)
        {   
            System.out.println("Oops sorry -- there is no selected shape yet.");
        }
        else if (queryMethod() != null)
        {
            los.remove(queryMethod());
            if(los.size() > 0)
            {
                los.get(los.size()-1).setSelected(true);
            }
        }
            
        notifyViewers();
    }
    
    /**
     * Change the color of the selected shape
     * @param c the color that will be changed to
     * @throws IllegalStateException if there is no selected shape
     */
    public void changeColorSelected(Color c)
    {
        if (queryMethod() == null)
        {
            throw new IllegalStateException(WARNING);
        }
        else if(queryMethod() != null)
        {
            this.queryMethod().setColor(c);
            notifyViewers();
        }
    }
    
    /**
     * Change the upper left point of the selected shape
     * @param changeInX the range in x-coordinates that will be moved
     * @param changeInY the range in y-coordinates that will be moved
     * @throws IllegalStateException if there is no selected shape
     */
    public void ChangePointSelected(int changeInX, int changeInY)
    {
        if (queryMethod() == null)
        throw new IllegalStateException(WARNING);
        this.queryMethod().shiftUpperLeftBy(changeInX, changeInY);
        notifyViewers();
    }
    
    /**
     * Make a copy of the ArrayList of AbstractShape in a DrawingBoard object
     * @return copy the copy of the ArrayList of AbstractShape in a DrawingBoard object
     */
    public ArrayList<Shape> copyDB ()
    {
        //make a new ArrayList of AbstractShape object, then copy the ArrayList from the DrawingBoard
        ArrayList<Shape> copy = los;
        return copy;
    }
    
    /**
     * Add viewers to a DrawingBoard object
     * @param dbv the viewer
     */
    public void addViewer( DrawingBoardViewer dbv )
    {
        if (dbv != null)
        {
            viewers.add(dbv);
            dbv.notifyAboutState();
        }
    }
    
    /**
     * Notify all viewers if there is anything changed in the viewers list
     */
    private void notifyViewers()
    {
        for (int i=0; i<viewers.size(); i++)
        {
            viewers.get(i).notifyAboutState();
        }
    }
    
    /**
     * Clear the drawing board list, all shapes will be removed
     */
    public void clearAll()
    {
        for (int i=los.size()-1; i>=0; i--)
        {
            los.remove(i);
        }
        
        notifyViewers();
    }
}
