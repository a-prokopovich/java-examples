package org.jfree.data.xy;

import java.io.Serializable;

public class XYCoordinate implements Comparable, Serializable {

    private double x;
    private double y;

    public XYCoordinate() {
        this(0.0, 0.0);
    }

    public XYCoordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    @Override
    public boolean equals(Object obj) {
        // some implementation
        return true;
    }

    @Override
    public int hashCode() {
        int result = 170; // changing result
        long temp = Double.doubleToLongBits(this.x);
        result = 37 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(this.y);
        result = 37 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Overridden method. Coordinate: " + "(" + this.x + ", " + this.y + ")";
    }

    @Override
    public int compareTo(Object obj) {
        // some implementation
        return 0;
    }
}
