package dungeonrunner;

import java.util.Random;

import javax.swing.JOptionPane;

public class RoomContent {

private Hanteraren handler;	

private boolean spider[][];
private boolean orc[][];
private boolean skeleton[][];
private boolean troll[][];
private Random rand;
private int randval;	

public RoomContent() { // Skapa möjliga rutor för monster
handler = new Hanteraren();
rand = new Random();	
spider = new boolean[4][4];
orc = new boolean[4][4];
skeleton = new boolean[4][4];
troll = new boolean[4][4];
fillSlots();
}



public void fillSlots() {
for(int i=0;i<4;i++) {

for(int j=0;j<4;j++) {
orc[i][j]=false;
spider[i][j]=false;
skeleton[i][j]=false;
troll[i][j]=false;
}	
}
}

public void addSpider(int a, int b) {
randval = rand.nextInt(10)+1;
if(randval==2) {
spider[a][b]=true;
handler.newSpider();
System.out.println("A spider!");
}

}



public void checkSpider(int a, int b) {


}



}







