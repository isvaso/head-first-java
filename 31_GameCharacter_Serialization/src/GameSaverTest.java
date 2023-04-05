import java.io.*;


public class GameSaverTest {

    public static void main(String[] args) {

        GameCharacter characterOne = new GameCharacter(50, "Elf", new String[] {"Bow, Sword, Dust"});
        GameCharacter characterTwo = new GameCharacter(200, "Troll", new String[] {"Bare, Hands, Big Cudgel"});
        GameCharacter characterThree = new GameCharacter(120, "Magician", new String[] {"Fireball, Health, Teleport"});

        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("Game.ser"));
            outputStream.writeObject(characterOne);
            outputStream.writeObject(characterTwo);
            outputStream.writeObject(characterThree);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        characterOne = null;
        characterTwo = null;
        characterThree = null;

        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("Game.ser"));
            GameCharacter characterOneRestore = (GameCharacter) inputStream.readObject();
            GameCharacter characterTwoRestore = (GameCharacter) inputStream.readObject();
            GameCharacter characterThreeRestore = (GameCharacter) inputStream.readObject();

            System.out.println(characterOneRestore.getType());
            System.out.println(characterTwoRestore.getPower());
            System.out.println(characterThreeRestore.getWeapons());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
