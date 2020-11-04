package DungeonRunner;

import java.awt.Color;
import java.util.concurrent.ThreadLocalRandom;


public class Mage extends Entity{

    public Mage() {
        super(6, 4, 9, 5,ROLE.MAGE, Color.YELLOW);
    }
    
    //Unik eftersom trollkarlens passive påverkar flyförsöket
    @Override
    public boolean escapeAttempt(){
    boolean escapeSuccesfull = false;
        
    int escapeChance = 80;
    
    int escapeAttempt = ThreadLocalRandom.current().nextInt(0, 100);
        
     if (escapeAttempt <= escapeChance) {
        escapeSuccesfull = true;
            
}
    
return escapeSuccesfull;
        
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

	@Override
public Color getColor() {
return color;	
}



	        
        
    
}
