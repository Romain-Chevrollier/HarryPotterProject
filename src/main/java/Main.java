import Composants.*;

import java.util.Scanner;

import static Composants.Spell.learnSpell;

public class Main {
    public static void main(String[] args){
        //introduction();
        Wizard wizard = createWizard();


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

    private static Wizard createWizard(){
        Wizard wizard = new Wizard();
        wizard.setName(chooseName());
        wizard.setPet(Pet.choosePet());
        wizard.setWand(Wand.chooseWand());
        wizard.setHouse(SortingHat.chooseHouse());
        wizard.setMaxHealth(50);
        wizard.setXp(0);
        return wizard;
    }

    private static void menu(Wizard wizard){
        Scanner scanner = new Scanner(System.in);
        System.out.print("You have the choice between : 1.Learning a new spell 2.Fight an ennemy 3.Challenge the next chapter");
        int numberChoice = scanner.nextInt();
        switch(numberChoice){
            case 1:
                learnSpell(wizard);
                break;
            case 2:
                simpleFight();
                break;
            case 3:
                nextChapter();
                break;
        }
    }




    private static void nextChapter(){

    }
}
