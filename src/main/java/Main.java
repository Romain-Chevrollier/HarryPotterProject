import Composants.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        //introduction();
        createWizard();


    }


    private static void introduction(){
        System.out.println("Welcome to Hogwarts !");
    }

    private static String chooseName(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your wizard name :");
        String name = scanner.nextLine();
        return name;
    }

    private static void createWizard(){
        String name = chooseName();
        Pet pet = Wizard.choosePet();
        Wand wand = Wand.chooseWand();
        House house = SortingHat.chooseHouse();
        System.out.println(name + pet + wand + house);
    }
}
