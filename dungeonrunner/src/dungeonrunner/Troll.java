
package dungeonrunner;

import java.awt.Color;

public class Troll extends Entity{

    public Troll() {
        super(2, 4, 7, 2, ROLE.TROLL,5, 1);
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
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void setspecialAbility(boolean b) {
		// TODO Auto-generated method stub
		
	}
		
}
    

