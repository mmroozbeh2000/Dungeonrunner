package dungeonrunner;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferStrategy;





public class TryIt extends Canvas implements WindowListener{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
private MenuWindow mw;  //Start menu
private CharacterScreen cs; //Character screen
private GameWindow gw; // GameWindow holding drawmap;
public static final int WIDTH= 640;
public static final int HEIGHT = WIDTH / 12 *9;  //480

public TryIt() {
	mw = new MenuWindow();
	mw.addWindowListener(this);
}








public static void main(String[] args) {
		
		
new TryIt();
	   
	 

}
	
	
		
	
	
	
	
	


	@Override
	public void windowOpened(WindowEvent e) {
	
		
	}


	@Override
	public void windowClosing(WindowEvent e) {

		
	}


	@Override
	public void windowClosed(WindowEvent e) {
		if(e.getSource()==cs) {
			
			gw = new GameWindow(HEIGHT,WIDTH);
			
			
		  
			
		}
		
		else if(e.getSource()==mw && mw.getWindow(1)==true) {
			cs = new CharacterScreen();
			cs.addWindowListener(this);
		}
		
	}


	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
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

}
