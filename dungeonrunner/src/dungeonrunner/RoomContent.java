package dungeonrunner;

import java.util.PriorityQueue;
import java.util.Random;

import javax.swing.JFrame;

public class RoomContent{

private Hanteraren handler;
private int x;
private int y;
private boolean monster[];
private int mapsize[][];

		
//Monster p� kartan
private int spiderX[];  //0
private int spiderY[]; 
private int orcX[]; // 1
private int orcY[];
private int skeletonX[];
private int skeletonY[];
private int trollX[];
private int trollY[];
///
//Skatter p� kartan
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


public RoomContent() {
	
}

public RoomContent(int a) { // Skapa m�jliga rutor f�r monster
handler = new Hanteraren();
rand = new Random();	
monster = new boolean[4];  //0: Spider, 1: Orc, 2: Skeleton, 3: Troll
mapsize = new int[a][a];
queue = new PriorityQueue<>();
//
//Monster
spiderX = new int[a*a];
spiderY = new int[a*a];
orcX = new int[a*a];
orcY = new int[a*a];
skeletonX = new int[a*a];
skeletonY = new int[a*a];
trollX = new int[a*a];
trollY = new int[a*a];
//Skatter
coinX = new int[a*a];
coinY= new int[a*a];
coinpurseX = new int[a*a];
coinpurseY= new int[a*a];
goldX = new int[a*a];
goldY = new int[a*a];
jewelryX = new int[a*a];
jewelryY= new int[a*a];
treasurechestX = new int[a*a];
treasurechestY = new int[a*a];
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
fillTrolls();
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


public int getOrcX(int n) {
return  orcX[n];	
}
public int getOrcY(int n) {
return orcY[n];	
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

if(randval>=99 ) {
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

	if(randval>=99) {
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

	if(randval<=5 ) {
	//Skeleton added to specific coordinates	
	skeletonX[j]=x;
	skeletonY[i]=y;
	x+=75;	
	}
	}	
	}
	
	
}

public void fillTrolls() {
	x=75;
	y=50;	
	for(int i=0;i<mapsize.length;i++) {
	x=75;	
	y+=40;	
	for(int j=0;j<mapsize.length;j++) {
	randval = rand.nextInt(100)+1;

	if(randval>=50 ) {
	//Troll added to specific coordinates	
	trollX[j]=x;
	trollY[i]=y;
	x+=75;	
	}
	}	
	}
	
	
}







public int checkTreasure(int a, int b, int x, int y) { //a = i, b = y, x = handler.getplayer.getX(); y = handler.getplayer.getY() i drawWindow d�r den kallas p�
if(coinX[b]==x && coinY[a]==y) {
return 20;	
}
return -1;
}



public int checkMonster(int a, int b, int x, int y) { //a = i, b = y, x = handler.getplayer.getX(); y = handler.getplayer.getY() i drawWindow d�r den kallas p�
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
else if(skeletonX[b]==x && skeletonY[a]==y){
handler.newSkeleton();
return 2;
}

else if(trollX[b]==x && trollY[a]==y){
handler.newTroll();
return 3;
}

//If room contain an orc and a spider
else if(spiderX[b]==x && spiderY[a]==y && orcX[b]==x && orcY[a]==y) {
handler.newSpider();
handler.newOrc();
return 10;	
}


return -1;
}



public void removeSpider(int a, int b) {
spiderX[a]=0;
spiderY[b]=0;
}
public void removeOrc(int a, int b) {
orcX[a]=0;
orcY[b]=0;
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















