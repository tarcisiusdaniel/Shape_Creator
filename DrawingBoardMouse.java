import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
/**
 * The mouse listener class.
 *
 * @author (Tarcisius Daniel Hartanto)
 * @version (Monday, October 23rd 2017)
 */
public class DrawingBoardMouse implements MouseListener, MouseMotionListener
{
    private DrawingBoard db;
    private Random r;
    private DrawingBoardButtons buttons;
    //tee_1 and tee_2 will be used to make sure that the Tee's height will always be multiple of 10
    private int tee_1;
    private int tee_2;
    //mouse coordinates
    private int x,y,X,Y;
    private boolean drag;
    
    //constructor
    /**
     * Construct object for DrawingBoardMouse class
     * @param buttons the button that will be used by this object
     * Qparam db the drawing board
     */
    public DrawingBoardMouse (DrawingBoardButtons buttons, DrawingBoard db)
    {
        super();
        this.db = db;
        this.buttons = buttons;
        r = new Random();
        x = 0;
        y = 0;
        X = 0;
        Y = 0;
    }
    
    //Here are the following method that has to be added when a class implement MouseListener class
    //All these methods are responsible for all events that will be occured by using the mouse
    /**
     * Process mouse click on a button
     * @param e the mouse click event
     */
    public void mousePressed( MouseEvent me )
    {
        //update the location of the cursor
        x=X;
        y=Y;
        X=me.getX();
        Y=me.getY();
        if(buttons.getTFState()) //executed if the button's state is true
        {
            //the heights for all shape will be plus by 10 automaticly
            //this will make all shape to be visible (not visible if the height is 0)
            if(buttons.getClicked().equals("Circle"))
            {
                db.addShape(new Circle(X, Y, r.nextInt(60)+20, new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255))));
            }
            else if (buttons.getClicked().equals("Delta")) {
                db.addShape(new Delta(X, Y, r.nextInt(100 / 2) * 2 + 20, new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255))));
            }
            else if (buttons.getClicked().equals("Tee")) {
                tee_1 = r.nextInt(100);
                tee_2 = 10 - (tee_1 % 10);
                db.addShape(new Tee(X, Y, tee_1 + tee_2 + 10, new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255))));
            }
        }
        else if (buttons.getTFState() == false) //executed if the button's state is false
        {
            if (buttons.getClicked().equals("Select"))
            {
                db.topmostShape(me.getX(), me.getY());
            }
        }
    }
 
    public void mouseEntered(MouseEvent me) 
    {
        //update the location of the cursor        
        x = X;
        y = Y;
        X = me.getX( );
        Y = me.getY( );
    }

    public void mouseExited(MouseEvent me) 
    {
        //update the location of the cursor
        x = X;
        y = Y;
        X = me.getX( );
        Y = me.getY( );
    }

    public void mouseClicked(MouseEvent me) 
    {
        //update the location of the cursor
        x = X;
        y = Y;
        X = me.getX( );
        Y = me.getY( );        
    }

    public void mouseReleased(MouseEvent me) 
    {
        //update the location of the cursor
        x = X;
        y = Y;
        X = me.getX( );
        Y = me.getY( );        
    }
    
    //Here are the following method that are declared in MouseMotionListener class
    public void mouseDragged( MouseEvent me ) 
    {
        if (buttons.getTFState() == false) 
        {
            x = X;
            y = Y;
            X = me.getX();
            Y = me.getY();

            if (db.queryMethod() != null) 
            { 
                db.ChangePointSelected(X - x, Y - y);
            }
        }
    }
 
    public void mouseMoved(MouseEvent me) {
        //update the location of the cursor
        x = X;
        y = Y;
        X = me.getX( );
        Y = me.getY( );
    }
}
