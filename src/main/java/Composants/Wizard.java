package Composants;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

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
    int numberChapter;
    @Getter
    @Setter
    List<Potion> potions;
    @Getter
    @Setter
    List<Spell> knownSpells;


    void defend() {

    }

    public boolean wizardTurn(AbstractEnemy enemyOrBoss) {
        boolean stateOfFight = this.endFight(enemyOrBoss);
        if (!stateOfFight) {
            this.menuWizardFight(enemyOrBoss);
            this.showHealth(enemyOrBoss);
            //System.out.println("The enemy has " + enemy.getCurrentHealth() + " health point");
        }
        return stateOfFight;
    }
//TODO Faire un moyen de sortir de l'inventaire et de l'attaque mais sans perdre son tour !
    private void menuWizardFight(AbstractEnemy enemyOrBoss) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("It's your turn. \nWhat do you want to do ? \n 1.Attack \n 2.Inventory");
        int numberChoice = scanner.nextInt();
        switch (numberChoice) {
            case 1:
                Spell choosedSpell = this.chooseSpell();
                this.useSpell(choosedSpell, enemyOrBoss);
                break;
            case 2:
                Potion choosedPotion = this.choosePotion(enemyOrBoss);
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
                Enemy enemy = Enemy.createEnemy(numberChapter);
                this.simpleFight(this.getNumberChapter(), enemy);
                break;
            case "3":
                this.nextChapter();
                break;
        }
    }

    public void simpleFight(int numberChapter, AbstractEnemy enemyOrBoss) {
        this.setCurrentHealth(this.getMaxHealth());
        enemyOrBoss.setCurrentHealth(enemyOrBoss.getMaxHealth());
        this.showHealth(enemyOrBoss);
        boolean stateOfFight = false;
        while (!stateOfFight) {
            stateOfFight = this.wizardTurn(enemyOrBoss);
            enemyOrBoss.enemyTurn(this);
        }
        this.menu(this.getNumberChapter());

    }

    public boolean endFight(AbstractEnemy enemyOrBoss) {
        if (this.getCurrentHealth() <= 0) {
            System.out.println("You died");
            return true;
        } else if (enemyOrBoss.getCurrentHealth() <= 0) {
            System.out.println("You won the battle");
            this.manageXp(enemyOrBoss.getDropXp());
            this.dropPotion();
            return true;
        }
        return false;
    }

    private void nextChapter() {
        switch (this.getNumberChapter()) {
            case 0:
                this.chapterNumberOne();
                break;
        }

    }

    private void chapterNumberOne() {
        Boss basilic = Boss.createBasilic();
        simpleFight(this.getNumberChapter(), basilic);
    }

    public void showHealth(AbstractEnemy enemyOrBoss) {
        System.out.println(String.format("+" + "-".repeat(31) + "+"));
        System.out.println(String.format("|%-5s %-10s %-8s %-5s|", "", this.getName(), enemyOrBoss.getName(), ""));
        System.out.println(String.format("|%-5s %-10s %-8s %-5s|", "", this.getCurrentHealth() + "/" + this.getMaxHealth(), enemyOrBoss.getCurrentHealth() + "/" + enemyOrBoss.getMaxHealth(), ""));
        System.out.println(String.format("+" + "-".repeat(31) + "+"));
    }


    // ==================================================Function about Spell===============================================
    public Spell chooseSpell() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What spell do you want to use ?");
        List<Spell> knownSpells = this.getKnownSpells();
        int count = 1;
        for (Spell i : knownSpells) {
            System.out.print(count + ".");
            System.out.println(i.getName());
            count += 1;
        }
        int numberSpell = scanner.nextInt();
        Spell choosedSpell = knownSpells.get(numberSpell - 1);
        return choosedSpell;
    }


    public void useSpell(Spell choosedSpell, AbstractEnemy enemyOrBoss) {
        Random PRNG = new Random();
        int Acc = choosedSpell.getAccuracy();
        int dividedDamage = choosedSpell.getDividedDamage();

        if (PRNG.nextInt(100) < Acc) {
            int wizardAttackPower = this.getAttackPower();
            int realDamage = wizardAttackPower - (wizardAttackPower * dividedDamage / 100);
            if (enemyOrBoss.getName() == "Basilic" && choosedSpell.getName() == "Wingardium Leviosa"){
                realDamage *= 2;
                System.out.println("test");
            }
            enemyOrBoss.setCurrentHealth(enemyOrBoss.getCurrentHealth() - realDamage);
            System.out.println("You choosed the spell " + choosedSpell.getName());
            System.out.println("You dealt " + realDamage + " damage to the " + enemyOrBoss.getName());
        } else {
            System.out.println("You missed !");
        }
    }


    public void learnSpell() {
        int wizardLevel = this.getLevel();
        List<Spell> knownSpells = this.getKnownSpells();
        boolean test = false;
        switch (wizardLevel) {
            case 1:
                for (Spell i : knownSpells) {
                    if (i.getName().equals("Wingardium Leviosa")) {
                        test = true;
                    }
                }
                if (!test) {
                    Spell.learnWingardiumLeviosa(this.getKnownSpells());
                } else {
                    System.out.println("You already know all the spell available for your level.\n If you want more spell you can do Simple Fight or Challenge the next chapter to level up.");
                }
                break;

            case 2:
                for (Spell i : knownSpells) {
                    if (i.getName().equals("Accio")) {
                        test = true;
                    }
                }
                if (!test) {
                    Spell.learnAccio(this.getKnownSpells());
                } else {
                    System.out.println("You already know all the spell available for your level.\n If you want more spell you can do Simple Fight or Challenge the next chapter to level up.");
                }
                break;

            case 3:
                for (Spell i : knownSpells) {
                    if (i.getName().equals("Expecto Patronum")) {
                        test = true;
                    }
                }
                if (!test) {
                    Spell.learnExpectoPatronum(this.getKnownSpells());
                } else {
                    System.out.println("You already know all the spell available for your level.\n If you want more spell you can do Simple Fight or Challenge the next chapter to level up.");
                }
                break;
        }
        this.menu(this.getNumberChapter());
    }

// ==================================================Function about Potion===============================================

    public Potion choosePotion(AbstractEnemy enemyOrBoss) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You are in you inventory :");
        List<Potion> listOfPotions = this.getPotions();
        System.out.println("You have :");
        int count = 1;
        for (Potion i : listOfPotions) {
            System.out.print(count + ".");
            System.out.print("  " + i.getNumberOfPotion());
            System.out.println(" " + i.getName());
            count += 1;
        }
        System.out.print(count + ".");
        System.out.println("Exit the inventory");
        System.out.println("Choose what you want to use");
        boolean testToGoOutOfWhile = false;
        Potion thePotionInTheList;
        do{
            String choosedPotion = scanner.nextLine();
            if (Integer.parseInt(choosedPotion) == count ){
                System.out.println("You go out of your inventory");
                menuWizardFight(enemyOrBoss);
            }
            thePotionInTheList = listOfPotions.get(Integer.parseInt(choosedPotion) - 1);
            if (thePotionInTheList.getNumberOfPotion() == 0){
                System.out.println("You don't have any " + thePotionInTheList.getName() + " in your inventory");
                System.out.println("Please choose another one or close your inventory.");
            }else{
                testToGoOutOfWhile = true;
            }
        }while(!testToGoOutOfWhile);

        return thePotionInTheList;

    }


    public void usePotion(Potion choosedPotion) {
        int wizardCurrentHealth = this.getCurrentHealth();
        int wizardMaxHealth = this.getMaxHealth();
        int potionNumberHealth = choosedPotion.getNumberHealth();
        if (wizardCurrentHealth + potionNumberHealth > wizardMaxHealth) {
            this.setCurrentHealth(wizardMaxHealth);
            choosedPotion.setNumberOfPotion(choosedPotion.getNumberOfPotion() - 1);
        } else {
            this.setCurrentHealth(wizardCurrentHealth + potionNumberHealth);
            choosedPotion.setNumberOfPotion(choosedPotion.getNumberOfPotion() - 1);

        }
    }

    public void dropPotion() {
        Random PRNG = new Random();
        int randomDrop = PRNG.nextInt(100);
        List<Potion> listPotion = this.getPotions();
        if (randomDrop <= 2) {
            System.out.println("you dropped a large potion");
            listPotion.get(2).setNumberOfPotion(listPotion.get(2).getNumberOfPotion() + 1);
            System.out.println("You now have " + listPotion.get(2).getNumberOfPotion() + " large potion");
        } else if (randomDrop <= 10) {
            System.out.println("you dropped a medium potion");
            listPotion.get(1).setNumberOfPotion(listPotion.get(1).getNumberOfPotion() + 1);
            System.out.println("You now have " + listPotion.get(1).getNumberOfPotion() + " medium potion");
        } else if (randomDrop <= 20) {
            System.out.println("you dropped a small potion");
            listPotion.get(0).setNumberOfPotion(listPotion.get(0).getNumberOfPotion() + 1);
            System.out.println("You now have " + listPotion.get(0).getNumberOfPotion() + " small potion");
        }
    }
}