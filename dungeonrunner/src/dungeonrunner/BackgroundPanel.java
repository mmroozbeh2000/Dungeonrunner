package dungeonrunner;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

class BackgroundPanel extends JPanel{   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	// The Image to store the background image in.
    private Image img;
    
    public BackgroundPanel()
    {
        // Loads the background image and stores in img object.
        img = Toolkit.getDefaultToolkit().createImage("C:/Javafiler/Main.jpg");
    }
     @Override
    public void paintComponent(Graphics g)
    {
       super.paintComponent(g);
        g.drawImage(img, 0, 0, this);
    }
}