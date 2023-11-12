package task2;

import java.awt.Graphics2D;
import java.awt.Color;
import java.util.List;

public class DrawCircle implements Drawable {
    private final CircleAlgorithm algorithm;

    public DrawCircle(CircleAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    @Override
    public void draw(Graphics2D gr) {
        for (Point point : algorithm.getPoints()) {
            putPixel(gr, point.getX(), point.getY(), point.getColor());
        }
        // Заполнение сектора внутри окружности
        fillSector(gr);
    }

    private void fillSector(Graphics2D g) {
        if (algorithm instanceof SectorAlgorithm) {
            List<Point> sectorPoints = ((SectorAlgorithm) algorithm).getSectorPoints();
            for (Point point : sectorPoints) {
                putPixel(g, point.getX(), point.getY(), point.getColor());
            }
        }
    }

    void putPixel(Graphics2D g, int x, int y, Color color) {
        g.setColor(color);
        g.fillRect(x, y, 1, 1);
    }
}

