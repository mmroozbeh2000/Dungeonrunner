package DungeonRunner;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
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
handler = new Hanteraren();
handler.Entitylist.add(new Knight());
mapcolumn = new int[4][4];
maprow = new int[4][4];
x=75;
y=50;	
fillMap();
handler.Entitylist.get(0).setX(mapcolumn[3][3]);
handler.Entitylist.get(0).setY(maprow[3][3]);	

}
	
public void paintComponent(Graphics g) {



super.paintComponent(g);
this.setBackground(Color.BLACK);

for(int z=0;z<mapcolumn.length;z++) {

for(int j=0;j<mapcolumn.length;j++) {

g.setColor(Color.WHITE);
g.fillRect(mapcolumn[z][j], maprow[z][j], 35, 35);
g.setColor(handler.Entitylist.get(0).getColor());
g.fillRect(handler.Entitylist.get(0).getX(),handler.Entitylist.get(0).getY() ,35, 35);
}	

}
}

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

handler.Entitylist.get(0).setY(handler.Entitylist.get(0).getY()+40);
this.repaint();
}

public void moveUp() {
	handler.Entitylist.get(0).setY(handler.Entitylist.get(0).getY()-40);
	this.repaint();	
}
public void moveLeft() {
	handler.Entitylist.get(0).setX(handler.Entitylist.get(0).getX()-75);
	this.repaint();	
}
public void moveRight() {
	handler.Entitylist.get(0).setX(handler.Entitylist.get(0).getX()+75);
	this.repaint();		
}


public int getColumn(int a, int b) {
return mapcolumn[a][b];	
}
public int getRow(int a, int b) {
return maprow[a][b];	
}


}



