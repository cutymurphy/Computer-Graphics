package task1;

import java.awt.*;

public abstract class Shape {
    private double startPointX;
    private double startPointY;
    private Color color;

    public abstract void draw();

    public void setStartPointX(double startPointX) {
        this.startPointX = startPointX;
    }
}
