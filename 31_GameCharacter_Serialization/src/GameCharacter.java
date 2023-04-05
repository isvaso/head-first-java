import java.io.*;

public class GameCharacter implements Serializable {

    int power;
    String type;
    String[] weapons;

    public GameCharacter(int initialPower, String initialType, String[] initialWeapons) {
        power = initialPower;
        type = initialType;
        weapons = initialWeapons;
    }

    public int getPower() {
        return power;
    }

    public String getType() {
        return type;
    }

    public String getWeapons() {
        String weaponList = "";

        for (int i = 0; i < weapons.length; i++) {
            weaponList += weapons[i] + " ";
        }
        return weaponList;
    }
}
