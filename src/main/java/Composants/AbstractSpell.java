package Composants;
import lombok.*;
public abstract class AbstractSpell {
    @Getter @Setter String name;
    @Getter @Setter String description;
    @Getter @Setter int dividedDamage;
    @Getter @Setter int accuracy;


}
