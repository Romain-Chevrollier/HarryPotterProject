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

    public void enemyTurn(Wizard wizard) {
        if (wizard.getCurrentHealth() > 0 && this.getCurrentHealth() > 0) {
            wizard.setCurrentHealth(wizard.getCurrentHealth() - this.getAttackPower());
            System.out.println("It's the turn of the " + this.getName());
            System.out.println("He dealt " + this.getAttackPower() + " damage");
            wizard.showHealth(this);
            //System.out.println("The enemy has " + enemy.getAttackPower() + " attack power");
            //System.out.println("You have " + wizard.getCurrentHealth()+ " health point");
        }

    }

    public boolean endFight(Wizard wizard) {
        if (wizard.getCurrentHealth() <= 0) {
            System.out.println("You died");
            return true;
        } else if (this.getCurrentHealth() <= 0) {
            System.out.println("You won the battle");
            wizard.manageXp(this.getDropXp());
            wizard.dropPotion();
            return true;
        }
        return false;
    }




}
