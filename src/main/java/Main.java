import Composants.*;

import java.util.ArrayList;
import java.util.Scanner;

import static Composants.Enemy.simpleFight;
import static Composants.Spell.learnSpell;

public class Main {
    public static void main(String[] args){
        introduction();
        Wizard wizard = createWizard();
        Spell.learnBasicSpell(wizard.getKnownSpells());
        Wizard.menu(wizard,0);
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
        wizard.setLevel(1);
        wizard.setAttackPower(12);
        wizard.setKnownSpells(new ArrayList<>());
        wizard.setPotions(new ArrayList<>());
        Potion.createPotion(wizard);
        return wizard;
    }

}
