package Composants;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Spell extends AbstractSpell {

    //static List<Spell> spellList = new ArrayList<Spell>();


    public static void learnSpell(Wizard wizard) {
        int wizardLevel = wizard.getLevel();
        ArrayList cloneKnownSpells = new ArrayList(wizard.getKnownSpells());
        switch (wizardLevel) {
            case 1:
                for (Object i : cloneKnownSpells) {
                    if (!i.equals("wingardiumLeviosa")) {
                        learnWingardiumLeviosa(wizard.getKnownSpells());
                    }
                }
                break;

            case 2:
                for (Object i : cloneKnownSpells) {
                    if (!i.equals("accio")) {
                        learnAccio(wizard.getKnownSpells());
                    }
                }
                break;

            case 3:
                for (Object i : cloneKnownSpells) {
                    if (!i.equals("expectoPatronum")) {
                        learnExpectoPatronum(wizard.getKnownSpells());
                    }
                }
                break;
        }
        Wizard.menu(wizard, 0);
    }

    public static Spell chooseSpell(Wizard wizard) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What spell do you want to use ?");
        List<Spell> knownSpells = wizard.getKnownSpells();
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

    public static void useSpell(Spell choosedSpell, Enemy enemy, Wizard wizard) {
        Random PRNG = new Random();
        int Acc = choosedSpell.getAccuracy();
        int dividedDamage = choosedSpell.getDividedDamage();

        if (PRNG.nextInt(100) < Acc) {
            int wizardAttackPower = wizard.getAttackPower();
            int realDamage = wizardAttackPower - (wizardAttackPower * dividedDamage / 100);
            enemy.setCurrentHealth(enemy.getCurrentHealth() - realDamage);
            System.out.println("You choosed the spell " + choosedSpell.getName());
            System.out.println("You dealt " + realDamage + " damage to the " + enemy.getName());
        } else {
            System.out.println("You missed !");
        }
    }

    public static void learnBasicSpell(List<Spell> knownSpells) {
        System.out.println("In this class you will learn your first spell. The basic spell.");
        System.out.println("What does the spell do ?");

        Spell basicSpell = new Spell();
        basicSpell.setName("Basic Spell");
        basicSpell.setDescription("Shoot a small ball of concentrated magic.");
        basicSpell.setAccuracy(100);
        basicSpell.setDividedDamage(50);

        knownSpells.add(basicSpell);
    }

    private static void learnWingardiumLeviosa(List<Spell> knownSpells) {
        System.out.print("In this class you will learn Wingardium Leviosa.");
        System.out.print("What does the spell do ?");

        Spell wingardiumLeviosa = new Spell();
        wingardiumLeviosa.setName("Wingardium Leviosa");
        wingardiumLeviosa.setDescription("Makes an object or a living being fly.");
        wingardiumLeviosa.setAccuracy(90);
        wingardiumLeviosa.setDividedDamage(40);

        knownSpells.add(wingardiumLeviosa);
    }

    private static void learnAccio(List<Spell> knownSpells) {
        System.out.print("In this class you will learn Accio.");
        System.out.print("What does the spell do ?");

        Spell accio = new Spell();
        accio.setName("accio");
        accio.setDescription("Makes an object come to you.");
        accio.setAccuracy(90);
        accio.setDividedDamage(100);

        knownSpells.add(accio);
    }

    private static void learnExpectoPatronum(List<Spell> knownSpells) {
        System.out.print("In this class you will learn Expecto Patronum.");
        System.out.print("What does the spell do ?");

        Spell expectoPatronum = new Spell();
        expectoPatronum.setName("Expecto Patronum");
        expectoPatronum.setDescription("Create a light that makes dementor go away");
        expectoPatronum.setAccuracy(75);
        expectoPatronum.setDividedDamage(20);

        knownSpells.add(expectoPatronum);
    }
}
