package dungeonrunner;

public class Skatter {
	

    
    public int randomHundred() {
        return (int)(Math.random() * 100 + 1);
    }
    
/*Skulle vilja g�ra om skatterna till en klass d�r varje typ av skatt har ett specifikt score v�rde.
t.ex getGold(), getCoin(), getcoinPurse().
   
*/
    
    public int skatt(int score) {
        if(randomHundred() <= 40) {
            System.out.println("Hittade L�sa Slantar!");
            score = score + 2;
        }
        if(randomHundred() <= 20) {
            System.out.println("Hittade Pengapung!");
            score = score + 6;
        }
        if(randomHundred() <= 15) {
            System.out.println("Hittade Guldsmycken!");
            score = score + 10;
        }
        if(randomHundred() <= 10) {
            System.out.println("Hittade �delsten!");
            score = score + 14;
        }
        if(randomHundred() <= 5) {
            System.out.println("Hittade Liten skattkista!");
            score = score + 20;
        }
        return score;
    }
    
}