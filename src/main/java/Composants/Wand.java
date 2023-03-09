package Composants;


import java.util.Scanner;
import lombok.*;
@Getter @Setter
public class Wand {
    Core core;
    static int size;
    
    public static void chooseWand(){
        Wand wand = new Wand();
    }

    public static void chooseCore(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the core of your wand :");
        System.out.println(java.util.Arrays.asList(Core.values()));
        
        
    }

    public static void chooseSize(){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of your wand :");
        Wand.size = scanner.nextInt();
    }
}
