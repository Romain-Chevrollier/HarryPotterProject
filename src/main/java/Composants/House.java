package Composants;
import java.util.Scanner;

public class House {
    nameHouse House;

    public static void chooseHouse(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you prefer between : \n 1. Nature \n 2. Power \n 3. Intelligence \n Courage");
        int numberHouse = scanner.nextInt();
        nameHouse choosedHouse;
        switch(numberHouse){
            case 1:
                choosedHouse = nameHouse.Hufflepuff;
                break;
            case 2:
                choosedHouse = nameHouse.Slytherin;
                break;
            case 3:
                choosedHouse = nameHouse.Ravenclaw;
                break;
            case 4:
                choosedHouse = nameHouse.Gryffondor;
                break;
            default:
                choosedHouse = nameHouse.randomHouse();
                break;
        }

    }

}
