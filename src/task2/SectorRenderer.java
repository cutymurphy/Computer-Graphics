package task2;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

public class SectorRenderer {
    private final int centerX, centerY;
    private final int radius;
    private final double startAngle, endAngle;
    private final Color colorCenter, colorEdge;
    private final List<Point> points = new LinkedList<>();

    public SectorRenderer(int centerX, int centerY, int radius,
                          double startAngle, double endAngle,
                          Color colorCenter, Color colorEdge) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.startAngle = startAngle;
        this.endAngle = endAngle;
        this.colorCenter = colorCenter;
        this.colorEdge = colorEdge;
    }

    public List<Point> renderSector() {
        for (int x = centerX - radius; x <= centerX + radius; x++) {
            for (int y = centerY - radius; y <= centerY + radius; y++) {

                if (isInsideCircle(x, y)) {
                    double angle = normalizeAngle(Math.toDegrees(Math.atan2(centerY - y, x - centerX)));

                    if (isAngleInRange(angle)) {
                        Interpolation i = new Interpolation(centerX, centerY, radius, colorCenter, colorEdge);
                        Color color = i.getColor(x, y);

                        putPixel(x, y, color);
                    }
                }
            }
        }

        return points;
    }

    private boolean isInsideCircle(int x, int y) {
        return Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2) <= Math.pow(radius, 2);
    }

    private boolean isAngleInRange(double angle) {
        if (startAngle <= endAngle) { //определяет направление движения по часовой стрелке
            return (angle >= startAngle && angle <= endAngle);
        } /*else if (startAngle <= endAngle && startAngle <= 0 && endAngle <= 0) {
            return (angle >= normalizeAngle(startAngle) && angle <= normalizeAngle(endAngle));
        } else if (startAngle <= endAngle && startAngle <= 0 && endAngle >= 0) {
            return (angle >= normalizeAngle(startAngle) && angle >= endAngle ||
                    angle <= normalizeAngle(startAngle) && angle <= endAngle ||
                    angle >= normalizeAngle(startAngle) && angle <= endAngle);
        }*/ else {
            return angle >= startAngle || angle <= endAngle;
        }
    }

    private double normalizeAngle(double angle) {
        return angle < 0? 360 + angle : angle;
    }

    private void putPixel(int x, int y, Color color) {
        this.points.add(new Point(x, y, color));
    }
}
