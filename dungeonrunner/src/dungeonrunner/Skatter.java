package dungeonrunner;

public class Skatter {
	
	
    public static void main(String[] args) {
        int score = 0;
        score = skatt(score);
        System.out.println(score);
    }
    
    public static int randomHundred() {
        return (int)(Math.random() * 100 + 1);
    }
    
    public static int skatt(int score) {
        if(randomHundred() <= 40) {
            System.out.println("Hittade Lösa Slantar!");
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
            System.out.println("Hittade Ädelsten!");
            score = score + 14;
        }
        if(randomHundred() <= 5) {
            System.out.println("Hittade Liten skattkista!");
            score = score + 20;
        }
        return score;
    }
    
}