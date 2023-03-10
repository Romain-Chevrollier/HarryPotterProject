package Composants;

import java.util.Scanner;
import lombok.*;
@Getter @Setter
public class SortingHat {

        public static House chooseHouse(){
            Scanner scanner = new Scanner(System.in);
            System.out.println("What do you prefer between : \n 1. Nature \n 2. Power \n 3. Intelligence \n 4. Courage");
            int numberHouse = scanner.nextInt();
            House choosedHouse;
            switch(numberHouse){
                case 1:
                    choosedHouse = House.Hufflepuff;
                    break;
                case 2:
                    choosedHouse = House.Slytherin;
                    break;
                case 3:
                    choosedHouse = House.Ravenclaw;
                    break;
                case 4:
                    choosedHouse = House.Gryffondor;
                    break;
                default:
                    choosedHouse = House.randomHouse();
                    break;
            }
            return choosedHouse;

        }

}
