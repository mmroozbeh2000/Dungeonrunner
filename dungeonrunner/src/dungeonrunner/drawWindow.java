package dungeonrunner;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageProducer;
import java.util.Random;

import javax.swing.ImageIcon;
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
private boolean direction[];
private int[][] map;
private int[] mapY;
private int[] mapX;
//Exit point
private ImageIcon img;
private Image image;

ImageProducer imgprod;

private int x;
private int y;
private int count;
Graphics g;
/**
	 * 
	 */
private static final long serialVersionUID = 1L;


public drawWindow(int a, int b) {
direction = new boolean[4]; //0 Right, 1 left, 2 up, 3 down.
direction[0]=true;
handler= new Hanteraren();
map = new int[a][b];
mapcolumn = new int[a][b];
maprow = new int[b][a];
mapY = new int[a];
mapX= new int[b];
lastX = new int[300];
lastY=new int[300];
visited = new boolean[a][b];
mapcolor=a;
monster = new boolean[a];  //0: Spider, 1: Orc, 2: Skeleton, 3: Troll
rc = new RoomContent(a,b);
//Count for last pos
count =0;
fillRooms(); //Set all rooms to false and fill them with content.
x=75;
y=50;	
fillMap();  // Fill the map with x and y values.
System.out.println(handler.getPlayer());
handler.getPlayer().setX(mapX[3]);
handler.getPlayer().setY(mapY[3]);
lastX[0]= handler.getPlayer().getX();
lastY[0]= handler.getPlayer().getY();

System.out.println(handler.getPlayer().getName());
printValues();
}




//Måla ut rektanglarna.
public void paintComponent(Graphics g) {


//Måla ut rektanglarna baserat på mapcolumn och maprow värdena som är kartan.
//Maprow = y värden
//Mapcolumn = x värden
	
super.paintComponent(g);
this.setBackground(Color.BLACK);

//Skriv ut raderna 
/*
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
*/
for(int z=0;z<mapcolumn.length;z++) {

for(int j=0;j<mapcolumn.length;j++) {
/*	
if(mapcolor<=4) {
g.setColor(Color.WHITE);
}
else if(mapcolor>=4&&mapcolor<=6) {
g.setColor(Color.CYAN);	
}
else if(mapcolor>=6 && mapcolor<=8) {
g.setColor(Color.GREEN);	
}
*/
g.setColor(Color.WHITE);
g.fillRect(mapX[j], mapY[z], 35, 35);
for(int i=0;i<count;i++) {
g.setColor(Color.DARK_GRAY);
g.fillRect(lastX[i], lastY[i], 35, 35);		
}


//Knight draw
if(direction[0]==true&&handler.getPlayer().getRole()==ROLE.KNIGHT) {
img = new ImageIcon("C:/Javafiler/Knighticonright.jpg");
image = img.getImage();		

}
else if(direction[1]==true&&handler.getPlayer().getRole()==ROLE.KNIGHT) {
img = new ImageIcon("C:/Javafiler/Knighticonleft.jpg");
image = img.getImage();	
}
else if(direction[2]==true&&handler.getPlayer().getRole()==ROLE.KNIGHT) {
img = new ImageIcon("C:/Javafiler/Knighticonup.jpg");
image = img.getImage();	
}
else if(direction[3]==true&&handler.getPlayer().getRole()==ROLE.KNIGHT) {
img = new ImageIcon("C:/Javafiler/Knighticondown.jpg");
image = img.getImage();	
}

//Mage draw
if(direction[0]==true &&handler.getPlayer().getRole()==ROLE.MAGE) {
img = new ImageIcon("C:/Javafiler/mageiconright.jpg");
image = img.getImage();		

}
else if(direction[1]==true&&handler.getPlayer().getRole()==ROLE.MAGE) {
img = new ImageIcon("C:/Javafiler/mageiconleft.jpg");
image = img.getImage();	
}
else if(direction[2]==true&&handler.getPlayer().getRole()==ROLE.MAGE) {
img = new ImageIcon("C:/Javafiler/mageiconup.jpg");
image = img.getImage();	
}
else if(direction[3]==true&&handler.getPlayer().getRole()==ROLE.MAGE) {
img = new ImageIcon("C:/Javafiler/mageicondown.jpg");
image = img.getImage();	
}


//Thief draw
if(direction[0]==true &&handler.getPlayer().getRole()==ROLE.THIEF) {
img = new ImageIcon("C:/Javafiler/Thiefright.jpg");
image = img.getImage();		

}
else if(direction[1]==true&&handler.getPlayer().getRole()==ROLE.THIEF) {
img = new ImageIcon("C:/Javafiler/Thiefleft.jpg");
image = img.getImage();	
}
else if(direction[2]==true&&handler.getPlayer().getRole()==ROLE.THIEF) {
img = new ImageIcon("C:/Javafiler/Thiefup.jpg");
image = img.getImage();	
}
else if(direction[3]==true&&handler.getPlayer().getRole()==ROLE.THIEF) {
img = new ImageIcon("C:/Javafiler/Thiefdown.jpg");
image = img.getImage();	
}


g.setColor(handler.getPlayer().getColor());
g.drawImage(image, handler.getPlayer().getX(), handler.getPlayer().getY(), 35, 35, this);

}	

}

}
//Fyll kartan med X och Y värden
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
direction[0]=false;
direction[1]=false;	
direction[2]=false;
direction[3]=true;		
lastY[count]=handler.getPlayer().getY();
lastX[count]=handler.getPlayer().getX();
count++;
handler.getPlayer().setY(handler.getPlayer().getY()+40);
clamp();
this.repaint();
}

public void moveUp() {
direction[0]=false;
direction[1]=false;	
direction[2]=true;
direction[3]=false;	
lastY[count]=handler.getPlayer().getY();
lastX[count]=handler.getPlayer().getX();
count++;	
handler.getPlayer().setY(handler.getPlayer().getY()-40);
clamp();
this.repaint();	
}
public void moveLeft() {
direction[0]=false;
direction[1]=true;	
direction[2]=false;
direction[3]=false;
lastY[count]=handler.getPlayer().getY();
lastX[count]=handler.getPlayer().getX();
count++;		
handler.getPlayer().setX(handler.getPlayer().getX()-75);
clamp();
this.repaint();	
}
public void moveRight() {
direction[0]=true;
direction[1]=false;	
direction[2]=false;
direction[3]=false;
lastY[count]=handler.getPlayer().getY();
lastX[count]=handler.getPlayer().getX();
count++;		
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
