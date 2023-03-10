package Composants;

import java.util.List;
import java.util.Scanner;
import lombok.*;
@Getter @Setter
public class Wizard {
    static Pet pet;
    static Wand wand;
    static House house;
    List<Potion> potions;
    List<Spell> knownSpells;


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
