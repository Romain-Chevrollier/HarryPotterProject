package Composants;


import java.util.Random;

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

}
