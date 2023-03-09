package Composants;
import java.util.Scanner;

public class House {
    static String nameHouse;

    public static void chooseHouse(){
        Scanner scanner = new Scanner(System.in);*
        System.out.println("What do you prefer between : \n 1. Nature \n 2. Power \n 3. Intelligence \n Courage");
        int numberHouse = scanner.nextInt();
        nameHouse choosedHouse;
        switch(numberHouse){
            case 1:
                choosedHouse = nameHouse.Hufflepuff;
                break;
        }
    }

}
