package Composants;

import java.util.Random;

public enum House {

        Hufflepuff,
        Ravenclaw,
        Slytherin,
        Gryffondor;

        private static final Random PRNG = new Random();

        public static Composants.House randomHouse(){
            Composants.House[] houses = values();
            return houses[PRNG.nextInt(houses.length)];
        }
}

