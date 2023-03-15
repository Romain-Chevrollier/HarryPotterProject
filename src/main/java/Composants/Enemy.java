package Composants;

import java.util.Random;

import static Composants.Wizard.wizardTurn;

public class Enemy extends Character{


    private static Enemy createEnemy(int numberChapter){
        Random PRNG = new Random();
        Enemy newEnemy = new Enemy();
        String enemyName = nameEnemy.randomEnemy().name();
        newEnemy.setName(enemyName);

        int randomAttack = PRNG.nextInt(15);
        int randomHealth = PRNG.nextInt(40);
        newEnemy.setAttackPower(randomAttack*(1+numberChapter*(10/100)));
        newEnemy.setMaxHealth(randomHealth+40*(1+numberChapter*(20/100)));

        return newEnemy;
    }
    public static void simpleFight(Wizard wizard,int numberChapter){
        createEnemy(numberChapter);
        boolean endFight = false;
        while(!endFight){
            wizardTurn(wizard);
            enemyTurn();
        }
    }
}
