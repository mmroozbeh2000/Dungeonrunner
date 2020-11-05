package dungeonrunner;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

public class ListeningforKeys implements KeyListener{
	

private drawWindow dw;
private drawMediumwindow mdw;
private drawLargewindow ldw;


public ListeningforKeys(drawWindow dw) {

this.dw=dw;
}

public ListeningforKeys(Hanteraren handler, drawMediumwindow mdw) {

this.mdw=mdw;
}

public ListeningforKeys(Hanteraren handler, drawLargewindow ldw) {

this.ldw=ldw;
}
	

@Override
public void keyTyped(KeyEvent e) {


	}

	
	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();
		 if(key == KeyEvent.VK_DOWN) {
		 dw.moveDown();
		 dw.setClear();
		 dw.checkRooms();
		   
		 }
		 
		 else if(key == KeyEvent.VK_UP) {
		dw.moveUp();
		dw.setClear();
		dw.checkRooms();
	    
		
		
		
		 }
		 
		 else if(key == KeyEvent.VK_LEFT) {
		dw.moveLeft();
		dw.setClear();
		dw.checkRooms();
		 }
		 
		 else if(key == KeyEvent.VK_RIGHT) {
		dw.moveRight();
		dw.setClear();
		dw.checkRooms();
			 
		 }
				
		
	}

	
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
