package dungeonrunner;

import java.util.Random;

import javax.swing.JOptionPane;

public class RoomContent {

private Hanteraren handler;	
private AttackWindow aw;
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

private Random rand;
private int randval;	

public RoomContent() { // Skapa möjliga rutor för monster
handler = new Hanteraren();
rand = new Random();	
monster = new boolean[4];  //0: Spider, 1: Orc, 2: Skeleton, 3: Troll

spiderX = new int[4][4];
spiderY = new int[4][4];
orcX = new int[4][4];
orcY = new int[4][4];
skeletonX = new int[4][4];
skeletonY = new int[4][4];
trollX = new int[4][4];
trollY = new int[4][4];
fillSpiders();
}



public void fillSpiders() {
x=75;
y=50;	
for(int i=0;i<4;i++) {
x=75;	
y+=40;	
for(int j=0;j<4;j++) {
randval = rand.nextInt(100)+1;

if(randval>=80 && !getTrolls(i,j) &&!getSkeletons(i,j) &&!getOrcs(i,j) ) {
//Spider added to specific coordinates	
spiderX[i][j]=x;
spiderY[i][j]=y;
x+=75;	
}
}	
}
}



public void fillOrcs() {
	
}



public void addSpider(int a, int b) {

}



public void checkMonster(int a, int b, int x, int y) {
//If room contains a spider	
if(spiderX[a][b] ==x && spiderY[a][b]==y) {
JOptionPane.showMessageDialog(null, "Omg a spider!");	
monster[0]=true;
handler.newSpider();
aw = new AttackWindow(monster, 0, handler);	
}

else if(orcX[a][b]==x&& orcY[a][b]==y) {
	
}

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





}




















