package task2;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class CircleRenderer implements SectorAlgorithm {
    private final int centerX, centerY;
    private final int radius;
    private final Color boardColor;
    private final List<Point> points = new LinkedList<>();
    private final SectorRenderer sectorRenderer;

    public CircleRenderer(int radius, int centerX, int centerY,
                          int startAngle, int endAngle,
                          Color colorCenter, Color colorEdge, Color boardColor) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.boardColor = boardColor;
        this.sectorRenderer = new SectorRenderer(centerX, centerY, radius, startAngle, endAngle, colorCenter, colorEdge);
    }

    // Алгоритм Брезенхема для рисования окружности
    private void processBresenham() {
        int r = radius;
        int x = -r;
        int y = 0;
        int error = 2 - 2 * radius;

        do {
            putPixel(centerX - x, centerY + y);
            putPixel(centerX - y, centerY - x);
            putPixel(centerX + x, centerY - y);
            putPixel(centerX + y, centerY + x);

            r = error;
            if (r <= y) error += ++y * 2 + 1;
            if (r > x || error > y) error += ++x * 2 + 1;
        } while (x < 0);
    }

    private void putPixel(int x, int y) {
        this.points.add(new Point(x, y, boardColor));
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
}
