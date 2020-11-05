package dungeonrunner;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;



//Ta bort all static, gör om metoderna toch variabler ill icke static
//Ta också bort Main i den här klassen.

 

//ändra string till int


public class Karta {

 
    Hanteraren handler;
    private String x = "[X]";
    private String player = "[*]";
    private int mapX[];
    public  int[][] lightMap;
    private int[][] mediumMap;
    private int[][] largeMap;
    
 

 public Karta(Hanteraren handler) {
this.handler=handler;


   }


    public  int [][] createSmall() {
        int counter=0;
        mapX = new int[16];
    	int[][] smallMap = new int[4][4];
        for(int i=0;i<smallMap.length;i++) {
        smallMap[i][i]=counter;
        for(int j=0;j<smallMap.length;j++) {
        smallMap[i][j]=counter;
        mapX[i]=counter;
        counter++;
        }
        
        }
        return smallMap;
    }
    
     

    public int[][] createMedium() {
    	
        int counter=0;
        
    	int[][] mediumMap = new int[5][5];
        for(int i=0;i<mediumMap.length;i++) {
        mediumMap[i][i]=counter;
        for(int j=0;j<mediumMap.length;j++) {
        mediumMap[i][j]=counter;
          counter++;
        }
        
        }
        return mediumMap;
    }
    

    public int[][] createLarge() {
    	
        int counter=0;
        
    	int[][] largeMap = new int[8][8];
        for(int i=0;i<largeMap.length;i++) {
        largeMap[i][i]=counter;
        for(int j=0;j<largeMap.length;j++) {
        largeMap[i][j]=counter;
        handler.boxlist.add(new mapBox(ROLE.MAPBOX,5,5));
        counter++;
        }
        
        }
        return mediumMap;
    }
    

 public static int randomPos() {
	Random rand = new Random();
	int randval = rand.nextInt(4)+1;
	return randval;
 }
 

    public void printMap(int[][] map) {
    	
      
   for (int i = 0; i < map.length; i++) {
         
   System.out.println();
 

   for (int j = 0; j < map.length; j++) {
        	             
   System.out.print(x);
   
    }
          
   }
        
    }

  public Rectangle getBounds(int x, int y) {
		return new Rectangle(x,y,5,5);	
  }  

  

  public void render(Graphics g, int x, int y) {
  Graphics2D g2d = (Graphics2D) g;
  g.setColor(Color.green);
  g2d.draw(getBounds(x, y));
  g.setColor(Color.white);
  g.fillRect(x, y, 5, 5);
  }
   

          
    
    
    
}

    
 

    
