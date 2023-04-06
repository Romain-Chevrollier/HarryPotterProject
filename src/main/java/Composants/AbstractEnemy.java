package Composants;
import lombok.Getter;
import lombok.Setter;
public abstract class AbstractEnemy extends Character{
    @Getter @Setter int dropXp;
    @Getter @Setter int dropPotion;

    public void enemyTurn(Wizard wizard) {
        if (wizard.getCurrentHealth() > 0 && this.getCurrentHealth() > 0) {
            int attackPowerEnemy = this.getAttackPower();
            if(wizard.getHouse() == House.Gryffondor){
                attackPowerEnemy -= 10;
                System.out.println("Because you are in Gryffondor, you take 10 less damage.");
            }
            if (this.getName() == "Dolores Ombrage" && this.getCurrentHealth() == this.getMaxHealth()){
                attackPowerEnemy = 0;
                System.out.println("Because Dolores Ombrage didn't see you she will not attack you");
            }
            wizard.setCurrentHealth(wizard.getCurrentHealth() - attackPowerEnemy);
            System.out.println("It's the turn of the " + this.getName());
            System.out.println("He dealt " + attackPowerEnemy + " damage");
            wizard.showHealth(this);
            //System.out.println("The enemy has " + enemy.getAttackPower() + " attack power");
            //System.out.println("You have " + wizard.getCurrentHealth()+ " health point");
        }
    }
}
