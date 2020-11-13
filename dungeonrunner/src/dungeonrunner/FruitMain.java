package fruitlist;

import java.io.FileNotFoundException;

public class FruitMain {

    public static void main(String[] args) throws FileNotFoundException {
        
//        CreateObjects.newFruitpicker();
//        CreateObjects.newFruitpicker();
//        FruitMethods.saveToFile();
        
          FruitMethods.readFromFile();
        //FruitMethods.displayFruitpickers();
//          
          CreateObjects.newFruitpicker();
//        CreateObjects.newFruitpicker();
//        CreateObjects.newFruitpicker();
//        FruitMethods.displayFruitpickers();
        //CreateObjects.newFruitpicker();
        
        //CreateObjects.fruitPicker.remove(0);
        
        //System.out.println("Hela listan: " + CreateObjects.fruitPicker);
        
        FruitMethods.displayFruitpickers();     
        FruitMethods.saveToFile();
       
        
          
  
        
//        // lägger in Fruits-klassen som en array 
//        Fruits fruitArray[] = new Fruits[20];
//
//        //ArrayList<Object> fruitList = new ArrayList();
//        Scanner sc = new Scanner(System.in);
//        String name;
//        String fruit;
//        int total;
//        int count = 0;
//        
//        
//
//        File inputFile = new File("fruitpickers.txt");
//        Scanner scf = new Scanner(inputFile);
//        while (scf.hasNext()) {
//            String record = scf.nextLine();
//            Scanner scr = new Scanner(record);
//            scr.useDelimiter("|");
//
//            name = scr.next();
//            fruit = scr.next();
//            total = scr.nextInt();
//            Fruits f = new Fruits(name, fruit, total);
//
//            if (count < 20) {
//                fruitArray[count] = f;
//                count++;
//            }
//        }
//
//        System.out.println("All fruit pickers: ");
//        for (Fruits fruitpicker : fruitArray) {
//            if (fruitpicker != null) {
//                System.out.println(fruitpicker.getName()+ " | "
//                        + fruitpicker.getFruit()+ " | "
//                        + fruitpicker.getTotal());
//            }
//            
//            
//        }
        

//        System.out.println("Type name: ");
//        name = sc.nextLine();
//        System.out.println("Type fruit: ");
//        fruit = sc.nextLine();
//        System.out.println("Type total fruit: ");
//        total = sc.nextInt();
//        sc.nextLine();
        //Fruits f = new Fruits(name, fruit, total);
        //fruitList.add(f);
    }
}
