package Composants;


import java.util.Scanner;
import lombok.*;
@Getter @Setter
public class Wand {
    static Core core;
    static int size;
    
    public static void chooseWand(){
        Core core = chooseCore();
        int size = chooseSize();
        Wand wand = new Wand();
        Wand.core = core;
        Wand.size = size;
        Wizard.wand = wand;
    }

    public static Core chooseCore(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the core of your wand :");
        int count = 1;
        for (Core c: Core.values()){
            System.out.print(count + ".");
            System.out.println(c);
            count +=1;
        }
        int numberCore = scanner.nextInt();
        Core choosedCore;
        switch (numberCore){
            case 1:
                choosedCore = Core.Dragon_heartstring;
                break;
            case 2:
                choosedCore = Core.Phoenix_feather;
                break;
            case 3:
                choosedCore = Core.Unicorn_tail_hair;
                break;
            case 4:
                choosedCore = Core.Coral;
                break;
            case 5:
                choosedCore = Core.Thunderbird_tail_feather;
                break;
            case 6:
                choosedCore = Core.White_River_Monster_spine;
                break;
            case 7:
                choosedCore = Core.Horned_Serpen_thorn;
                break;
            case 8:
                choosedCore = Core.Basilisk_horn;
                break;
            case 9:
                choosedCore = Core.African_mermaid_hair;
                break;
            case 10:
                choosedCore = Core.Fairy_wing;
                break;
            default:
                choosedCore = Core.randomCore();
                break;
        }
        return choosedCore;
    }

    public static int chooseSize(){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of your wand :");
        int size = scanner.nextInt();
        return size;
    }
}
