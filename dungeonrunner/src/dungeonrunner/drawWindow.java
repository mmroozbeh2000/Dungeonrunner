package dungeonrunner;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class drawWindow extends JPanel{
private Hanteraren handler;
private RoomContent rc;   //All the room contents;
private boolean[][] visited;
private boolean[] monster;
private int [][] mapcolumn;
private int[][] maprow;
private int x;
private int y;
/**
	 * 
	 */
private static final long serialVersionUID = 1L;


public drawWindow(int a, int b) {
handler= new Hanteraren();
mapcolumn = new int[a][b];
maprow = new int[b][a];
visited = new boolean[a][b];
monster = new boolean[a];  //0: Spider, 1: Orc, 2: Skeleton, 3: Troll
rc = new RoomContent(a,b);
fillRooms(); //Set all rooms to false and fill them with content.
x=75;
y=50;	
fillMap();  // Fill the map with x and y values.
System.out.println(handler.getPlayer());
handler.getPlayer().setX(mapcolumn[3][3]);
handler.getPlayer().setY(maprow[3][3]);
System.out.println(handler.getPlayer().getName());
}




//Måla ut rektanglarna.
public void paintComponent(Graphics g) {


//Måla ut rektanglarna baserat på mapcolumn och maprow värdena som är kartan.
//Maprow = y värden
//Mapcolumn = x värden
	
super.paintComponent(g);
this.setBackground(Color.BLACK);

for(int z=0;z<mapcolumn.length;z++) {

for(int j=0;j<mapcolumn.length;j++) {

g.setColor(Color.WHITE);
g.fillRect(mapcolumn[z][j], maprow[z][j], 35, 35);
g.setColor(handler.getPlayer().getColor());
g.fillRect(handler.getPlayer().getX(),handler.getPlayer().getY() ,35, 35);
}	

}
}
//Fyll kartan med X och Y värden
public void fillMap(){
for(int z=0;z<mapcolumn.length;z++) {	
x=75;	
y+=40;
for(int j=0;j<mapcolumn.length;j++) {
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


System.out.print(maprow[i][j] + "\t");
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

public void clamp() {   //Så att spelaren inte kan gå utanför dimensionen.
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

public void setClear() {   //Om spelaren går in i ett rum så blir det avcheckat.
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
rc.addSpider(i, j);
}

}

}

public int checkRooms() {   //Kolla in rummen och returnera en siffra beroende på vilket monster som finns.
	for(int i =0;i< mapcolumn.length;i++) {
		for(int j=0;j<mapcolumn.length;j++) {
		if(rc.checkMonster(i, j ,handler.getPlayer().getX(), handler.getPlayer().getY())==0) {  //If room contains a spider
		return 0;
		}
		else if(rc.checkMonster(i, j ,handler.getPlayer().getX(), handler.getPlayer().getY())==1) { // if room contains an orc!
		return 1;	
		}
		else if(rc.checkMonster(i, j, handler.getPlayer().getX(),handler.getPlayer().getY())==10) {
		return 10;	
		}
		
		}
		
		}
	
return -1;			
}

}





