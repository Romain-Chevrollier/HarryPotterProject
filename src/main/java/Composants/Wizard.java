package Composants;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Objects;
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


    public boolean wizardTurn(AbstractEnemy enemyOrBoss) {
        boolean stateOfFight = this.endFight(enemyOrBoss);
        if (!stateOfFight) {
            this.menuWizardFight(enemyOrBoss);
            this.showHealth(enemyOrBoss);
            //System.out.println("The enemy has " + enemy.getCurrentHealth() + " health point");
        }
        return stateOfFight;
    }

    private void menuWizardFight(AbstractEnemy enemyOrBoss) {
        Scanner scanner = new Scanner(System.in);
        boolean testUseTurn = true;
        while (testUseTurn) {
            System.out.println("It's your turn. \nWhat do you want to do ? \n 1.Attack \n 2.Inventory");
            String numberChoice = scanner.nextLine();
            switch (numberChoice) {
                case "1" -> {
                    Spell choosedSpell = this.chooseSpell(enemyOrBoss);
                    if (!(Objects.equals(choosedSpell.getName(), "Exit Spell"))) {
                        this.useSpell(choosedSpell, enemyOrBoss);
                        testUseTurn = false;
                    }
                }
                case "2" -> {
                    Potion choosedPotion = this.choosePotion(enemyOrBoss);
                    if (!(Objects.equals(choosedPotion.getName(), "Exit Inventory"))) {
                        this.usePotion(choosedPotion);
                        testUseTurn = false;
                    }
                }
            }
        }
    }

    public void manageXp(int dropXp) {
        int wizardXp = this.getXp();
        int xpNeeded = this.getLevel() * 100;
        if (wizardXp < xpNeeded) {
            if (dropXp >= xpNeeded - wizardXp) {
                this.setXp(xpNeeded - wizardXp + dropXp);
                System.out.println("You dropped " + dropXp + " point of experience");
                xpNeeded = this.wizardLevelUp(xpNeeded, wizardXp, dropXp);
                System.out.println("You need " + (xpNeeded - this.getXp()) + " point of experience to level up");
            } else {
                this.setXp(wizardXp + dropXp);
                System.out.println("You dropped " + dropXp + " point of experience");
                System.out.println("You need " + (xpNeeded - this.getXp()) + " point of experience to level up");
            }
        }
    }

    private int wizardLevelUp(int xpNeeded, int wizardXp, int dropXp) {
        this.setLevel(this.getLevel() + 1);
        System.out.println("You gain a level. You are now level : " + this.getLevel());
        System.out.println("You gain 10 health and 3 attack power");
        this.setMaxHealth(this.getMaxHealth() + 10);
        this.setAttackPower(this.getAttackPower() + 3);
        this.setXp(dropXp - xpNeeded - wizardXp);
        return xpNeeded+100;
    }

    public void menu(int numberChapter) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You have the choice between : \n 1.Learning a new spell \n 2.Fight an enemy \n 3.Challenge the next chapter");
        String numberChoice = scanner.nextLine();
        switch (numberChoice) {
            case "1" -> this.learnSpell();
            case "2" -> {
                Enemy enemy = Enemy.createEnemy(numberChapter);
                this.simpleFight(enemy);
            }
            case "3" -> this.nextChapter();
        }
    }

    public void simpleFight(AbstractEnemy enemyOrBoss) {
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
            if(Objects.equals(enemyOrBoss.getName(), "Troll")){
                this.setNumberChapter(this.getNumberChapter()+1);
            }
            System.out.println("You won the battle");
            this.manageXp(enemyOrBoss.getDropXp());
            this.dropPotion();
            return true;
        }
        return false;
    }

    private void nextChapter() {
        switch (this.getNumberChapter()) {
            case 0 -> this.chapterNumberOne();
            case 1 -> this.chapterNumberTwo();
        }
    }

    private void chapterNumberOne() {
        Boss troll = Boss.createTroll();
        this.simpleFight(troll);
    }

    private void chapterNumberTwo(){
        Boss basilic = Boss.createBasilic();
        this.simpleFight(basilic);
    }

    public void showHealth(AbstractEnemy enemyOrBoss) {
        System.out.println("+" + "-".repeat(31) + "+");
        System.out.printf("|%-5s %-10s %-8s %-5s|%n", "", this.getName(), enemyOrBoss.getName(), "");
        System.out.printf("|%-5s %-10s %-8s %-5s|%n", "", this.getCurrentHealth() + "/" + this.getMaxHealth(), enemyOrBoss.getCurrentHealth() + "/" + enemyOrBoss.getMaxHealth(), "");
        System.out.println("+" + "-".repeat(31) + "+");
    }


    // ==================================================Function about Spell===============================================
    public Spell chooseSpell(AbstractEnemy enemyOrBoss){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What spell do you want to use ?");
        List<Spell> knownSpells = this.getKnownSpells();
        if (this.getHouse() == House.Gryffondor && enemyOrBoss.getName() == "Basilic" && enemyOrBoss.getCurrentHealth() <= enemyOrBoss.getMaxHealth()/2){
            Spell.learnSwordOfGryffondor(knownSpells);
            System.out.println("testetstetetsttetstt");
        }
        int count = 1;
        for (Spell i : knownSpells) {
            System.out.print(count + ".");
            System.out.println(i.getName());
            count += 1;
        }
        int numberSpell = scanner.nextInt();
        return knownSpells.get(numberSpell - 1);
    }


    public void useSpell(Spell choosedSpell, AbstractEnemy enemyOrBoss) {
        Random PRNG = new Random();
        int Acc = choosedSpell.getAccuracy();
        int dividedDamage = choosedSpell.getDividedDamage();

        if (PRNG.nextInt(100) < Acc) {

            int wizardAttackPower = this.getAttackPower();
            int realDamage = wizardAttackPower - (wizardAttackPower * dividedDamage / 100);
            realDamage = damageBoostWingardiumOnTroll(realDamage, choosedSpell);
            if (choosedSpell.getName() == "Sword of Gryffondor"){
                realDamage = 999;
            }
            int hpOfEnemyAfterDamage = enemyOrBoss.getCurrentHealth() - realDamage;
            if (hpOfEnemyAfterDamage < 0){
                enemyOrBoss.setCurrentHealth(0);
            }else{
                enemyOrBoss.setCurrentHealth(enemyOrBoss.getCurrentHealth() - realDamage);
            }

            System.out.println("You choosed the spell " + choosedSpell.getName());
            System.out.println("You dealt " + realDamage + " damage to the " + enemyOrBoss.getName());

        } else {
            System.out.println("You missed !");
        }
    }
    public int damageBoostWingardiumOnTroll(int realDamage, Spell choosedSpell){
        if (this.getName() == "Troll" && choosedSpell.getName() == "Wingardium Leviosa") {
            realDamage *= 2;
        }
        return realDamage;
    }


    public void learnSpell() {
        int wizardLevel = this.getLevel();
        List<Spell> knownSpells = this.getKnownSpells();
        boolean test = false;
        switch (wizardLevel) {
            case 1 -> {
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
            }
            case 2 -> {
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
            }
            case 3 -> {
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
            }
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
        System.out.println("Choose what you want to use");
        boolean testToGoOutOfWhile = false;
        Potion thePotionInTheList;
        do {
            String choosedPotion = scanner.nextLine();
            thePotionInTheList = listOfPotions.get(Integer.parseInt(choosedPotion) - 1);
            if (thePotionInTheList.getNumberOfPotion() == 0) {
                System.out.println("You don't have any " + thePotionInTheList.getName() + " in your inventory");
                System.out.println("Please choose another one or close your inventory.");
            } else {
                testToGoOutOfWhile = true;
            }
        } while (!testToGoOutOfWhile);

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