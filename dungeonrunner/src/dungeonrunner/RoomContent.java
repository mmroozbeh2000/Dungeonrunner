package dungeonrunner;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.PriorityQueue;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class RoomContent{

private Hanteraren handler;
private int x;
private int y;
private boolean monster[];
private int spiderX[][];
private int spiderY[][];
private int orcX[][];
private int orcY[][];
private int skeletonX[][];
private int skeletonY[][];
private int trollX[][];
private int trollY[][];
PriorityQueue<JFrame> queue;
private Random rand;
private int randval;	

public RoomContent(int a, int b) { // Skapa möjliga rutor för monster
handler = new Hanteraren();
rand = new Random();	
monster = new boolean[4];  //0: Spider, 1: Orc, 2: Skeleton, 3: Troll
queue = new PriorityQueue<>();
spiderX = new int[a][b];
spiderY = new int[a][b];
orcX = new int[a][b];
orcY = new int[a][b];
skeletonX = new int[a][b];
skeletonY = new int[a][b];
trollX = new int[a][b];
trollY = new int[b][a];
fillSpiders();
fillOrcs();
}



public void fillSpiders() {
x=75;
y=50;	
for(int i=0;i<spiderX.length;i++) {
x=75;	
y+=40;	
for(int j=0;j<4;j++) {
randval = rand.nextInt(100)+1;

if(randval>=50 ) {
//Spider added to specific coordinates	
spiderX[i][j]=x;
spiderY[i][j]=y;
x+=75;	
}
}	
}
}



public void fillOrcs() {
	x=75;
	y=50;	
	for(int i=0;i<orcX.length;i++) {
	x=75;	
	y+=40;	
	for(int j=0;j<4;j++) {
	randval = rand.nextInt(100)+1;

	if(randval>=50 ) {
	//Orc added to specific coordinates	
	orcX[i][j]=x;
	orcY[i][j]=y;
	x+=75;	
	}
	}	
	}
}



public void addSpider(int a, int b) {

}



public int checkMonster(int a, int b, int x, int y) {
//If room contains a spider	
if(spiderX[a][b] ==x && spiderY[a][b]==y) {
handler.newSpider();
return 0;
}


//if Room contains an orc
if(orcX[a][b]==x && orcY[a][b]==y) {
handler.newOrc();
return 1;
}

else if(spiderX[a][b] ==x && spiderY[a][b]==y && orcX[a][b]==x && orcY[a][b]==y) {
return 10;	
}

return -1;

}

public void removeSpider(int a, int b) {
spiderX[a][b]=0;
spiderY[a][b]=0;
}

public boolean getOrcs(int a, int b) {
if(orcX[a][b]>0 && orcY[a][b]>0) {
return true;	
}
return false;
}

public boolean getSpiders(int a, int b) {
if(spiderX[a][b]>0 && spiderY[a][b]>0) {
return true;	
}
return false;
}
	

public boolean  getSkeletons(int a, int b) {
if(skeletonX[a][b]>0 && skeletonY[a][b]>0) {
return true;	
}
return false;
}	


public boolean  getTrolls(int a, int b) {
if(trollX[a][b]>0 && trollY[a][b]>0) {
return true;	
}
return false;
}

public boolean getMonster(int n) {
return monster[n];	
}






}




















