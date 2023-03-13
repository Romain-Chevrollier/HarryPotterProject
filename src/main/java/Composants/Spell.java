package Composants;

import java.util.ArrayList;
import java.util.List;

public class Spell extends AbstractSpell{

    static List<Spell> spellList = new ArrayList<Spell>();


    public static void learnSpell(Wizard wizard){
        System.out.print("In this class you will learn a new spell.");
        int wizardLevel = wizard.getLevel();
        switch(wizardLevel){
            case 1:
                learnWingardiumLeviosa();
                break;
            case 2:
                learnAccio();
                break;
            case 3:
                learnExpectoPatronum();
                break;
        }
    }

    private static void learnWingardiumLeviosa(){
        System.out.print("In this class you will learn Wingardium Leviosa.");
        System.out.print("What does the spell do ?");

        Spell wingardiumLeviosa = new Spell();
        wingardiumLeviosa.setName("Wingardium Leviosa");
        wingardiumLeviosa.setDescription("Makes an object or a living being fly.");
        wingardiumLeviosa.setAccuracy(90);
        wingardiumLeviosa.setDividedDamage(40);

        spellList.add(wingardiumLeviosa);
    }

    private static void learnAccio(){
        System.out.print("In this class you will learn Accio.");
        System.out.print("What does the spell do ?");

        Spell accio = new Spell();
        accio.setName("accio");
        accio.setDescription("Makes an object come to you.");
        accio.setAccuracy(90);
        accio.setDividedDamage(100);

        spellList.add(accio);
    }

    private static void learnExpectoPatronum(){
        System.out.print("In this class you will learn Expecto Patronum.");
        System.out.print("What does the spell do ?");

        Spell expectoPatronum = new Spell();
        expectoPatronum.setName("Expecto Patronum");
        expectoPatronum.setDescription("Create a light that makes dementor go away");
        expectoPatronum.setAccuracy(75);
        expectoPatronum.setDividedDamage(20);

        spellList.add(expectoPatronum);
    }
}
