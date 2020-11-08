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
private int mapsize[][];

		
//Monster på kartan
private int spiderX[];
private int spiderY[];
private int orcX[];
private int orcY[];
private int skeletonX[][];
private int skeletonY[][];
private int trollX[][];
private int trollY[][];
///
//Skatter på kartan
private int coinX[][];
private int coinY[][];
private int coinpurseX[][];
private int coinpurseY[][];
private int goldX[][];
private int goldY[][];
private int treasurechestX[][];
private int treasurechestY[][];
private int jewelryX[][];
private int jewelryY[][];

PriorityQueue<JFrame> queue;
private Random rand;
private int randval;	

public RoomContent(int a, int b) { // Skapa möjliga rutor för monster
handler = new Hanteraren();
rand = new Random();	
monster = new boolean[4];  //0: Spider, 1: Orc, 2: Skeleton, 3: Troll
mapsize = new int[a][b];
queue = new PriorityQueue<>();
//
//Monster
spiderX = new int[a];
spiderY = new int[b];
orcX = new int[b];
orcY = new int[a];
skeletonX = new int[a][b];
skeletonY = new int[a][b];
trollX = new int[a][b];
trollY = new int[b][a];
//Skatter
coinX = new int[a][b];
coinY= new int[a][b];
coinpurseX = new int[a][b];
coinpurseY= new int[a][b];
goldX = new int[a][b];
goldY = new int[a][b];
jewelryX = new int[a][b];
jewelryY= new int[a][b];
treasurechestX = new int[a][b];
treasurechestY = new int[a][b];
//Fill treasures
fillCoin();
fillcoinPurse();
fillChest();
fillJewelry();
fillGold();
//Fill monsters
fillSpiders();
fillOrcs();
}


public void fillCoin() {
x=75;
y=50;	
for(int i=0;i<mapsize.length;i++) {
x=75;	
y+=40;	
for(int j=0;j<mapsize.length;j++) {
randval = rand.nextInt(100)+1;

if(randval<=40 ) {
coinX[i][j]=x;	
coinY[i][j]=y;
x+=75;	
}
}	
}
}	

public void fillJewelry() {
x=75;
y=50;	
for(int i=0;i<mapsize.length;i++) {
x=75;	
y+=40;	
for(int j=0;j<mapsize.length;j++) {
randval = rand.nextInt(100)+1;

if(randval<=510) {
jewelryX[i][j]=x;	
jewelryY[i][j]=y;
x+=75;	
}
}
}
}

public void fillcoinPurse() {
x=75;
y=50;	
for(int i=0;i<mapsize.length;i++) {
x=75;	
y+=40;	
for(int j=0;j<mapsize.length;j++) {
randval = rand.nextInt(100)+1;

if(randval<=40 ) {
coinpurseX[i][j]=x;	
coinpurseY[i][j]=y;
x+=75;	
}
}
}

}


public void fillChest() {
x=75;
y=50;	
for(int i=0;i<mapsize.length;i++) {
x=75;	
y+=40;	
for(int j=0;j<mapsize.length;j++) {
randval = rand.nextInt(100)+1;

if(randval<=5 ) {
treasurechestX[i][j]=x;	
treasurechestY[i][j]=y;
x+=75;	
}
}
}
}





public void fillGold() {
x=75;
y=50;	
for(int i=0;i<mapsize.length;i++) {
x=75;	
y+=40;	
for(int j=0;j<mapsize.length;j++) {
randval = rand.nextInt(100)+1;

if(randval<=15 ) {
goldX[i][j]=x;	
goldY[i][j]=y;
x+=75;	
}
}
}
}
public void fillSpiders() {
x=75;
y=50;	
for(int i=0;i<mapsize.length;i++) {
x=75;	
y+=40;	
for(int j=0;j<mapsize.length;j++) {
randval = rand.nextInt(100)+1;

if(randval>=80 ) {
//Spider added to specific coordinates	
spiderX[j]=x;
spiderY[i]=y;
x+=75;	
}
}	
}
}


public void fillOrcs() {
	x=75;
	y=50;	
	for(int i=0;i<mapsize.length;i++) {
	x=75;	
	y+=40;	
	for(int j=0;j<mapsize.length;j++) {
	randval = rand.nextInt(100)+1;

	if(randval>=10 ) {
	//Orc added to specific coordinates	
	orcX[j]=x;
	orcY[i]=y;
	x+=75;	
	}
	}	
	}
	
	
}



public void addSpider(int a, int b) {

}



public int checkMonster(int a, int b, int x, int y) {
//If room contains a spider	
if(spiderX[b] ==x && spiderY[a]==y) {
handler.newSpider();
return 0;
}


//if Room contains an orc
if(orcX[b]==x && orcY[a]==y) {
handler.newOrc();
return 1;
}

else if(spiderX[b]==x && spiderY[a]==y && orcX[b]==x && orcY[a]==y) {
return 10;	
}

return -1;

}

public void removeSpider(int a, int b) {
spiderX[a]=0;
spiderY[b]=0;
}

public boolean getOrcs(int a, int b) {
if(orcX[b]>0 && orcY[a]>0) {
return true;	
}
return false;
}

public boolean getSpiders(int a, int b) {
if(spiderX[a]>0 && spiderY[b]>0) {
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




















