package dungeonrunner;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;

class BackgroundPanel extends Panel
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// The Image to store the background image in.
    Image img;
    public BackgroundPanel()
    {
        // Loads the background image and stores in img object.
        img = Toolkit.getDefaultToolkit().createImage("C:/Javafiler/Main.jpg");
    }

    public void paint(Graphics g)
    {
        // Draws the img to the BackgroundPanel.
        g.drawImage(img, 0, 0, null);
    }
}