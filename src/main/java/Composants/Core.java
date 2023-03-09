package Composants;
import java.util.Random;
public enum Core {
    Dragon_heartstring,
    Phoenix_feather,
    Unicorn_tail_hair,
    Coral,
    Thunderbird_tail_feather,
    White_River_Monster_spine,
    Horned_Serpen_thorn,
    Basilisk_horn,
    African_mermaid_hair, 
    Fairy_wing;

    private static final Random PRNG = new Random();

    public static Core randomCore(){
        Core[] cores = values();
        return cores[PRNG.nextInt(cores.length)];
    }
}
