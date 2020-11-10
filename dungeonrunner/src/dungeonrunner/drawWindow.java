package dungeonrunner;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;


public class drawWindow extends JPanel{
private Hanteraren handler;
private RoomContent rc;   //All the room contents;
private boolean[][] visited;
private boolean[] monster;
private int mapcolor;
private int [][] mapcolumn;
private int[][] maprow;
private int lastX[];
private int lastY[];
private int[][] map;
private int[] mapY;
private int[] mapX;
//Exit point
private int exitpointX[][];
private int exitpointY[][];

private int x;
private int y;
/**
	 * 
	 */
private static final long serialVersionUID = 1L;


public drawWindow(int a, int b) {
handler= new Hanteraren();
map = new int[a][b];
mapcolumn = new int[a][b];
maprow = new int[b][a];
mapY = new int[a];
mapX= new int[b];
lastX = new int[a*4];
lastY=new int[a*4];
visited = new boolean[a][b];
mapcolor=a;
monster = new boolean[a];  //0: Spider, 1: Orc, 2: Skeleton, 3: Troll
rc = new RoomContent(a,b);
//Exit point
exitpointX= new int[a][b];
exitpointY = new int[a][b];
fillRooms(); //Set all rooms to false and fill them with content.
x=75;
y=50;	
fillMap();  // Fill the map with x and y values.
System.out.println(handler.getPlayer());
handler.getPlayer().setX(mapcolumn[3][3]);
handler.getPlayer().setY(maprow[3][3]);
lastX[0]= handler.getPlayer().getX();
lastY[0]= handler.getPlayer().getY();

System.out.println(handler.getPlayer().getName());
printValues();
}




//M�la ut rektanglarna.
public void paintComponent(Graphics g) {


//M�la ut rektanglarna baserat p� mapcolumn och maprow v�rdena som �r kartan.
//Maprow = y v�rden
//Mapcolumn = x v�rden
	
super.paintComponent(g);
this.setBackground(Color.BLACK);
if(mapcolor<=4) {
g.setColor(Color.WHITE);
g.fillRect(mapX[0], mapY[0]+15, 225,10);
g.fillRect(mapX[0], mapY[1]+15, 225,10);
g.fillRect(mapX[0], mapY[2]+15, 225,10);
g.fillRect(mapX[0], mapY[3]+15, 225,10);
}
else if(mapcolor>=4&&mapcolor<=6) {
g.setColor(Color.CYAN);	
for(int i=0;i<mapX.length;i++) {
g.fillRect(mapX[0], mapY[i]+15, 300, 10);	
}
}
else if(mapcolor>=6&&mapcolor<=8) {
g.setColor(Color.GREEN);	
for(int i=0;i<mapX.length;i++) {
g.fillRect(mapX[0], mapY[i]+15, 525, 10);	
}	
}
for(int z=0;z<mapcolumn.length;z++) {

for(int j=0;j<mapcolumn.length;j++) {
if(mapcolor<=4) {
g.setColor(Color.WHITE);
}
else if(mapcolor>=4&&mapcolor<=6) {
g.setColor(Color.CYAN);	
}
else if(mapcolor>=6 && mapcolor<=8) {
g.setColor(Color.GREEN);	
}

g.fillRect(mapX[j], mapY[z], 35, 35);
g.setColor(handler.getPlayer().getColor());
g.fillRect(handler.getPlayer().getX(),handler.getPlayer().getY() ,35, 35);


}	

}
}
//Fyll kartan med X och Y v�rden
public void fillMap(){
Random rand = new Random();
int randval = rand.nextInt(4)+1;
for(int z=0;z<mapcolumn.length;z++) {	
x=75;	
y+=40;
for(int j=0;j<mapcolumn.length;j++) {
mapY[z]=y;
mapX[j]=x;
mapcolumn[z][j]=x;
maprow[z][j]=y;	
x+=75;
}
}
}

public void printValues() {
for(int i=0;i<mapcolumn.length;i++) {
System.out.println();
for(int j=0;j<mapcolumn.length;j++) {
}	
}

	
}



public void moveDown() {
handler.getPlayer().setY(handler.getPlayer().getY()+40);
clamp();
this.repaint();
}

public void moveUp() {
handler.getPlayer().setY(handler.getPlayer().getY()-40);
clamp();
this.repaint();	
}
public void moveLeft() {
handler.getPlayer().setX(handler.getPlayer().getX()-75);
clamp();
this.repaint();	
}
public void moveRight() {
handler.getPlayer().setX(handler.getPlayer().getX()+75);
clamp();
this.repaint();		
}

public int [][] getMap() {
return mapcolumn;	
}


public int getColumn(int a, int b) {
return mapcolumn[a][b];	
}
public int getRow(int a, int b) {
return maprow[a][b];	
}

public void clamp() {   //S� att spelaren inte kan g� utanf�r dimensionen.
if(handler.getPlayer().getX()<mapcolumn[0][0]) {
handler.getPlayer().setX(handler.getPlayer().getX()+75);
this.repaint();
}
else if(handler.getPlayer().getX()>mapcolumn[mapcolumn.length-1][mapcolumn.length-1]) {
handler.getPlayer().setX(handler.getPlayer().getX()-75);
repaint();
}
else if(handler.getPlayer().getY()>maprow[maprow.length-1][maprow.length-1]) {
handler.getPlayer().setY(handler.getPlayer().getY()-40);
repaint();
}
else if(handler.getPlayer().getY()<maprow[0][0]) {
handler.getPlayer().setY(handler.getPlayer().getY()+40);
repaint();
}
}

public void setClear() {   //Om spelaren g�r in i ett rum s� blir det avcheckat.
for(int i=0;i<mapcolumn.length;i++) {
for(int j=0;j<mapcolumn.length;j++) {
if(handler.getPlayer().getX()==mapcolumn[i][j] && handler.getPlayer().getY()==maprow[i][j]) {
visited[i][j]=true;	
}	
}
}	
}


public void fillRooms() {
for(int i =0;i< visited.length;i++) {
for(int j=0;j<visited.length;j++) {
visited[i][j]=false;	
}

}

}

public int checkRooms() {   //Kolla in rummen och returnera en siffra beroende p� vilket monster som finns.
	for(int i =0;i< mapcolumn.length;i++) {
		for(int j=0;j<mapcolumn.length;j++) {
		if(rc.checkMonster(i, j ,handler.getPlayer().getX(), handler.getPlayer().getY())==0) {  //If room contains a spider
		return 0;
		}
		else if(rc.checkMonster(i, j ,handler.getPlayer().getX(), handler.getPlayer().getY())==1) { // if room contains an orc!
		return 1;	
		}
		
		else if(rc.checkMonster(i, j ,handler.getPlayer().getX(), handler.getPlayer().getY())==2) { // if room contains a skeleton!!
		return 2;	
		}
		
		else if(rc.checkMonster(i, j, handler.getPlayer().getX(),handler.getPlayer().getY())==10) {  //If room contains an orc and a spider 1+0 = 10.
		return 10;	
		}
		
		}
		
		}
	
return -1;			
}



}
