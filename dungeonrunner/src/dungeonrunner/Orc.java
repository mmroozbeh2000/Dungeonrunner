
package DungeonRunner;


public class Orc extends Entity{

    public Orc() {
        super(6, 3, 4, 4, null, null, 10);
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
    
