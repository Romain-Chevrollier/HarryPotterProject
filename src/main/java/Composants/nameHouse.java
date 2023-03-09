package Composants;

import java.util.Random;

public enum nameHouse {
    Hufflepuff,
    Ravenclaw,
    Slytherin,
    Gryffondor,

    private static final Random PRNG = new Random();

    public static nameHouse randomHouse(){
        nameHouse[] houses = values();
        return houses[PRNG.nextInt(houses.length)];
    }
}
