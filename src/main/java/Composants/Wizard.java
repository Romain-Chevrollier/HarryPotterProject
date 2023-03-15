package Composants;

import java.util.List;
import java.util.Scanner;
import lombok.Setter;
import lombok.Getter;

public class Wizard extends Character{
    @Getter @Setter static Pet pet;
    @Getter @Setter static Wand wand;
    @Getter @Setter static House house;
    @Getter @Setter int level;
    @Getter @Setter int xp;
    @Getter @Setter List<Potion> potions;
    @Getter @Setter List<Spell> knownSpells;


    void defend(){

    }

    public static void wizardTurn(Wizard wizard){
        menuWizardFight(wizard);
    }

    private static void menuWizardFight(Wizard wizard){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to do ? \n 1.Attack \n 2.Inventory");
        int numberChoice = scanner.nextInt();
        switch(numberChoice){
            case 1:
                Spell.chooseSpell(wizard);

            case 2:

        }
    }
}
