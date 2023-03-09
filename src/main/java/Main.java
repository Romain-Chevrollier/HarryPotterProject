import Composants.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        //introduction();
        //chooseName();
        chooseCore();


    }

    private static void introduction(){
        System.out.println("Welcome to Hogwarts !");
    }

    private static void chooseName(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your wizard name :");
        String name = scanner.nextLine();
    }

    private static void chooseWand(){
        int size = Wand.size;
    }
}
