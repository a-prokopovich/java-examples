import java.io.Serializable;
import java.util.Objects;

public class Player implements Serializable {

    public static int n = 1;

    private static final long serialVersionUID = 1L;
    private String name;
    private int level;
    private String date;

    public Player(String name, int level, String date) {
        this.name = name;
        this.level = level;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return level == player.level && Objects.equals(name, player.name) && Objects.equals(date, player.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, level, date);
    }
}
