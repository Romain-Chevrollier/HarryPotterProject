package Composants;

import java.util.List;
import java.util.Scanner;
import lombok.Setter;
import lombok.Getter;

import static Composants.Enemy.simpleFight;
import static Composants.Spell.learnSpell;

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

    public static boolean wizardTurn(Wizard wizard, Enemy enemy){
        boolean stateOfFight = Enemy.endFight(wizard, enemy);
        if (!stateOfFight){
            menuWizardFight(wizard,enemy);
            System.out.println("The enemy has " + enemy.getCurrentHealth() + " health point");
        }
        return stateOfFight;
    }

    private static void menuWizardFight(Wizard wizard,Enemy enemy){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to do ? \n 1.Attack \n 2.Inventory");
        int numberChoice = scanner.nextInt();
        switch(numberChoice){
            case 1:
                Spell choosedSpell = Spell.chooseSpell(wizard);
                Spell.useSpell(choosedSpell, enemy, wizard);
                break;
            case 2:
                break;
        }
    }

    public static void manageXp(Wizard wizard, Enemy enemy){
        int wizardXp = wizard.getXp();
        int enemyDropXp = enemy.getDropXp();
        int xpNeeded = wizard.getLevel() * 100;
        if (wizardXp < xpNeeded){
            if (enemyDropXp > xpNeeded - wizardXp){
                wizard.setXp(xpNeeded - wizardXp + enemyDropXp);
                wizardLevelUp(wizard);
            }else{
                wizard.setXp(wizardXp + enemyDropXp);
            }

        }
        System.out.println("You dropped " + enemyDropXp + " point of experience");
        System.out.println("You need " + (xpNeeded - wizard.getXp()) + " point of experience to level up");
    }

    private static void wizardLevelUp(Wizard wizard){
        wizard.setMaxHealth(wizard.getMaxHealth() + 10);
        wizard.setAttackPower(wizard.getAttackPower() + 3);
    }

    public static void menu(Wizard wizard,int numberChapter){
        Scanner scanner = new Scanner(System.in);
        System.out.println("You have the choice between : \n 1.Learning a new spell \n 2.Fight an enemy \n 3.Challenge the next chapter");
        int numberChoice = scanner.nextInt();
        switch(numberChoice){
            case 1:
                learnSpell(wizard);
                break;
            case 2:
                simpleFight(wizard,numberChapter);
                break;
            case 3:
                nextChapter();
                break;
        }
    }

    private static void nextChapter(){

    }
}
