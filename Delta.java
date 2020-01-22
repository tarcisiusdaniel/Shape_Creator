import java.awt.*;
import java.util.*;
/**
 * The class that functions to create a Delta shape.
 *
 * @author (Tarcisius Daniel Hartanto)
 * @version (Monday, October 23rd 2017)
 */
public class Delta extends AbstractShape
{  
    /**
     * Construct a Delta shape object
     * @param x the x-point of the top of the Delta shape
     * @param y the y-point of the top of the Delta shape
     * @param h the height of the Delta shape
     * @param c the color of the Delta shape
     * @throw IllegalArgumentException if the number is odd or a negative number
     */
    public Delta(int x, int y, int h, Color c)
    {
        super(x-(h/2), y, h, c);
        if (h%2 != 0 || h <= 0)
            throw new IllegalArgumentException("It must be an even number or greater than 0.");
    }
    /**
     * Identify a point if it is on the Shape or not
     * @return true if the point is on the Shape
     */
    public boolean isOn(int x, int y)
    {
        //execute the code if the point is on the square
        if(super.isOn(x,y) == true)
        {
            int top_x = super.getX() + (super.getHeight()/2); //apex x-point of the Delta
            int top_y = super.getY(); //apex y-point of the Delta
            if (y < top_y || y > (top_y + super.getHeight()))
            {
                return false;
            }
            int distance = y - top_y; //the distance from the apex to the bottom of the Delta
            if (x > top_x + (distance/2) || x < top_x - (distance/2))
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

       state += "\n       ~ This is a Delta shape."; 
       state += "\n" + super.toString();
       state += "\n       ~ The apex point is (" + (super.getX()+(super.getHeight()/2)) + "," +
                (super.getY()) + ").";
       if (this.isSelected() == false )
       state += "\n       ~ The Delta is not selected yet.";
       else
       state += "\n       ~ The Delta is selected.\n\n";
       return state;
    }
    /**
     * Draw the shape on JPanel (Delta)
     * @param g graphics to draw the shape
     */
    public void paint(Graphics g)
    {
        g.setColor(super.getColor());
        int[] x = new int[]{super.getX() + super.getHeight()/2, super.getX(), super.getX() + super.getHeight()};
        int[] y = new int[]{super.getY(), super.getY() + super.getHeight(), super.getY() + super.getHeight()};
        g.fillPolygon(x, y, 3);
        if (super.isSelected())
        {
            g.setColor(Color.BLACK);
            g.drawPolygon(x, y, 3);
        }
    }
}
