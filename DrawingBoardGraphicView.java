import javax.swing.*;
import java.awt.*;
import java.util.*;
/**
 * Write a description of class DrawingBoardGraphicView here.
 *
 * @author (Tarcisius Daniel Hartanto)
 * @version (Monday, October 23rd 2017)
 */
public class DrawingBoardGraphicView extends JPanel implements DrawingBoardViewer
{
    //instance variable
    private DrawingBoard db;
    
    /**
     * Construct object for DrawingBoardGraphicView class
     */
    public DrawingBoardGraphicView(DrawingBoard db)
    {
        super();
        //make the size for the program
        this.setPreferredSize(new Dimension(500,500));
        this.db = db;
        this.db.addViewer(this);
    }
    
    /**
     * Notify the viewers about a certain change of the state
     */
    public void notifyAboutState()
    {
        //notify update using repaint() method
        this.repaint();
    }
    
    /**
     * Method to do a repaint
     * @param g graphics
     */
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        //make the background for the main program
        Rectangle rect = getBounds(); 
        g.setColor(Color.RED);
        g.fillRect(0, 0, rect.width, rect.height);
        
        //draw the shapes on the program
        ArrayList<Shape> copy = db.copyDB();
        for (int i=0; i<copy.size(); i++)
        {
            copy.get(i).paint(g);
        }
        this.requestFocus();
    }
}
