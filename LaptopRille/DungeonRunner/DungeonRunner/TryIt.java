package DungeonRunner;

import java.awt.Canvas;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class TryIt extends Canvas implements WindowListener{
	
static Entity Player;
private CharacterScreen cs;
private GameWindow gw;
private Hanteraren handler;
public static final int WIDTH= 640;
public static final int HEIGHT = WIDTH / 12 *9;  //480

public TryIt() {
	

	int map[][];
	Hanteraren handler = new Hanteraren();
	cs = new CharacterScreen();	
	cs.addWindowListener(this);

   

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
			System.out.println("lol");
			gw = new GameWindow(HEIGHT,WIDTH);
			
			
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