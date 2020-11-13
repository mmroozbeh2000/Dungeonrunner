package fruitlist;

public class Fruits {
    
    //instansvariabler
    private String name;
    private String fruit;
    private int total;
    
    public Fruits (String name, String fruit, int total){
    this.name = name;
    this.fruit = fruit;
    this.total = total;
}
    
    public Fruits (String name, String fruit){
    this.name = name;
    this.fruit = fruit;
}
    
    public String getName(){
        return name;
    }
    
    public void setName(String name) {
        this.name = name;        
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) { //är det här jag ska lägga in nedan if-sats?
        this.total = total;
    }
    
    //toString är för att programmet ska skriva ut läsbar text (och inte bara minneskoden där objektet är sparat)
    @Override
    public String toString() {
        return name + "#" + fruit + "#" + total;        
    } 
}
