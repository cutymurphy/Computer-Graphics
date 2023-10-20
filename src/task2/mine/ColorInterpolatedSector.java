package task2.mine;

import java.awt.*;
import java.awt.geom.Arc2D;

public class ColorInterpolatedSector {

    private int centerX, centerY;
    private int radius;
    private double startAngle, extentAngle;
    private Color startColor, endColor;

    public ColorInterpolatedSector(int centerX, int centerY, int radius, double startAngle, double extentAngle, Color startColor, Color endColor) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.startAngle = startAngle;
        this.extentAngle = extentAngle;
        this.startColor = startColor;
        this.endColor = endColor;
    }

    public void draw(Graphics2D g) {
        Arc2D.Double arc = new Arc2D.Double(centerX - radius, centerY - radius, 2 * radius, 2 * radius, startAngle, extentAngle, Arc2D.PIE);

        int steps = (int) extentAngle; // Количество шагов для интерполяции цвета
        double stepSize = extentAngle / steps;

        for (int i = 0; i < steps; i++) {
            double angle = startAngle + i * stepSize;
            double fraction = i / (double) steps;

            int red = (int) (startColor.getRed() + fraction * (endColor.getRed() - startColor.getRed()));
            int green = (int) (startColor.getGreen() + fraction * (endColor.getGreen() - startColor.getGreen()));
            int blue = (int) (startColor.getBlue() + fraction * (endColor.getBlue() - startColor.getBlue()));

            Color interpolatedColor = new Color(red, green, blue);
            g.setColor(interpolatedColor);
            g.fill(new Arc2D.Double(arc.getX(), arc.getY(), arc.getWidth(), arc.getHeight(), angle, stepSize, Arc2D.PIE));
        }
    }
}