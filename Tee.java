import java.awt.*;
import java.util.*;
/**
 * The class that functions to create a Tee shape.
 *
 * @author (Tarcisius Daniel Hartanto)
 * @version (Monday, October 23rd 2017)
 */
public class Tee extends AbstractShape
{
    //instance variable
    private int thick; //the thickness of a tee shape
    /**
     * Construct a new Tee Shape object
     * @param x the upper-left x-point of a Tee shape object
     * @param y the upper-left y-point of a Tee shape object
     * @param h the height of the Tee shape object
     * @param c the color of the Tee shape object
     * @throws IllegalArgumentException if the height is not a multiple of 10 or a negative number
     */
    public Tee (int x, int y, int h, Color c)
    {
        super(x, y, h, c);
        if (h%10 != 0 || h <= 0)
        throw new IllegalArgumentException ("The height must be a multiple of 10.");
        thick = h/5;
    }
    /**
     * Identify a point if it is on the Shape or not
     * @return true if the point is on the Shape
     * @return false if the point is not on the Shape
     */
    public boolean isOn(int x, int y)
    {
        //execute the code if the point is on the square
        if (super.isOn(x,y) == true)
        {
            //the code for identify the point (on the Tee or not)
            if((x < (super.getX()+(2*thick)) || x > (super.getX()+(3*thick))) && (y > (super.getY() + thick)))
            {
                return false;
            }
            else
            {
                return true;
            }
        }
        //return false if the point is not on the square
        else
        {
            return false;
        }
    }
    /**
     * Make a representation of a Shape's condition in String data type
     * @return state the state of a Shape
     */
    public String toString()
    {
       String state = "";

       state += "\n       ~ This is a Tee shape.";
       state += "\n" + super.toString();
       state += "\n       ~ The thickness is " + thick; 
       if (this.isSelected() == false )
       state += "\n       ~ The Tee is not selected yet.";
       else
       state += "\n       ~ The Tee is selected.\n\n";
       return state;
    }
    /**
     * Draw the shape on JPanel (Tee)
     * @param g graphics to draw the shape
     */
    public void paint(Graphics g) 
    {
        g.setColor(super.getColor());
        g.fillRect(super.getX(), super.getY(), super.getHeight(), super.getHeight() / 5);
        g.fillRect(super.getX() + super.getHeight() / 5 * 2, super.getY() + super.getHeight() / 5,
            super.getHeight() / 5, super.getHeight() / 5 * 4);

        if (super.isSelected()) 
        { 
            g.setColor(Color.BLACK);
            g.drawRect(super.getX(), super.getY(), super.getHeight(), super.getHeight() / 5);
            g.drawRect(super.getX() + super.getHeight() / 5 * 2, super.getY() + super.getHeight() / 5,
                super.getHeight() / 5, super.getHeight() / 5 * 4);
        }
    }
}
