import java.io.*;

public class Main {

    public static void main(String [] args) {
        Player player1 = new Player("Tom", 25, "12.12.2020");
        serialiseObject(player1);
        Player player2 = deserialiseObject();
        System.out.println("player1.equals(player2): " + player1.equals(player2));
    }

    private static void serialiseObject(Player player) {
        try (FileOutputStream fileOutputStream = new FileOutputStream("player.txt");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(player);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Player deserialiseObject() {
        Player player = null;
        try (FileInputStream fileInputStream = new FileInputStream("player.txt");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            player = (Player) objectInputStream.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return player;
    }
}
