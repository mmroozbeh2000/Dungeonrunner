package dungeonrunner;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Knight extends Entity{
    
private boolean block=true;	
    public Knight() {
        super(5, 9, 6, 4,ROLE.KNIGHT, Color.BLUE,1);
    }


	@Override
	public int getX() {
	
		return x;
	}

	@Override
	public int getY() {
		
		return y;
	}

@Override
public void setY(int y) {
   this.y=y;
		
}

@Override
public void setX(int x) {
this.x=x;
		
}


public Color getColor() {
return color;	
}


@Override
public boolean specialAbility() {

return block;
}


@Override
public void setspecialAbility(boolean b) {
block = b;
	
}
        
    
}