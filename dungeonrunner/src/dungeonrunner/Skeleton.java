
package DungeonRunner;


public class Skeleton extends Entity{

    public Skeleton() {
        super(4, 2, 3, 3, null, null, 15);
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

