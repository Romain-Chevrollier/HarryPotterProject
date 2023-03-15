package Composants;
import lombok.*;
public abstract class Character {
    @Getter @Setter String name;
    @Getter @Setter int maxHealth;
    @Getter @Setter int currentHealth;
    @Getter @Setter int attackPower;


    void attack(Character name){

    }
}
