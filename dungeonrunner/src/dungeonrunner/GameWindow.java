package dungeonrunner;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class GameWindow  extends JPanel implements KeyListener, WindowListener{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private drawWindow dw;
 AttackWindow awspider;
 AttackWindow aworc;
private boolean[] monster;
private Hanteraren handler;
private JFrame frame;

public GameWindow() {
	
}
	
public GameWindow(int width, int height, int a, int b){	  //Add values to decide which map
handler = new Hanteraren();	
monster = new boolean[4];  //0: Spider, 1: Orc, 2: Skeleton, 3: Troll
frame = new JFrame("DungeonRunner");
frame.setPreferredSize(new Dimension(width,height));
frame.setMaximumSize(new Dimension(width,height));
frame.setMinimumSize(new Dimension(width,height));
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setResizable(false);
frame.setLocationRelativeTo(null);
frame.setVisible(true);
dw = new drawWindow(a,b);
awspider= new AttackWindow();
aworc = new AttackWindow();
dw.setFocusable(true);
dw.addKeyListener(this);
awspider.addWindowListener(this);
aworc.addWindowListener(this);
frame.addWindowListener(this);
frame.add(dw);
frame.pack();
}

public void initiateBattle(int n) {
if(n==0) {
awspider = new AttackWindow(0, handler);
awspider.addWindowListener(this);
handler.newSpider();
}	
else if(n==1) {
aworc = new AttackWindow(1, handler);
aworc.addWindowListener(this);
handler.newOrc();
}
else if(n==10) {
awspider = new AttackWindow(0,handler);
aworc = new AttackWindow(1,handler);
}

}

@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}


public void keyPressed(KeyEvent e) {

	int key = e.getKeyCode();
	 if(key == KeyEvent.VK_DOWN) {
	 dw.moveDown();
	 dw.setClear();
	 initiateBattle(dw.checkRooms());
	
	   
	 }
	 
	 else if(key == KeyEvent.VK_UP) {
	dw.moveUp();
	dw.setClear();
	initiateBattle(dw.checkRooms());
	 
	
	
	
	 }
	 
	 else if(key == KeyEvent.VK_LEFT) {
	dw.moveLeft();
	dw.setClear();
	initiateBattle(dw.checkRooms());
	 revalidate();
	 }
	 
	 else if(key == KeyEvent.VK_RIGHT) {
	dw.moveRight();
	dw.setClear();
	initiateBattle(dw.checkRooms());
	 revalidate();
		 
	 }

	
}
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowOpened(WindowEvent e) {

	
}

@Override
public void windowClosing(WindowEvent e) {

}

@Override
public void windowClosed(WindowEvent e) {
	
	    if(e.getSource()==aworc && handler.getPlayer().getEndurance()<=0) {
		this.remove(dw);
		frame.dispose();
		}
		else if(e.getSource()==awspider && handler.getPlayer().getEndurance()<=0) {
		this.remove(dw);
		frame.dispose();
		}
			
	
}

@Override
public void windowIconified(WindowEvent e) {

	
}

@Override
public void windowDeiconified(WindowEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowActivated(WindowEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowDeactivated(WindowEvent e) {
	// TODO Auto-generated method stub
	
}	

public JFrame getFrame() {
return frame;	
}


}


