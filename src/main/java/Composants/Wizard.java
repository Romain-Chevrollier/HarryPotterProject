package Composants;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Scanner;

import static Composants.Enemy.simpleFight;
import static Composants.Spell.learnSpell;
@ToString
public class Wizard extends Character {
    @Getter
    @Setter
    Pet pet;
    @Getter
    @Setter
    Wand wand;
    @Getter
    @Setter
    House house;
    @Getter
    @Setter
    int level;
    @Getter
    @Setter
    int xp;
    @Getter
    @Setter
    List<Potion> potions;
    @Getter
    @Setter
    List<Spell> knownSpells;


    void defend() {

    }

    public boolean wizardTurn(Enemy enemy) {
        boolean stateOfFight = enemy.endFight(this);
        if (!stateOfFight) {
            this.menuWizardFight(enemy);
            this.showHealth(enemy);
            //System.out.println("The enemy has " + enemy.getCurrentHealth() + " health point");
        }
        return stateOfFight;
    }

    private void menuWizardFight(Enemy enemy) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("It's your turn. \nWhat do you want to do ? \n 1.Attack \n 2.Inventory");
        int numberChoice = scanner.nextInt();
        switch (numberChoice) {
            case 1:
                Spell choosedSpell = this.chooseSpell();
                this.useSpell(choosedSpell, enemy);
                break;
            case 2:
                Potion choosedPotion = this.choosePotion();
                this.usePotion(choosedPotion);
                break;
        }
    }

    public void manageXp(int dropXp) {
        int wizardXp = this.getXp();
        int xpNeeded = this.getLevel() * 100;
        if (wizardXp < xpNeeded) {
            if (dropXp > xpNeeded - wizardXp) {
                this.setXp(xpNeeded - wizardXp + dropXp);
                this.wizardLevelUp();
            } else {
                this.setXp(wizardXp + dropXp);
            }

        }
        System.out.println("You dropped " + dropXp + " point of experience");
        System.out.println("You need " + (xpNeeded - this.getXp()) + " point of experience to level up");
    }

    private void wizardLevelUp() {
        this.setMaxHealth(this.getMaxHealth() + 10);
        this.setAttackPower(this.getAttackPower() + 3);
    }

    public void menu(int numberChapter) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You have the choice between : \n 1.Learning a new spell \n 2.Fight an enemy \n 3.Challenge the next chapter");
        String numberChoice = scanner.nextLine();
        switch (numberChoice) {
            case "1":
                this.learnSpell();
                break;
            case "2":
                this.simpleFight(numberChapter);
                break;
            case "3":
                nextChapter();
                break;
        }
    }

    public void simpleFight(int numberChapter) {
        Enemy enemy = Enemy.createEnemy(numberChapter);
        this.setCurrentHealth(this.getMaxHealth());
        enemy.setCurrentHealth(enemy.getMaxHealth());
        this.showHealth(enemy);
        boolean stateOfFight = false;
        while (!stateOfFight) {
            stateOfFight = this.wizardTurn(enemy);
            enemy.enemyTurn(this);
        }
        this.menu(0);
    }

    private void nextChapter() {

    }

    public void showHealth(Enemy enemy) {
        System.out.println(String.format("+" + "-".repeat(31) + "+"));
        System.out.println(String.format("|%-5s %-10s %-8s %-5s|","", this.getName(),enemy.getName(),""));
        System.out.println(String.format("|%-5s %-10s %-8s %-5s|","", this.getCurrentHealth() + "/" + this.getMaxHealth() ,enemy.getCurrentHealth() + "/" + enemy.getMaxHealth(),""));
        System.out.println(String.format("+" + "-".repeat(31) + "+"));
    }
}
