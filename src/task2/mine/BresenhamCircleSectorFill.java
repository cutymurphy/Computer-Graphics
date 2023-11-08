package task2.mine;

import java.awt.*;
import java.awt.geom.Arc2D;

public class BresenhamCircleSectorFill {

    private int centerX, centerY;
    private int radius;
    private double startAngle, extentAngle;
    private Color startColor, endColor;

    public BresenhamCircleSectorFill(int centerX, int centerY, int radius, double startAngle, double extentAngle, Color startColor, Color endColor) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.startAngle = startAngle;
        this.extentAngle = extentAngle;
        this.startColor = startColor;
        this.endColor = endColor;
    }

    public void draw(Graphics2D g) {

        int x = radius;
        int y = 0;
        int p = 1 - radius;

        while (x >= y) {
            y++;

            if (p <= 0) {
                p = p + 2 * y + 1;
            } else {
                x--;
                p = p + 2 * y - 2 * x + 1;
            }

            double angle = Math.toDegrees(Math.atan2(centerY - y, x - centerX));
            if (isAngleInRange(angle, startAngle, extentAngle)) {
                double fraction = (angle - startAngle) / (extentAngle - startAngle);

                int red = (int) (startColor.getRed() + fraction * (endColor.getRed() - startColor.getRed()));
                int green = (int) (startColor.getGreen() + fraction * (endColor.getGreen() - startColor.getGreen()));
                int blue = (int) (startColor.getBlue() + fraction * (endColor.getBlue() - startColor.getBlue()));

                Color interpolatedColor = new Color(red, green, blue);
                g.setColor(interpolatedColor);

                // Рисование пикселя в точке (x, y)
                g.drawLine(centerX, centerY, x + centerX, y + centerY);
                g.drawLine(centerX, centerY, -x + centerX, y + centerY);
                g.drawLine(centerX, centerY, -x + centerX, -y + centerY);
                g.drawLine(centerX, centerY, x + centerX, -y + centerY);
            }
        }
    }

    private static boolean isAngleInRange(double angle, double startAngle, double extentAngle) {
        angle = normalizeAngle(angle);
        startAngle = normalizeAngle(startAngle);
        extentAngle = normalizeAngle(extentAngle);

        if (startAngle < extentAngle) {
            return angle >= startAngle && angle <= extentAngle;
        } else {
            return angle >= startAngle || angle <= extentAngle;
        }
    }

    private static double normalizeAngle(double angle) {
        angle %= 360;
        if (angle < 0) {
            angle += 360;
        }
        return angle;
    }
}
