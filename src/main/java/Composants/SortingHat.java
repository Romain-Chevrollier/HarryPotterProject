package Composants;

import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;
@Getter @Setter
public class SortingHat {

        public static House chooseHouse(){
            Scanner scanner = new Scanner(System.in);
            System.out.println("What do you prefer between : \n 1. Nature \n 2. Power \n 3. Intelligence \n 4. Courage");
            String numberHouse = scanner.nextLine();
            return switch (numberHouse) {
                case "1" -> House.Hufflepuff;
                case "2" -> House.Slytherin;
                case "3" -> House.Ravenclaw;
                case "4" -> House.Gryffondor;
                default -> House.randomHouse();
            };

        }

}
