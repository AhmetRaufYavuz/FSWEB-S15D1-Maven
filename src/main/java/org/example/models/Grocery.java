package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {

    Scanner scanner = new Scanner(System.in);

    public static ArrayList<String> groceryList = new ArrayList<>();

    public void startGrocery(){
        int x = 0;

        do{
            System.out.println(" Yapılmak istenen işlemi seçiniz.");
            x = scanner.nextInt();
            scanner.nextLine();

            switch (x){
                case 1:
                    System.out.println("Eklenmesini istediğiniz elemanları giriniz.");
                    String itemsToAdd = scanner.nextLine();
                    addItems(itemsToAdd);
                    printSorted();
                    break;
                case 2:
                    System.out.println("Çıkarılmasını istediğiniz elemanları giriniz.");
                    String itemsToRemove = scanner.nextLine();
                    removeItems(itemsToRemove);
                    printSorted();
                    break;
            }

        }
        while (x != 0);

        scanner.close();

    }

    public static void removeItems(String itemsToRemove) {
        String[] splitedItems = itemsToRemove.split(",");
        for(String item : splitedItems) {
            item = item.trim();
            if (checkItemIsInList(item)){
                groceryList.remove(item);
            }else{
                System.out.println( item +" listede yok zaten knks.");
            }
        }
        sortItems();;
    }

    public static void addItems(String itemsToAdd) {
        String[] splitedItems = itemsToAdd.split(",");
        for(String item : splitedItems) {
            item = item.trim();
            if (checkItemIsInList(item)){
                System.out.println( item +" zaten listede.");
            }else{
                groceryList.add(item);
            }

        }

        sortItems();;

    }

    public static boolean checkItemIsInList(String item){
            return groceryList.contains(item);
    }

    public static void printSorted (){
        sortItems();
        System.out.println("Pazar Listesi: " );
        for (String item : groceryList){
            System.out.println(item);
        }


    }

    public static void sortItems() {
        Collections.sort(groceryList);
    }


}
