package Composants;

import java.util.Random;

public enum nameEnemy {
    Wolf,
    Big_toad,
    Bear,
    Dark_Mage,
    Kobold,
    Dwarf;

    private static final Random PRNG = new Random();

    public static Composants.nameEnemy randomEnemy(){
        Composants.nameEnemy[] enemies = values();  
        return enemies[PRNG.nextInt(enemies.length)];
    }
}
