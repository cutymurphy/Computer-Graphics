package task2;

import java.awt.*;

public class Point {
    private final int x;
    private final int y;
    private final Color color;

    public Point(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public Color getColor() { return color; }
}
