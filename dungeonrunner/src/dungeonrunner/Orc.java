
package dungeonrunner;

import java.awt.Color;

public class Orc extends Entity{

    public Orc() {
        super(6, 3, 4, 4, ROLE.ORC, null, 10);
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
    
