package task2;

import java.awt.*;

public class Interpolation {
    private final int centerX, centerY;
    private final int radius;
    private final Color colorCenter, colorEdge;

    public Interpolation(int centerX, int centerY, int radius, Color colorCenter, Color colorEdge) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.colorCenter = colorCenter;
        this.colorEdge = colorEdge;
    }

    public Color getColor(int x, int y) {
        double distanceFromCenter = Math.sqrt(Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2));
        double normalizedDistance = distanceFromCenter / radius;

        int red = (int) (colorCenter.getRed() + (colorEdge.getRed() - colorCenter.getRed()) * normalizedDistance);
        int green = (int) (colorCenter.getGreen() + (colorEdge.getGreen() - colorCenter.getGreen()) * normalizedDistance);
        int blue = (int) (colorCenter.getBlue() + (colorEdge.getBlue() - colorCenter.getBlue()) * normalizedDistance);

        return new Color(red, green, blue);
    }
}
