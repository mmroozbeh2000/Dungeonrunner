package dungeonrunner;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;





public class TryIt extends JFrame implements WindowListener{
	
/**
	 * 
	 */
private static final long serialVersionUID = 1L;
	
private static int Mapsize=4;
private Hanteraren handler;
private MenuWindow mw;  //Start menu
private CharacterScreen cs; //Character screen
private GameWindow gw; // GameWindow holding drawmap;
private MapWindow mp;  //Window for selecting map
public static final int WIDTH= 1000;
public static final int HEIGHT = WIDTH / 12 *9;  //480

public TryIt() {
	UIDefaults uiDefaults = UIManager.getDefaults();
	uiDefaults.put("activeCaption", new javax.swing.plaf.ColorUIResource(Color.BLACK));
	uiDefaults.put("activeCaptionText", new javax.swing.plaf.ColorUIResource(Color.ORANGE));
	UIManager.put("InternalFrame.activeTitleBackground", new ColorUIResource(Color.BLUE ));
	UIManager.put("InternalFrame.activeTitleForeground", new ColorUIResource(Color.ORANGE));
	UIManager.put("InternalFrame.titleFont", new Font("Dialog", Font.PLAIN, 15));
	setDefaultLookAndFeelDecorated(true);
	handler = new Hanteraren();
	gw = new GameWindow();
	mw = new MenuWindow();
	mw.addWindowListener(this);
	/*
	File menuMusic= new File("C:/Javafiler/Halloween.wav");
	Sound s = new Sound();
	s.playSound(menuMusic);
	*/
	
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
gw = new GameWindow(HEIGHT,WIDTH, Mapsize);
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

else if(e.getSource()==gw.getFrame()&&handler.checkPlayer()==false) {  //If player exits map or dies, go to main screen.
mw = new MenuWindow();	
mw.addWindowListener(this);
}

else if(e.getSource()==mp) {
Mapsize = mp.getMap();
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
