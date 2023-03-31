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

    public static Boss createVoldemortAndPetterPettigrow(){
        Boss voldemortAndPetterPettigrow = new Boss();
        voldemortAndPetterPettigrow.setName("Voldemort and Petter Pettigrow");
        voldemortAndPetterPettigrow.setMaxHealth(1500);
        voldemortAndPetterPettigrow.setAttackPower(100);
        //voldemort.setDropXp(300);

        return voldemortAndPetterPettigrow;
    }

    public static Boss createDoloresOmbrage(){
        Boss doloresOmbrage = new Boss();
        doloresOmbrage.setName("Dolores Ombrage");
        doloresOmbrage.setMaxHealth(800);
        doloresOmbrage.setAttackPower(100);

        return doloresOmbrage;
    }
}
