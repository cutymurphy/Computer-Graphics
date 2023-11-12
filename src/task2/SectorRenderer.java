package task2;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

public class SectorRenderer {
    private final int centerX, centerY, radius;
    private final int sectorStartX, sectorStartY, sectorEndX, sectorEndY;
    private final Color colorCenter, colorEdge;
    private final List<Point> points = new LinkedList<>();

    public SectorRenderer(int centerX, int centerY, int radius,
                          int sectorStartX, int sectorStartY, int sectorEndX, int sectorEndY,
                          Color colorCenter, Color colorEdge) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.sectorStartX = sectorStartX;
        this.sectorStartY = sectorStartY;
        this.sectorEndX = sectorEndX;
        this.sectorEndY = sectorEndY;
        this.colorCenter = colorCenter;
        this.colorEdge = colorEdge;
    }

    public List<Point> renderSector() {
        int[] borders = new int[4];
        int[] newBorders = setBorderValue(borders);
        int borderX_1 = newBorders[0], borderX_2 = newBorders[1], borderY_1 = newBorders[2], borderY_2 = newBorders[3];

        for (int x = borderX_1; x <= borderX_2; x++) {
            for (int y = borderY_1; y <= borderY_2; y++) {

                int checkResult1 = findVertical(sectorStartX - centerX, sectorStartY - centerY, x - centerX, y - centerY);
                int checkResult2 = findVertical(x - centerX, y - centerY, sectorEndX - centerX, sectorEndY - centerY);

                if ((checkResult1 >= 0 && checkResult2 >= 0 || checkResult1 <= 0 && checkResult2 <= 0)
                        && isPointInsideCircle(x, y, centerX, centerY, radius)) {
                    drawPixel(x, y);
                }
            }
        }

        return points;
    }

    private int findVertical(int v1, int v2, int w1, int w2) {
        return v1 * w2 - v2 * w1;
    }

    private boolean isPointInsideCircle(int pointX, int pointY, int centerX, int centerY, int radius) {
        return (Math.pow(pointX - centerX, 2) + Math.pow(pointY - centerY, 2)) <= Math.pow(radius, 2);
    }

    private void drawPixel(int x, int y) {
        Interpolation i = new Interpolation(centerX, centerY, radius, colorCenter, colorEdge);
        Color color = i.getColor(x, y);
        putPixel(x, y, 0, color);
    }

    private void putPixel(int x, int y, int z, Color color) {
        this.points.add(new Point(x, y, z, color));
    }

    private int[] setBorderValue(int[] borders) {
        borders[0] = centerX - radius;
        borders[1] = centerX + radius;
        borders[2] = centerY - radius;
        borders[3] = centerY + radius;

        if (sectorStartX >= radius && sectorEndX >= radius && sectorStartY >= radius && sectorEndY <= radius) { //1
            borders[0] = centerX;
            borders[1] = centerX + radius;
        } else if (sectorStartX <= radius && sectorEndX >= radius && sectorStartY >= radius && sectorEndY >= radius) { //2
            borders[2] = centerY;
            borders[3] = centerY + radius;
        } else if (sectorStartX >= radius && sectorEndX <= radius && sectorStartY <= radius && sectorEndY >= radius) {
            borders[2] = centerY - radius;
            borders[3] = centerY;
        }

        return borders;
    }
}
