package dungeonrunner;

import java.awt.Color;
import java.util.Random;

public class Thief extends Entity{
    
   
    public Thief() {
       super(7, 5, 5, 7,ROLE.THIEF, Color.RED);
    
    
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

public boolean specialAbility() {  //Do 2x critical damage 20% chance.
Random rand = new Random();
int randval = rand.nextInt(100)+1;
if(randval>80) {
return true;	
}
return false;

}


	
	        
	
	
}