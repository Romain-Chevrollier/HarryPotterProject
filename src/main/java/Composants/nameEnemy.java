package Composants;

import java.util.Random;

public enum nameEnemy {
    Wolf,
    Big_toad;

    private static final Random PRNG = new Random();

    public static Composants.nameEnemy randomEnemy(){
        Composants.nameEnemy[] enemies = values();  
        return enemies[PRNG.nextInt(enemies.length)];
    }
}
