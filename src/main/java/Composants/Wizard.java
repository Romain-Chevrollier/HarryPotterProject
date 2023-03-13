package Composants;

import java.util.List;
import java.util.Scanner;
import lombok.*;

public class Wizard extends Character{
    @Getter @Setter static Pet pet;
    @Getter @Setter static Wand wand;
    @Getter @Setter static House house;
    @Getter @Setter int level;
    @Getter @Setter int xp;
    List<Potion> potions;
    List<Spell> knownSpells;


    void defend(){

    }
}
