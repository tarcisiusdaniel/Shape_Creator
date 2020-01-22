import java.awt.*;
import java.util.*;
/**
 * The class that functions to create a Circle shape.
 *
 * @author (Tarcisius Daniel Hartanto)
 * @version (Monday, October 23rd 2017)
 */
public class Circle extends AbstractShape
{
    /**
     * Construct a Circle Shape object
     * @param x the x-point that stands as the center of the Circle
     * @param y the y-point that stands as the center of the Circle
     * @param r the radius of the Circle
     * @param c the color of the Circle
     * @throws IllegalArgumentException if r is less than 0 or a negative number
     */
    public Circle (int x, int y, int r, Color c)
    {
        super(x-r, y-r, r*2, c);
        if (r <= 0)
        throw new IllegalArgumentException ("r must be greater than 0");
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
            int center_x = super.getX() + (super.getHeight() / 2);//get the center x-point
            int center_y = super.getY() + (super.getHeight() / 2);//get the center y-point
            int range_x = x - center_x;//get the range between the center and the value of the passed-in x
            int range_y = y - center_y;//get the range between the center and the value of the passed-in y
            int test = ((range_x*range_x)+(range_y*range_y));//the sum of both range_x square and range_y square
            int test1 = (super.getHeight()/2)*(super.getHeight()/2);//the square of th radius
            //testing with the rule of phytagoras law
            if(test > test1)
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
       //make the representation of a Circle object
       String state = "";
       state += "\n       ~ This is a Circle shape.";
       state += "\n" + super.toString();
       state += "\n       ~ The radius is " + (super.getHeight()/2) + ".";
       state += "\n       ~ The center is (" + (super.getX()+super.getHeight()/2) + "," +
                (super.getY()+super.getHeight()/2) + ").";
       
       if (this.isSelected() == false )
       state += "\n       ~ The Circle is not selected yet.";
       else
       state += "\n       ~ The Circle is selected.\n\n";
       return state;
    }
    /**
     * Draw the shape on JPanel (Circle)
     * @param g graphics to draw the shape
     */
    public void paint(Graphics g)
    {
        g.setColor(super.getColor());
        g.fillOval(super.getX(), super.getY(), super.getHeight(), super.getHeight());
        if (super.isSelected())
        {
            g.setColor(Color.BLACK);
            g.drawOval(super.getX(), super.getY(), super.getHeight(), super.getHeight());
        }
    }
}
