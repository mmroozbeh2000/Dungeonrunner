package dungeonrunner;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Hanteraren {

static Entity Player;	
static List<Entity> Entitylist = new LinkedList<>();	
List<mapBox> boxlist = new ArrayList<>();

public Hanteraren() {
	
}

public void setThief(){
Player = new Thief();	
}
public void setKnight(){
Player = new Knight();	
}

public void setMage(){
Player = new Mage();	
}

public void newSpider(){
Entitylist.add(new Spider());
}
public void newTroll(){
Entitylist.add(new Troll());	
}

public void newSkeleton(){
Entitylist.add(new Skeleton());	
}

public void newOrc(){
Entitylist.add(new Orc());
}


public Entity getPlayer(){
return Player;	
}


public Entity getEntity(int n){
return Entitylist.get(n);
}


public void removeEntity(int n) {
Entitylist.remove(n);	
}

}


