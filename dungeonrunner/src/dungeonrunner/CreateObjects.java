package fruitlist;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CreateObjects {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Fruits> fruitPicker = new ArrayList();

    public static void sampleFruitpickers() {
        Fruits a = new Fruits("Johan", "äpplen", 3);
        Fruits b = new Fruits("Karin", "apelsiner", 2);
        Fruits c = new Fruits("Niklas", "päron", 5);
        Fruits d = new Fruits("Rosanna", "äpplen", 7);

        fruitPicker.add(a);
        fruitPicker.add(b);
        fruitPicker.add(c);
        fruitPicker.add(d);

        for (Fruits fruitList : fruitPicker) {
            System.out.println("--------------------------" + fruitList);
        }
    }

    //metod för att skapa objekt och lägga in i ArrayList
    public static void newFruitpicker() throws FileNotFoundException {
        
        String name;
        String fruit;
        int total;
        System.out.println("Type your name: ");
        name = sc.next();
        System.out.println("Which fruit did you pick? ");
        fruit = sc.next();
        System.out.println("How many fruits did you pick today? ");
        total = sc.nextInt();
        sc.nextLine();

        Fruits f = new Fruits(name, fruit, total);
        fruitPicker.add(f);

        System.out.println("\nEn ny fruktplockare är skapad.");
    }
}
