package dungeonrunner;



import java.awt.Color;
import java.util.concurrent.ThreadLocalRandom;


public abstract class Entity {

    //bara för monster
    private int rarity;
	//Göra om till Private
    private int initiative;
    private int endurance;
    private int attack;
    private int flexibility;
    private ROLE role;
    //Ny kod
    private String name;
    protected int x;
    protected int y;

    //Lägga till attribut för score
    private double score;
    //Color
    protected Color color;
    
    //Constructor för spelkaraktär
    public Entity(int initiative, int endurance, int attack, int flexibility, ROLE role, Color color) {
        this.initiative = initiative;
        this.endurance = endurance;
        this.attack = attack;
        this.flexibility = flexibility;
        this.role=role;
        this.color=color;
     
    }
    //Constructor för monster
    public Entity(int initiative, int endurance, int attack, int flexibility, ROLE role, Color color, int rarity) {
    this.initiative = initiative;
    this.endurance = endurance;
    this.attack = attack;
    this.flexibility = flexibility;
    this.role=role;
    this.color=color;
    this.rarity = rarity;    
    }
    
    public Entity(ROLE role, int x, int y) {
    this.x=x;
    this.y=y;
    }
    
    public abstract int getX();
    public abstract int getY();

    public abstract void setY(int y);
    public abstract void setX(int x);
  

    public void setScore(double d) {
    this.score=d;	
    }
    
    public double getScore() {
    return score;	
    }
    
    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public int getAttack() {
        return attack;
    }
    
    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getFlexibility() {
        return flexibility;
    }

    public void setFlexibility(int flexibility) {
        this.flexibility = flexibility;
    }

    public int getRarity() {
        return rarity;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }
    

    
    public int rollTurnOrder() {
       int turnOrderResult = 0;
       
       for (int i = 0; i < initiative; i++) {
          int diceValue = ThreadLocalRandom.current().nextInt(1, 6);   
          turnOrderResult += diceValue;     
        }
            
        return turnOrderResult;
    }
    
    public int attackAttempt() {
         int AttackResult = 0;
        
         for (int i = 0; i < attack; i++) {
          int diceValue = ThreadLocalRandom.current().nextInt(1, 6);   
          AttackResult += diceValue;     
        }
           
        return AttackResult;
    }
    
    //Ny kod
    public void setName(String str) {
    name=str;	
    }
    
    public String getName() {
    return name;	
    }
    
    public void setRole(ROLE role) {
    this.role=role;	
    }
    public ROLE getRole() {
    return role;	
    }
    
    public Color getColor() {
    return color;	
    }
    
    ////
     public int dodgeAttempt() {
        int dodgeResult = 0;
        
        for (int i = 0; i < flexibility; i++) {
          int diceValue = ThreadLocalRandom.current().nextInt(1, 6);   
          dodgeResult += diceValue;     
        }
        
        return dodgeResult;
    } 
    
    public boolean escapeAttempt() {
        boolean escapeSuccesfull = false;
        
        int escapeChance =  flexibility * 10;
        
        int escapeAttempt = ThreadLocalRandom.current().nextInt(0, 100);
        
        if (escapeAttempt <= escapeChance) {
            escapeSuccesfull = true;    
        }
    
        return escapeSuccesfull;

    }
    
}
