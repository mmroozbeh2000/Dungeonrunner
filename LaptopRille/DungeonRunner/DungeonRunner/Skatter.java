package DungeonRunner;

public class Skatter {
	
	
    public static int randomHundred() {
        return (int)(Math.random() * 100 + 1);
    }
    
    public static void skatt() {
        //score = getScore från karaktären
        //treasureCount = getTreasureCount från karaktären
        if(randomHundred() <= 40) {
            System.out.println("Hittade Lösa Slantar!");
            score = score + 2;
            treasureCount = treasureCount + 1;
        }
        if(randomHundred() <= 20) {
            System.out.println("Hittade Pengapung!");
            score = score + 6;
            treasureCount = treasureCount + 1;
        }
        if(randomHundred() <= 15) {
            System.out.println("Hittade Guldsmycken!");
            score = score + 10;
            treasureCount = treasureCount + 1;
        }
        if(randomHundred() <= 10) {
            System.out.println("Hittade Ädelsten!");
            score = score + 14;
            treasureCount = treasureCount + 1;
        }
        if(randomHundred() <= 5) {
            System.out.println("Hittade Liten skattkista!");
            score = score + 20;
            treasureCount = treasureCount + 1;
        }
        //setScore(score)
        //setTreasureCount(treasureCount)
    }
    
}