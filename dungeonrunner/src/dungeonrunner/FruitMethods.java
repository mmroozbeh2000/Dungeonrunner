package fruitlist;

import static fruitlist.CreateObjects.fruitPicker;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FruitMethods {

    //metod spara till fil
    static void saveToFile() throws FileNotFoundException {
        try {
            PrintWriter outputFile = new PrintWriter("fruitpickers.txt");

            for (Fruits fruitPickerList : fruitPicker) {
                outputFile.println(fruitPickerList);
            }
            //kom ihåg att stänga filen
            outputFile.close();
        } catch (IOException e) { //fångar om filen inte finns
            System.out.println(e);
        }

    }

    //kör den här metoden när spelet startas för att läsa in spelarna till vår ArrayList
    static void readFromFile() throws FileNotFoundException { 
        String name;
        String fruit;
        int total;
        //öppna filen fruitpickers
        File inputFile = new File("fruitpickers.txt");
        Scanner scf = new Scanner(inputFile); //scanna in filen rad för rad
        while (scf.hasNext()) {
            String record = scf.nextLine(); //som en inspelning av varje rad
            Scanner scr = new Scanner(record); //scanna inspelningen (den specifika raden)
            scr.useDelimiter("#"); //dela in raden i respektive variabel

            name = scr.next();
            //System.out.println(name);
            fruit = scr.next();
            //System.out.println(fruit);
            total = scr.nextInt();
//            System.out.println(total);
            //scr.nextLine();
            Fruits f = new Fruits(name, fruit, total); //variablerna stoppas sen in i objektet
            fruitPicker.add(f); //objektet sparas till ArrayList
        }
    }

    //metod läsa in från fil
    static void readFile() throws FileNotFoundException {
        //int counter = 0;
        String name;
        String fruit;
        int total;
        //öppna filen fruitpickers
        File inputFile = new File("fruitpickers.txt");
        Scanner scan = new Scanner(inputFile);

        while (scan.hasNextLine()) {
            //counter = counter + 1;
            System.out.println(scan.nextLine());
        }
    }

    static void inReadArrayList() {
        //variables needed for this program
        String fileName = "fruitpickers.txt";
        String line;
        ArrayList aList = new ArrayList();

        //read the lines of text into an ArrayList
        try {
            BufferedReader input = new BufferedReader(new FileReader(fileName));
            if (!input.ready()) { //check whether the file can be read
                throw new IOException();
            }
            while ((line = input.readLine()) != null) { //read a line of text into the variable line
                aList.add(line); //add the line of text to the ArrayList                
            }
            //when the line is null, this loop will stop
            input.close();
        } catch (IOException e) { //catch any problems, e.g. file not found
            System.out.println(e);
        }

        //print out each item in the ArrayList
        int sz = aList.size();
        for (int i = 0; i < sz; i++) {
            System.out.println(aList.get(i).toString());
        }
        System.out.println("Object 2: " + aList.get(1).toString());
    }

    public static void displayFruitpickers() {

        System.out.println("\nAlla fruktplockare:");
        int i = 1;
        for (Fruits sub : fruitPicker) {
            System.out.println(i + ". " + sub);
            i++;
            //System.out.println("");
        }
    }

    static void countLinesInFile() {

    }

    //TODO metod att sortera så att högst antal frukt hamnar överst i listan när jag läst in fil
    static void sortListByHighscore() {

    }

    //TODO radera från arrayList
    static void removeFruitPicker() {

    }

    static int numberOfFruits(int amountFruit) {
        int totalFruit = 2;

        if (amountFruit > 0) {
            totalFruit = totalFruit + amountFruit;
        }

        return totalFruit;
    }
}
