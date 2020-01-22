import java.awt.*;
import javax.swing.*;
/**
 * The main program.
 *
 * @author (Tarcisius Daniel Hartanto)
 * @version (Monday, October 23rd 2017)
 */
public class GraphicEditorApp
{
    public static void main(String[] args) 
    {
        DrawingBoard db = new DrawingBoard(); //instantiate the drawing board

        JFrame frame = new JFrame("Drawing Board"); //Create JFrame
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        DrawingBoardControl con = new DrawingBoardControl(db);
        frame.getContentPane().add(con);

        frame.pack(); //pack the win
        frame.setVisible(true); //set it to be visible

    }
}
