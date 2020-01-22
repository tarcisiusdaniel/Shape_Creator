
/**
 * The interface for DrawingBoardStateView, DrawingBoardGraphicView, and DrawingBoardStateJTextAreaView.
 *
 * @author (Tarcisius Daniel Hartanto)
 * @version (Monday, October 23rd 2017)
 */
public interface DrawingBoardViewer
{
    /**
     * Make a representation of the changing state of the viewers list
     * This is also functions to notify the viewers as well
     */
    public void notifyAboutState();
}
