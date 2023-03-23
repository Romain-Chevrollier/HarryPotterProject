package Composants;

import lombok.Getter;
import lombok.Setter;

public class Potion {
    @Getter @Setter String name;
    @Getter @Setter int numberHealth;
    @Getter @Setter int numberOfPotion;

    public static void createPotion(Wizard wizard){
        Potion smallPotion = new Potion();
        smallPotion.setNumberHealth(10);
        smallPotion.setNumberOfPotion(0);
        smallPotion.setName("Small Potion");

        Potion mediumPotion = new Potion();
        mediumPotion.setNumberHealth(25);
        mediumPotion.setNumberOfPotion(0);
        mediumPotion.setName("Medium Potion");

        Potion largePotion = new Potion();
        largePotion.setNumberHealth(50);
        largePotion.setNumberOfPotion(0);
        largePotion.setName("Large Potion");

        wizard.getPotions().add(smallPotion);
        wizard.getPotions().add(mediumPotion);
        wizard.getPotions().add(largePotion);
    }

}
