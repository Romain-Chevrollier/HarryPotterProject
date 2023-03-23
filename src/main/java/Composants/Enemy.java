package Composants;


import java.util.Random;

public class Enemy extends AbstractEnemy {


    public static Enemy createEnemy(int numberChapter) {
        Random PRNG = new Random();
        Enemy newEnemy = new Enemy();
        String enemyName = nameEnemy.randomEnemy().name();
        newEnemy.setName(enemyName);

        int randomAttack = PRNG.nextInt(15);
        int randomHealth = PRNG.nextInt(40);
        int randomXp = PRNG.nextInt(50);

        newEnemy.setAttackPower(randomAttack * (1 + numberChapter * (10 / 100)));
        newEnemy.setMaxHealth(randomHealth + 20 * (1 + numberChapter * (20 / 100)));
        newEnemy.setDropXp(randomXp);

        return newEnemy;
    }








}
