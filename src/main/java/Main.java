import Composants.*;

import java.util.ArrayList;
import java.util.Scanner;
import Composants.Spell.*;
public class Main {
    public void main(String[] args){
        introduction();
        Wizard wizard = createWizard();
        wizard.learnBasicSpell(wizard.getKnownSpells());
        wizard.menu(0);
    }


    private static void introduction(){
        System.out.println("Welcome to Hogwarts !");
    }

    private String chooseName(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your wizard name :");
        String name = scanner.nextLine();
        return name;
    }

    private Wizard createWizard(){
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
