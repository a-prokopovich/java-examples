
import org.jfree.data.xy.XYCoordinate;
import org.jfree.data.xy.XYSeries;

public class Main {

    public static void main(String [] args) {
        XYSeries series = new XYSeries("Y = X + 2");


        XYCoordinate coordinate = new XYCoordinate(4, 6);
        System.out.println(coordinate);  // call toString()
        System.out.println();
    }
}