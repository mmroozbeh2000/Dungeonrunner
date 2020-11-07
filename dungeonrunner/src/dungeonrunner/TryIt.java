package dungeonrunner;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferStrategy;

import javax.swing.JOptionPane;





public class TryIt extends Canvas implements WindowListener{
	
/**
	 * 
	 */
private static final long serialVersionUID = 1L;
	
private static int Mapsize=4;
private MenuWindow mw;  //Start menu
private CharacterScreen cs; //Character screen
private GameWindow gw; // GameWindow holding drawmap;
private MapWindow mp;  //Window for selecting map
public static final int WIDTH= 1000;
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
public void windowClosed(WindowEvent e) {    //If player has selected a map and created a character and pressed start, start the game
if(e.getSource()==mw && mw.getStatus()==true) {
gw = new GameWindow(HEIGHT,WIDTH, Mapsize, Mapsize);
gw.getFrame().addWindowListener(this);
}


if(e.getSource()==cs ) {    //If Character screen closes but the game won't start!
mw = new MenuWindow();
mw.addWindowListener(this);
}
		
else if(e.getSource()==mw && mw.getWindow(1)==true) {  //If chosen Create character, open Character Window
cs = new CharacterScreen();
cs.addWindowListener(this);
mw.setWindow(1, false);
}

else if(e.getSource()==mw && mw.getWindow(0)==true) {   //If chosen select map, open MapWindow
mp = new MapWindow();	
mp.addWindowListener(this);
Mapsize = mp.getMap();
}

else if(e.getSource()==gw.getFrame()) {  //If player exits map or dies, go to main screen.
mw = new MenuWindow();	
mw.addWindowListener(this);
}

else if(e.getSource()==mp) {
JOptionPane.showMessageDialog(null, "WTF");
mw=new MenuWindow();	
mw.revalidate();
mw.addWindowListener(this);
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
