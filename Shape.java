import java.awt.*;
import javax.swing.*;
/**
 * This is the interface for the AbstractShape program.
 *
 * @author (Tarcisius Daniel Hartanto)
 * @version (Monday, October 23rd 2017)
 */
public interface Shape
{
    /**
     * Identify a point if it is on a shape or not
     * @param x the x-point that will be identified
     * @param y the y-point that will be identified
     * @return true/false depends on the point (if it is on the shape or not)
     */
    public boolean isOn (int x, int y);
    
    /**
     * Identify a Shape if it selected or deselected
     * @return tf true if the Shape is selected, false if not
     */
    public boolean isSelected();
    
    /**
     * Set a Shape to be selected(true) or deselected(false)
     * @param b the condition (selected or deselected) that the user decides
     */    
    public void setSelected(boolean b);
    
    /**
     * Set a new color for a Shape
     * @param c the new color
     */
    public void setColor(Color c);
    
    /**
     * Set a new x-point for a Shape
     * @param x the new x-point
     */
    public void setX(int x);
    
    /**
     * Set a new y-point for a Shape
     * @param y the new y-point
     */
    public void setY(int y);
    
    /**
     * Set a new height for a Shape
     * @param h the new height
     */
    public void setHeight(int h);
    
    /**
     * Get the x-point of a Shape
     * @return x the current x-point
     */
    public int getX();
    
    /**
     * Get the y-point of a Shape
     * @return y the current y-point
     */
    public int getY();
    
    /**
     * Get the height of a Shape
     * @return height the current height
     */
    public int getHeight();
    
    /**
     * Get the Color of a Shape
     * @return color the current color
     */
    public Color getColor();
    
    /**
     * Shift the upper left point of a Shape
     * @param deltaX the range to move the x-point
     * @param deltaY the range to move the y-point
     */
    public void shiftUpperLeftBy(int deltaX, int deltaY);
    
    /**
     * Replace the upper left point of Shape with a new one
     * @param newX the new x-point
     * @param newY the new y-point
     */
    public void moveUpperLeftTo(int newX, int newY);
    
    /**
     * Give the representation of the state of an AbstractShape object (using several sentences)
     * @return state a couple of sentences about an AbstractShape object's state
     */
    public String toString();
    
    /**
     * Draw the shape on JPanel
     * @param g graphics to draw the shape
     */
    public void paint(Graphics g);
}
