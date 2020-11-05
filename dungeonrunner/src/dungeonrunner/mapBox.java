package dungeonrunner;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class mapBox {

private ROLE role;
private int x;
private int y;
	public mapBox( ROLE role, int x, int y) {
		this.x=x;
		this.y=y;
		this.role=role;
		// TODO Auto-generated constructor stub
	}

	
	public int getX() {
		return x;
	}

	
	public int getY() {
	 return y;
	}

	
	public void setY(int y) {
	this.y=y;
		
	}


	public void setX(int x) {
	this.x=x;
		
	}

	
	public void render(Graphics g) {
	Graphics2D g2d = (Graphics2D) g;
	g2d.draw(getBounds());
	g.setColor(Color.white);
	g.fillRect(x, y, 3, 3);
	}
	 
			
		   	
	public Rectangle getBounds() {
	return new Rectangle( x,y,3,3);	
	}

	        

}
