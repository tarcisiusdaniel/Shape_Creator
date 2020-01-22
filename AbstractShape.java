import java.awt.*;
/**
 * The main class of AbtractShape program
 *
 * @author (Tarcisius Daniel Hartanto)
 * @version (Monday, October 23rd 2017)
 */
public abstract class AbstractShape implements Shape
{
    // instance variables
    private int x, y, height; // the upper-left x and y point AND the height of the shape
    private Color color; // the color of the shape
    private boolean tf; // the specifier of the shape (selected or deselected)
    
    /**
     * Construct an AbstractShape object
     * @param x the upper-left x point
     * @param y the upper-left y point
     * @param h the height of the object
     */
    public AbstractShape(int x, int y, int h, Color c)
    {
        this.x = x;
        this.y = y;
        height = h;
        color = c;
        tf = false;
    }
    
    /**
     * Identify a point if it is on a shape or not
     * @param x the x-point that will be identified
     * @param y the y-point that will be identified
     * @return true/false depends on the point (if it is on the shape or not)
     */
    public boolean isOn(int x, int y)
    {
        //make sure that the point is in the square
        if(x < this.x || x > (this.x + this.height))
        {
            return false;
        }
        if(y < this.y || y > (this.y + this.height))
        {
            return false;
        }
        return true;
    }
    //here are the following get and set methods for this class
    /**
     * Identify a Shape if it selected or deselected
     * @return tf true if the Shape is selected, false if not
     */
    public boolean isSelected()
    {
        return this.tf;
    }
    
    /**
     * Set a Shape to be selected(true) or deselected(false)
     * @param b the condition (selected or deselected) that the user decides
     */
    public void setSelected(boolean b)
    {
        this.tf = b;
    }
    
    /**
     * Set a new color for a Shape
     * @param c the new color
     */
    public void setColor(Color c)
    {
        color = c;
    }
    
    /**
     * Set a new x-point for a Shape
     * @param x the new x-point
     */
    public void setX(int x)
    {
        this.x = x;
    }
    
    /**
     * Set a new y-point for a Shape
     * @param y the new y-point
     */
    public void setY(int y)
    {
        this.y = y;
    }
    
    /**
     * Set a new height for a Shape
     * @param h the new height
     */
    public void setHeight(int h)
    {
        height = h;
    }
    
    /**
     * Get the x-point of a Shape
     * @return x the current x-point
     */
    public int getX()
    {
        return this.x;
    }
    
    /**
     * Get the y-point of a Shape
     * @return y the current y-point
     */
    public int getY()
    {
        return this.y;
    }
    
    /**
     * Get the height of a Shape
     * @return height the current height
     */
    public int getHeight()
    {
        return this.height;
    }
    
    /**
     * Get the Color of a Shape
     * @return color the current color
     */
    public Color getColor()
    {
        return this.color;
    }
    
    /**
     * Shift the upper left point of a Shape
     * @param deltaX the range to move the x-point
     * @param deltaY the range to move the y-point
     */
    public void shiftUpperLeftBy(int deltaX, int deltaY)
    {
        this.x += deltaX;
        this.y += deltaY;
    }
    
    /**
     * Replace the upper left point of Shape with a new one
     * @param newX the new x-point
     * @param newY the new y-point
     */
    public void moveUpperLeftTo(int newX, int newY)
    {
        this.x = newX;
        this.y = newY;
    }
    
    /**
     * Draw the shape on JPanel
     * @param g graphics to draw the shape
     */
    public abstract void paint(Graphics g);
    
    @Override
    /**
     * Give the representation of the state of an AbstractShape object (using several sentences)
     * @return state a couple of sentences about an AbstractShape object's state
     */
    public String toString()
    {
        //make the String representation for the Shape
        String state = "";
        state += "       ~ The upper left point is (" + this.x + "," + this.y + ")";
        state += "\n       ~ The height is " + this.height;
        state += "\n       ~ The color is " + this.color;
       
        return state;
    }
}
