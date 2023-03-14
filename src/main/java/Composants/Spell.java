package Composants;

import java.util.ArrayList;
import java.util.List;

public class Spell extends AbstractSpell{

    //static List<Spell> spellList = new ArrayList<Spell>();


    public static void learnSpell(Wizard wizard){
        System.out.print("In this class you will learn a new spell.");
        int wizardLevel = wizard.getLevel();
        switch(wizardLevel){
            case 1:
                for (Spell i : wizard.getKnownSpells()){
                    if (!i.equals("wingardiumLeviosa")) {
                        learnWingardiumLeviosa(wizard.getKnownSpells());
                    }
                    break;
                }

            case 2:
                for (Spell i : wizard.getKnownSpells()){
                    if (!i.equals("accio")) {
                        learnAccio(wizard.getKnownSpells());
                    }
                    break;
                }
            case 3:
                for (Spell i : wizard.getKnownSpells()){
                    if (!i.equals("expectoPatronum")) {
                        learnExpectoPatronum(wizard.getKnownSpells());
                    }
                    break;
                }
        }
    }

    private static void learnWingardiumLeviosa(List<Spell> knownSpells){
        System.out.print("In this class you will learn Wingardium Leviosa.");
        System.out.print("What does the spell do ?");

        Spell wingardiumLeviosa = new Spell();
        wingardiumLeviosa.setName("Wingardium Leviosa");
        wingardiumLeviosa.setDescription("Makes an object or a living being fly.");
        wingardiumLeviosa.setAccuracy(90);
        wingardiumLeviosa.setDividedDamage(40);

        knownSpells.add(wingardiumLeviosa);
    }

    private static void learnAccio(List<Spell> knownSpells){
        System.out.print("In this class you will learn Accio.");
        System.out.print("What does the spell do ?");

        Spell accio = new Spell();
        accio.setName("accio");
        accio.setDescription("Makes an object come to you.");
        accio.setAccuracy(90);
        accio.setDividedDamage(100);

        knownSpells.add(accio);
    }

    private static void learnExpectoPatronum(List<Spell> knownSpells){
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
