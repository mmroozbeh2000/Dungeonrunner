
package dungeonrunner;

import java.awt.Color;

public class Skeleton extends Entity{

    public Skeleton() {
        super(4, 2, 3, 3, ROLE.SKELETON, 10, 1);
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

