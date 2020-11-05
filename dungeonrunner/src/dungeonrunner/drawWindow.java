package dungeonrunner;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class drawWindow extends JPanel{
private Hanteraren handler;
private int [][] mapcolumn;
private int[][] maprow;
private int x;
private int y;
/**
	 * 
	 */
private static final long serialVersionUID = 1L;


public drawWindow() {
handler= new Hanteraren();
mapcolumn = new int[4][4];
maprow = new int[4][4];
x=75;
y=50;	
fillMap();
System.out.println(handler.getPlayer());
handler.getPlayer().setX(mapcolumn[3][3]);
handler.getPlayer().setY(maprow[3][3]);
System.out.println(handler.getPlayer().getName());
}
	
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


public int getColumn(int a, int b) {
return mapcolumn[a][b];	
}
public int getRow(int a, int b) {
return maprow[a][b];	
}

public void clamp() {
if(handler.getPlayer().getX()<mapcolumn[0][0]) {
	handler.getPlayer().setX(handler.getPlayer().getX()+75);
this.repaint();
}
else if(handler.getPlayer().getX()>mapcolumn[3][3]) {
handler.getPlayer().setX(handler.getPlayer().getX()-75);
repaint();
}
else if(handler.getPlayer().getY()>maprow[3][3]) {
handler.getPlayer().setY(handler.getPlayer().getY()-40);
repaint();
}
else if(handler.getPlayer().getY()<maprow[0][0]) {
handler.getPlayer().setY(handler.getPlayer().getY()+40);
repaint();
}


}
}


