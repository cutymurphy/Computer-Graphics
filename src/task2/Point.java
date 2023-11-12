package task2;

import java.awt.*;

public class Point {
    private final int x;
    private final int y;
    private final int z;
    private final Color color;

    public Point(int x, int y, int z, Color color) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.color = color;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getZ() { return z; }
    public Color getColor() { return color; }
}
