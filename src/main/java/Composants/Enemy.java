package Composants;



import java.util.Random;

import static Composants.Wizard.wizardTurn;

public class Enemy extends AbstractEnemy{


    private static Enemy createEnemy(int numberChapter){
        Random PRNG = new Random();
        Enemy newEnemy = new Enemy();
        String enemyName = nameEnemy.randomEnemy().name();
        newEnemy.setName(enemyName);

        int randomAttack = PRNG.nextInt(15);
        int randomHealth = PRNG.nextInt(40);
        int randomXp = PRNG.nextInt(50);
        newEnemy.setAttackPower(randomAttack*(1+numberChapter*(10/100)));
        newEnemy.setMaxHealth(randomHealth+20*(1+numberChapter*(20/100)));
        newEnemy.setDropXp(randomXp);
        return newEnemy;
    }
    private static void enemyTurn(Wizard wizard, Enemy enemy){
        if (wizard.getCurrentHealth() > 0 && enemy.getCurrentHealth() >0){
            wizard.setCurrentHealth(wizard.getCurrentHealth()-enemy.getAttackPower());
            System.out.println("The enemy has " + enemy.getAttackPower() + " attack power");
            System.out.println("You have " + wizard.getCurrentHealth()+ " health point");
        }

    }

    public static boolean endFight(Wizard wizard, Enemy enemy){
        int wizardCurrentHealth = wizard.getCurrentHealth();
        int enemyCurrentHealth = enemy.getCurrentHealth();
        if (wizardCurrentHealth <= 0){
            System.out.println("You died");
            return true;
        }else if(enemyCurrentHealth <= 0){
            System.out.println("You won the battle");
            Wizard.manageXp(wizard, enemy);
            return true;
        }
        return false;
    }

    public static void simpleFight(Wizard wizard,int numberChapter){
        Enemy enemy = createEnemy(numberChapter);
        wizard.setCurrentHealth(wizard.getMaxHealth());
        enemy.setCurrentHealth(enemy.getMaxHealth());
        boolean stateOfFight = false;
        while(!stateOfFight){
            stateOfFight = wizardTurn(wizard,enemy);
            enemyTurn(wizard,enemy);
        }
        Wizard.menu(wizard, 0);
    }
}
