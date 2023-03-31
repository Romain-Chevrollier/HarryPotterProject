package Composants;

import lombok.Getter;
import lombok.Setter;

public class Potion {
    @Getter @Setter String name;
    @Getter @Setter int numberHealth;
    @Getter @Setter int numberOfPotion;

    public static void createPotion(Wizard wizard){
        Potion smallHealthPotion = new Potion();
        smallHealthPotion.setNumberHealth(10);
        smallHealthPotion.setNumberOfPotion(0);
        smallHealthPotion.setName("Small Health Potion");

        Potion mediumHealthPotion = new Potion();
        mediumHealthPotion.setNumberHealth(25);
        mediumHealthPotion.setNumberOfPotion(0);
        mediumHealthPotion.setName("Medium Health Potion");

        Potion largeHealthPotion = new Potion();
        largeHealthPotion.setNumberHealth(50);
        largeHealthPotion.setNumberOfPotion(0);
        largeHealthPotion.setName("Large Health Potion");

        Potion exitInventory = new Potion();
        exitInventory.setNumberOfPotion(1);
        exitInventory.setNumberHealth(0);
        exitInventory.setName("Exit Inventory");

        wizard.getPotions().add(smallHealthPotion);
        wizard.getPotions().add(mediumHealthPotion);
        wizard.getPotions().add(largeHealthPotion);
        wizard.getPotions().add(exitInventory);
    }

}
