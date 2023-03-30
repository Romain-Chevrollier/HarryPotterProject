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
                    if (!(Objects.equals(choosedSpell.getName(), "Exit Spell")) && !testChapterFour(choosedSpell,enemyOrBoss)) {
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
        return xpNeeded + 100;
    }

    public void menu(int numberChapter) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You have the choice between : \n 1.Learning a new spell \n 2.Fight an enemy \n 3.Challenge the next chapter" + "\n 4.Help" + "\nYou're at the chapter number " + this.getNumberChapter() + "/7" + "\n 4.Help");
        String numberChoice = scanner.nextLine();
        switch (numberChoice) {
            case "1" -> this.learnSpell();
            case "2" -> {
                Enemy enemy = Enemy.createEnemy(numberChapter);
                this.simpleFight(enemy);
            }
            case "3" -> this.nextChapter();
            case "4" -> this.help();
        }
    }
    private void help(){
        int numberChapter = this.getNumberChapter();
        switch(numberChapter){
            case 1 -> System.out.println("For the first chapter you will need to learn Wingardium Leviosa to deal additional damage. This spell will surely help you to defeat the troll.");
            case 2 -> System.out.println("For the second chapter you will need to learn accio. If you don't have the level to learn the spell go fight in the section 'Simple Fight'");
            case 3 -> System.out.println("For the third chapter you will need to learn Expecto Patronum because every other spell have no effect on dementor.");
            case 4 -> System.out.println("For the fourth chapter you will need to use accio during the fight to escape.");
            case 5 -> System.out.println("For the fifth chapter you will need to fight for 3 turn to use the fireworks.");
            case 6 -> System.out.println("For the sixth chapter you will can use the spell Sectumsempra to do additional damage. Or you can join force with the ennemy if you are in the Slytherin house");
            case 7 -> System.out.println("For the last chapter you will need to fight 2 bosses. If it's too hard, don't hesitate to level up in the 'Simple Fight' and come back later.");
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
            if (Objects.equals(enemyOrBoss.getName(), "Troll") || Objects.equals(enemyOrBoss.getName(), "Dementor")) {
                this.setNumberChapter(this.getNumberChapter() + 1);
            }
            System.out.println("You won the battle");
            this.manageXp(enemyOrBoss.getDropXp());
            this.dropPotion();
            if (enemyOrBoss.getName() == "Basilic") {
                this.testAccioChapterTwo(enemyOrBoss);
            }
            return true;
        }
        return false;
    }

    private void nextChapter() {
        switch (this.getNumberChapter()) {
            case 1 -> this.chapterNumberOne();
            case 2 -> this.chapterNumberTwo();
            case 3 -> this.chapterNumberThree();
            case 4 -> this.chapterNumberFour();
        }
    }

    private void chapterNumberOne() {
        Boss troll = Boss.createTroll();
        this.simpleFight(troll);
    }

    private void chapterNumberTwo() {
        Boss basilic = Boss.createBasilic();
        this.simpleFight(basilic);
    }
    private void chapterNumberThree(){
        Boss dementor = Boss.createDementor();
        this.simpleFight(dementor);
    }

    private void chapterNumberFour(){
        Boss voldemort = Boss.createVoldemort();
        this.simpleFight(voldemort);
    }

    private boolean testChapterFour(Spell choosedSpell, AbstractEnemy boss){

        boolean test = false;
        if (choosedSpell.getName() == "Accio" && boss.getName() == "Voldemort") {
            System.out.println("You have managed to escape the grasp of voldemort.");
            boss.setCurrentHealth(0);
            test = true;
        }
        return test;
    }


    private void testAccioChapterTwo(AbstractEnemy Boss) {
        System.out.println("You have defeated the basilic you now need to destroy the book of Tom Jedusor");
        List<Spell> listOfSpell = this.getKnownSpells();
        boolean test = false;
        for (Spell i : listOfSpell) {
            if (Objects.equals(i.getName(), "Accio")) {
                test = true;
                break;
            }
        }
        if (test) {
            Spell spell;
            do {
                System.out.println("Use Accio to get a fang from the dead basilic.");
                spell = this.chooseSpell(Boss);
                if (spell.getName() == "Accio") {
                    removeSwordOfGryffondor(listOfSpell);
                    System.out.println("You suscecfully obtained a fang of the basilic and destroyed the book.");
                    this.setNumberChapter(this.getNumberChapter() + 1);
                }
            } while (spell.getName() != "Accio");
        } else {
            removeSwordOfGryffondor(listOfSpell);
            System.out.println("You didn't learn Accio yet. \n Tom Jedusor has killed you.");
        }

    }

    public void showHealth(AbstractEnemy enemyOrBoss) {
        System.out.println("+" + "-".repeat(31) + "+");
        System.out.printf("|%-5s %-10s %-8s %-5s|%n", "", this.getName(), enemyOrBoss.getName(), "");
        System.out.printf("|%-5s %-10s %-8s %-5s|%n", "", this.getCurrentHealth() + "/" + this.getMaxHealth(), enemyOrBoss.getCurrentHealth() + "/" + enemyOrBoss.getMaxHealth(), "");
        System.out.println("+" + "-".repeat(31) + "+");
    }


    // ==================================================Function about Spell===============================================
    public Spell chooseSpell(AbstractEnemy enemyOrBoss) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What spell do you want to use ?");
        List<Spell> knownSpells = this.getKnownSpells();
        if (this.getHouse() == House.Gryffondor && enemyOrBoss.getName() == "Basilic" && enemyOrBoss.getCurrentHealth() <= enemyOrBoss.getMaxHealth() / 2) {
            boolean test = false;
            for (Spell i : knownSpells) {
                if (Objects.equals(i.getName(), "Sword of Gryffondor")) {
                    test = true;
                    break;
                }
            }
            if (!test) {
                Spell.learnSwordOfGryffondor(knownSpells);
            }
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

    private void removeSwordOfGryffondor(List<Spell> knownSpells){
        boolean test = false;
        Spell tampon = knownSpells.get(0);
        for (Spell i : knownSpells){
            if (i.getName() == "Sword of Gryffondor"){
                tampon = i;
                test = true;
            }
        }
        if (test){
            knownSpells.remove(tampon);
            this.setKnownSpells(knownSpells);
        }
    }

    public void useSpell(Spell choosedSpell, AbstractEnemy enemyOrBoss) {
        System.out.println("You choosed the spell " + choosedSpell.getName());
        Random PRNG = new Random();
        int Acc = choosedSpell.getAccuracy();
        int dividedDamage = choosedSpell.getDividedDamage();

        if (PRNG.nextInt(100) < Acc && !testSpellOnDementor(choosedSpell, enemyOrBoss)) {

            int wizardAttackPower = this.getAttackPower();
            int realDamage = wizardAttackPower - (wizardAttackPower * dividedDamage / 100);
            realDamage = damageBoostWingardiumOnTroll(realDamage, choosedSpell);
            if (choosedSpell.getName() == "Sword of Gryffondor") {
                realDamage = 999;
            }
            int hpOfEnemyAfterDamage = enemyOrBoss.getCurrentHealth() - realDamage;
            if (hpOfEnemyAfterDamage < 0) {
                enemyOrBoss.setCurrentHealth(0);
            } else {
                enemyOrBoss.setCurrentHealth(enemyOrBoss.getCurrentHealth() - realDamage);
            }
            System.out.println("You dealt " + realDamage + " damage to the " + enemyOrBoss.getName());

        } else {
            System.out.println("You missed your spell!");
        }
    }

    private boolean testSpellOnDementor(Spell choosedSpell, AbstractEnemy boss){
        return !Objects.equals(choosedSpell.getName(), "Expecto Patronum") && Objects.equals(boss.getName(), "Dementor");
    }


    private int damageBoostWingardiumOnTroll(int realDamage, Spell choosedSpell) {
        if (this.getName() == "Troll" && choosedSpell.getName() == "Wingardium Leviosa") {
            realDamage *= 2;
        }
        return realDamage;
    }


    public void learnSpell() {
        int wizardLevel = this.getLevel();
        List<Spell> knownSpells = this.getKnownSpells();

        switch (wizardLevel) {
            case 1 -> {

                if (!testKnownSpell(knownSpells, "Wingardium Leviosa")) {
                    Spell.learnWingardiumLeviosa(this.getKnownSpells());
                } else {
                    System.out.println("You already know all the spell available for your level.\n If you want more spell you can do Simple Fight or Challenge the next chapter to level up.");
                }
            }
            case 2 -> {
                if (!testKnownSpell(knownSpells, "Wingardium Leviosa")) {
                    Spell.learnWingardiumLeviosa(this.getKnownSpells());
                }else if (!testKnownSpell(knownSpells, "Accio")) {
                    Spell.learnAccio(this.getKnownSpells());
                } else {
                    System.out.println("You already know all the spell available for your level.\n If you want more spell you can do Simple Fight or Challenge the next chapter to level up.");
                }
            }
            case 3 -> {
                if (!testKnownSpell(knownSpells, "Wingardium Leviosa")) {
                    Spell.learnWingardiumLeviosa(this.getKnownSpells());
                }else if (!testKnownSpell(knownSpells, "Accio")) {
                    Spell.learnAccio(this.getKnownSpells());
                }else if (!testKnownSpell(knownSpells, "Expecto Patronum")) {
                    Spell.learnExpectoPatronum(this.getKnownSpells());
                } else {
                    System.out.println("You already know all the spell available for your level.\n If you want more spell you can do Simple Fight or Challenge the next chapter to level up.");
                }
            }
        }
        this.menu(this.getNumberChapter());
    }

    private boolean testKnownSpell(List<Spell> knownSpells, String nameOfSpell){
        boolean test = false;
        for (Spell i : knownSpells) {
            if (i.getName().equals(nameOfSpell)) {
                test = true;
                break;
            }
        }
        return test;
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