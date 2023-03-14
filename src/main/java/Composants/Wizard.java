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
    @Getter @Setter List<Potion> potions;
    @Getter @Setter List<Spell> knownSpells;


    void defend(){

    }
}
