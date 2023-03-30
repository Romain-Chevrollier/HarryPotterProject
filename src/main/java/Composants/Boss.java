package Composants;

public class Boss extends AbstractEnemy{
    public static Boss createTroll(){
        Boss troll = new Boss();
        troll.setName("Troll");
        troll.setAttackPower(1);
        troll.setMaxHealth(1);
        troll.setDropXp(100);

        return troll;
    }
    public static Boss createBasilic(){
        Boss basilic = new Boss();
        basilic.setName("Basilic");
        basilic.setAttackPower(1);
        basilic.setMaxHealth(50);
        basilic.setDropXp(200);

        return basilic;
    }

    public static Boss createDementor(){
        Boss dementor = new Boss();
        dementor.setName("Dementor");
        dementor.setMaxHealth(20);
        dementor.setAttackPower(20);
        dementor.setDropXp(300);

        return dementor;
    }

    public static Boss createVoldemort(){
        Boss voldemort = new Boss();
        voldemort.setName("Voldemort");
        voldemort.setMaxHealth(800);
        voldemort.setAttackPower(50);
        voldemort.setDropXp(300);

        return voldemort;
    }
}
