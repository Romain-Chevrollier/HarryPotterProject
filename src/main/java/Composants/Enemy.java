package Composants;

import java.util.Random;

public class Enemy extends Character{


    private static Enemy createEnemy(int numberChapter){
        Random PRNG = new Random();
        Enemy newEnemy = new Enemy();
        String enemyName = nameEnemy.randomEnemy().name();
        newEnemy.setName(enemyName);

        int randomAttack = PRNG.nextInt(15);
        int randomHealth = PRNG.nextInt(40);
        newEnemy.setAttackPower(randomAttack+numberChapter*(10/100));
        newEnemy.setMaxHealth(randomHealth+40+randomHealth*(20/100));

        return newEnemy;
    }
    public static void simpleFight(int numberChapter){
        createEnemy(numberChapter);

    }
}
