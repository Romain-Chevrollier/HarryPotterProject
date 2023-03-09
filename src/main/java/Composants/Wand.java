package Composants;


import java.util.Scanner;
import lombok.*;
@Getter @Setter
public class Wand {
    Core core;
    static int size;
    
    public static void chooseWand(){

    }

    public static void chooseCore(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the core of your wand :");
        System.out.println(java.util.Arrays.asList(Core.values()));
        int numberCore = scanner.nextInt();
        
    }

    public static void chooseSize(){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of your wand :");
        Wand.size = scanner.nextInt();
    }
}
