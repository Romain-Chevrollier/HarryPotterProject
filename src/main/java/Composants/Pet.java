package Composants;

import java.util.Random;
import java.util.Scanner;

public enum Pet {
    Howls,
    Rat,
    Crow,
    Frog;

    private static final Random PRNG = new Random();

    public static Pet randomPet(){
        Pet[] pets = values();
        return pets[PRNG.nextInt(pets.length)];
    }

    public static Pet choosePet(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the pet that you want :");
        int count = 1;
        for (Pet c: Pet.values()){
            System.out.print(count + ".");
            System.out.println(c);
            count +=1;
        }
        int numberPet = scanner.nextInt();
        Pet choosedPet;
        switch(numberPet){
            case 1:
                choosedPet = Pet.Howls;
                break;
            case 2:
                choosedPet = Pet.Rat;
                break;
            case 3:
                choosedPet = Pet.Crow;
                break;
            case 4:
                choosedPet = Pet.Frog;
                break;
            default:
                choosedPet = Pet.randomPet();
                break;
        }
        return choosedPet;
    }
}
