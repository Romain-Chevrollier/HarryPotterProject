package Composants;

import java.util.List;

public class Spell extends AbstractSpell {

    //static List<Spell> spellList = new ArrayList<Spell>();


    public static void learnBasicSpell(List<Spell> knownSpells) {

        Spell basicSpell = new Spell();
        basicSpell.setName("Basic Spell");
        basicSpell.setDescription("Shoot a small ball of concentrated magic.");
        basicSpell.setAccuracy(100);
        basicSpell.setDividedDamage(50);
        knownSpells.add(basicSpell);
    }

    public static void learnFireWorks(List<Spell> knownSpells){
        Spell fireWorks = new Spell();
        fireWorks.setName("Fireworks");
        fireWorks.setAccuracy(100);
        fireWorks.setDividedDamage(0);
        knownSpells.add(fireWorks);
    }
    public static void learnExitSpell(List<Spell> knownSpells){
        Spell exitSpell = new Spell();
        exitSpell.setDividedDamage(100);
        exitSpell.setName("Exit Spell");

        knownSpells.add(exitSpell);
    }

    public static void learnSwordOfGryffondor(List<Spell> knownSpells){
        Spell swordOfGryffondor = new Spell();
        swordOfGryffondor.setName("Sword of Gryffondor");
        swordOfGryffondor.setAccuracy(100);
        swordOfGryffondor.setDividedDamage(0);

        knownSpells.add(swordOfGryffondor);
    }

    public static void learnWingardiumLeviosa(List<Spell> knownSpells) {
        System.out.print("In this class you will learn Wingardium Leviosa.");

        Spell wingardiumLeviosa = new Spell();
        wingardiumLeviosa.setName("Wingardium Leviosa");
        wingardiumLeviosa.setDescription("Makes an object or a living being fly.");
        wingardiumLeviosa.setAccuracy(90);
        wingardiumLeviosa.setDividedDamage(40);

        knownSpells.add(wingardiumLeviosa);
    }

    public static void learnAccio(List<Spell> knownSpells) {
        System.out.print("In this class you will learn Accio.");

        Spell accio = new Spell();
        accio.setName("Accio");
        accio.setDescription("Makes an object come to you.");
        accio.setAccuracy(90);
        accio.setDividedDamage(100);

        knownSpells.add(accio);
    }

    public static void learnExpectoPatronum(List<Spell> knownSpells) {
        System.out.print("In this class you will learn Expecto Patronum.");

        Spell expectoPatronum = new Spell();
        expectoPatronum.setName("Expecto Patronum");
        expectoPatronum.setDescription("Create a light that makes dementor go away");
        expectoPatronum.setAccuracy(75);
        expectoPatronum.setDividedDamage(20);

        knownSpells.add(expectoPatronum);
    }
}
