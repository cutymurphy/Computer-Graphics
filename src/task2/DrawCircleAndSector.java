package task2;

import java.awt.Graphics2D;
import java.awt.Color;

public class DrawCircleAndSector implements Drawable {
    private final CircleAlgorithm algorithm;

    public DrawCircleAndSector(CircleAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    @Override
    public void draw(Graphics2D gr) {

        // Заполнение сектора внутри окружности
        for (Point point : ((SectorAlgorithm) algorithm).getSectorPoints()) {
            putPixel(gr, point.getX(), point.getY(), point.getColor());
        }

        // Растеризация самой окружности
        for (Point point : algorithm.getPoints()) {
            putPixel(gr, point.getX(), point.getY(), point.getColor());
        }
    }

    void putPixel(Graphics2D g, int x, int y, Color color) {
        g.setColor(color);
        g.fillRect(x, y, 1, 1);
    }
}

