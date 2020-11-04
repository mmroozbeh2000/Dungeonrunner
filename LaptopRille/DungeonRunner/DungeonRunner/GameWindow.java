package DungeonRunner;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class GameWindow  extends JPanel{
drawWindow dw;
Hanteraren handler;
	
public GameWindow(int width, int height)  {	
	
JFrame frame = new JFrame("DungeonRunner");
frame.setPreferredSize(new Dimension(width,height));
frame.setMaximumSize(new Dimension(width,height));
frame.setMinimumSize(new Dimension(width,height));
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setResizable(false);
frame.setLocationRelativeTo(null);
frame.setVisible(true);

drawWindow dw = new drawWindow();
dw.setFocusable(true);
dw.addKeyListener(new ListeningforKeys(handler,dw));
frame.add(dw);




	
}	





 }


