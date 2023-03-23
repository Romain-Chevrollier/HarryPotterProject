package Composants;

import java.util.List;

public class Spell extends AbstractSpell {

    //static List<Spell> spellList = new ArrayList<Spell>();


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

    public static void learnWingardiumLeviosa(List<Spell> knownSpells) {
        System.out.print("In this class you will learn Wingardium Leviosa.");
        System.out.print("What does the spell do ?");

        Spell wingardiumLeviosa = new Spell();
        wingardiumLeviosa.setName("Wingardium Leviosa");
        wingardiumLeviosa.setDescription("Makes an object or a living being fly.");
        wingardiumLeviosa.setAccuracy(90);
        wingardiumLeviosa.setDividedDamage(40);

        knownSpells.add(wingardiumLeviosa);
    }

    public static void learnAccio(List<Spell> knownSpells) {
        System.out.print("In this class you will learn Accio.");
        System.out.print("What does the spell do ?");

        Spell accio = new Spell();
        accio.setName("Accio");
        accio.setDescription("Makes an object come to you.");
        accio.setAccuracy(90);
        accio.setDividedDamage(100);

        knownSpells.add(accio);
    }

    public static void learnExpectoPatronum(List<Spell> knownSpells) {
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
