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
private int spiderX[];  //0
private int spiderY[]; 
private int orcX[]; // 1
private int orcY[];
private int skeletonX[];
private int skeletonY[];
private int trollX[];
private int trollY[];
///
//Skatter på kartan
private int coinX[];  // 0
private int coinY[];
private int coinpurseX[]; //1
private int coinpurseY[];
private int goldX[];
private int goldY[];
private int treasurechestX[];
private int treasurechestY[];
private int jewelryX[];
private int jewelryY[];

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
skeletonX = new int[a];
skeletonY = new int[a];
trollX = new int[a];
trollY = new int[a];
//Skatter
coinX = new int[a];
coinY= new int[a];
coinpurseX = new int[a];
coinpurseY= new int[a];
goldX = new int[a];
goldY = new int[a];
jewelryX = new int[a];
jewelryY= new int[a];
treasurechestX = new int[a];
treasurechestY = new int[a];
//Fill treasures
fillCoin();
fillcoinPurse();
fillChest();
fillJewelry();
fillGold();
//Fill monsters
fillSpiders();
fillOrcs();
fillSkeletons();
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
coinX[j]=x;	
coinY[i]=y;
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
jewelryX[j]=x;	
jewelryY[i]=y;
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
coinpurseX[j]=x;	
coinpurseY[i]=y;
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
treasurechestX[j]=x;	
treasurechestY[i]=y;
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
goldX[j]=x;	
goldY[i]=y;
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

if(randval>=75 ) {
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

	if(randval>=40 && randval<=75 ) {
	//Orc added to specific coordinates	
	orcX[j]=x;
	orcY[i]=y;
	x+=75;	
	}
	}	
	}
	
	
}

public void fillSkeletons() {
	x=75;
	y=50;	
	for(int i=0;i<mapsize.length;i++) {
	x=75;	
	y+=40;	
	for(int j=0;j<mapsize.length;j++) {
	randval = rand.nextInt(100)+1;

	if(randval<=30 ) {
	//Skeleton added to specific coordinates	
	skeletonX[j]=x;
	skeletonY[i]=y;
	x+=75;	
	}
	}	
	}
	
	
}




public void addSpider(int a, int b) {

}


public int checkTreasure(int a, int b, int x, int y) {
if(coinX[b]==x && coinY[a]==y) {
return 0;	
}
return -1;
}


public int checkMonster(int a, int b, int x, int y) {
//If room contains a spider	
if(spiderX[b] ==x && spiderY[a]==y) {
handler.newSpider();
return 0;
}


//if Room contains an orc
else if(orcX[b]==x && orcY[a]==y) {
handler.newOrc();
return 1;
}
//If Room contain a skeleton
else if(skeletonX[b]==x && orcY[a]==y) {
handler.newSkeleton();
return 2;
}

//If room contain an orc and a spider
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
if(skeletonX[a]>0 && skeletonY[b]>0) {
return true;	
}
return false;
}	
public boolean  getTrolls(int a, int b) {
if(trollX[a]>0 && trollY[b]>0) {
return true;	
}
return false;
}
public boolean getMonster(int n) {
return monster[n];	
}
}















