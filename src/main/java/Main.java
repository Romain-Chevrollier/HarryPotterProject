import Composants.*;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Scanner;

@ToString
public class Main {
    public static void main(String[] args){
        introduction();
        Wizard wizard = createWizard();
        Spell.learnExitSpell(wizard.getKnownSpells());
        Spell.learnBasicSpell(wizard.getKnownSpells());
        System.out.println("The goal is to beat the 7 chapter.\nYou can Learn new spell every time you level up.\nYou can fight with small enemies to drop potion xp to level up\nYou can also try and beat a new chapter.");
        wizard.menu(wizard.getNumberChapter());
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
        System.out.println("You are in " + wizard.getHouse() + ".");
        wizard.setMaxHealth(50);
        wizard.setXp(0);
        wizard.setLevel(1);
        wizard.setAttackPower(12);
        wizard.setKnownSpells(new ArrayList<>());
        wizard.setPotions(new ArrayList<>());
        wizard.setNumberChapter(1);
        Potion.createPotion(wizard);
        if (wizard.getHouse() == House.Slytherin){
            wizard.setAttackPower(wizard.getAttackPower()+10);
            System.out.println("Because you are in Slytherin you deal 10 bonus damage with your spell");
        }
        return wizard;
    }
}
