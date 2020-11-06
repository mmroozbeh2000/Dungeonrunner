package dungeonrunner;

public class AttackClass {
	
private Hanteraren handler;

public AttackClass() {
handler = new Hanteraren();

}



public void beginBattle(Entity e) {
if(handler.getPlayer().getInitiative()>e.getInitiative()) {
	
}
//e.setEndurance(e.getEndurance()-handler.getPlayer().getAttack());
}

public void doAttack() {
	
}

}
