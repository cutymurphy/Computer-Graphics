package task2;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class CircleRenderer implements SectorAlgorithm {
    private final int centerX, centerY, radius;
    private final List<Point> points = new LinkedList<>();
    private final SectorRenderer sectorRenderer;
    private final Color boardColor;

    public CircleRenderer(int radius, int centerX, int centerY,
                          int sectorStartX, int sectorStartY, int sectorEndX, int sectorEndY,
                          Color colorCenter, Color colorEdge, Color boardColor) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.boardColor = boardColor;
        this.sectorRenderer = new SectorRenderer(centerX, centerY, radius, sectorStartX, sectorStartY, sectorEndX, sectorEndY, colorCenter, colorEdge);
    }

    @Override
    public List<Point> getPoints() {
        processBresenham();
        return points;
    }

    @Override
    public List<Point> getSectorPoints() {
        return sectorRenderer.renderSector();
    }

    // Алгоритм Брезенхема для рисования окружности
    private void processBresenham() {
        int r = radius;
        int x = -r;
        int y = 0;
        int error = 2 - 2 * radius;

        do {
            drawPixel(centerX - x, centerY + y);
            drawPixel(centerX - y, centerY - x);
            drawPixel(centerX + x, centerY - y);
            drawPixel(centerX + y, centerY + x);

            r = error;
            if (r <= y) error += ++y * 2 + 1;
            if (r > x || error > y) error += ++x * 2 + 1;
        } while (x < 0);
    }


    private void drawPixel(int x, int y) {
        putPixel(x, y);
    }

    private void putPixel(int x, int y) {
        this.points.add(new Point(x, y, 0, boardColor));
    }

}
