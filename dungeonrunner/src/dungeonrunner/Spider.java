
package DungeonRunner;



public class Spider extends Entity{
    
    public Spider() {
        super(7, 1, 2, 3, null, null, 20);
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
