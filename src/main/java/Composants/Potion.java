package Composants;
import lombok.Setter;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

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

    public void dropPotion(){
        Random PRNG = new Random();
        int randomDrop = PRNG.nextInt(100);
        List<Potion> listPotion = this.getPotions();
        System.out.print(randomDrop);
        if (randomDrop/100 <= 0.02){
            System.out.println("you dropped a large potion");
            listPotion.get(2).setNumberOfPotion(listPotion.get(2).getNumberOfPotion() + 1);
            System.out.println("You now have " + listPotion.get(2).getNumberOfPotion() + " large potion");
        }else if(randomDrop/100 <= 0.10){
            System.out.println("you dropped a medium potion");
            listPotion.get(1).setNumberOfPotion(listPotion.get(1).getNumberOfPotion() + 1);
            System.out.println("You now have " + listPotion.get(1).getNumberOfPotion() + " medium potion");
        }else if(randomDrop/100 <= 0.20){
            System.out.println("you dropped a small potion");
            listPotion.get(0).setNumberOfPotion(listPotion.get(0).getNumberOfPotion() + 1);
            System.out.println("You now have " + listPotion.get(0).getNumberOfPotion() + " small potion");
        }
    }

    public Potion choosedPotion(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("You are in you inventory :");
        List<Potion> listOfPotions = this.getPotions();
        System.out.println("You have :");
        int count = 0;
        for (Potion i : listOfPotions){
            System.out.println(count + ".");
            if (i.getNumberOfPotion() != 0){
                System.out.print(i.getNumberOfPotion());
                System.out.print(i);
            }
        }
        String choosedPotion = scanner.nextLine();
        return listOfPotions.get(Integer.parseInt(choosedPotion));
    }

    public void usePotion(Potion choosedPotion){
        int wizardCurrentHealth = this.getCurrentHealth();
        int wizardMaxHealth = this.getMaxHealth();
        int potionNumberHealth = choosedPotion.getNumberHealth();
        if (wizardCurrentHealth + potionNumberHealth > wizardMaxHealth){
            this.setCurrentHealth(wizardMaxHealth);
            choosedPotion.setNumberOfPotion(choosedPotion.getNumberOfPotion() - 1);
        }else{
            this.setCurrentHealth(wizardCurrentHealth + potionNumberHealth);
            choosedPotion.setNumberOfPotion(choosedPotion.getNumberOfPotion() - 1);

        }

    }
}
