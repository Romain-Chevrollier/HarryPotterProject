package Composants;
import lombok.Getter;
import lombok.Setter;
public abstract class AbstractEnemy extends Character{
    @Getter @Setter int dropXp;
    @Getter @Setter int dropPotion;

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
}
