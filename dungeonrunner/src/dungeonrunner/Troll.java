
package dungeonrunner;

import java.awt.Color;

public class Troll extends Entity{

    public Troll() {
        super(2, 4, 7, 2, null, null, 5);
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
		
}
    

