package Composants;

public class Boss extends AbstractEnemy{
    public static Boss createBasilic(){
        Boss basilic = new Boss();
        basilic.setName("Basilic");
        basilic.setAttackPower(1);
        basilic.setMaxHealth(1);
        basilic.setDropXp(1);

        return basilic;
    }
}
