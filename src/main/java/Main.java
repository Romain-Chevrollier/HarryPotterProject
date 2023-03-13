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
        Wizard wizard = new Wizard();
        wizard.setName(chooseName());
        wizard.setPet(Pet.choosePet());
        wizard.setWand(Wand.chooseWand());
        wizard.setHouse(SortingHat.chooseHouse());
        wizard.setHealth(50);
        wizard.setXp(0);

    }
}
