package dungeonrunner;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Hanteraren {

static Entity Player;	
static Entity Spider;
static Entity Orc;
static boolean playerstatus;
static List<Entity> Entitylist = new LinkedList<>();	
List<mapBox> boxlist = new ArrayList<>();

public Hanteraren() {
	
}

public void setThief(){
Player = new Thief();	
playerstatus=true;
}
public void setKnight(){
Player = new Knight();
playerstatus=true;
}

public void setMage(){
Player = new Mage();
playerstatus=true;
}

public void newSpider(){
Spider = new Spider();
}
public void newTroll(){
Entitylist.add(new Troll());	
}

public void newSkeleton(){
Entitylist.add(new Skeleton());	
}

public void newOrc(){
Orc = new Orc();
}


public Entity getPlayer(){
return Player;	
}
public Entity getSpider() {
return Spider;	
}

public Entity getOrc() {
return Orc;	
}


public Entity getEntity(int n){
return Entitylist.get(n);
}

public boolean checkPlayer() {
return playerstatus;
}

public void removeEntity(int n) {
Entitylist.remove(n);	
}

}


