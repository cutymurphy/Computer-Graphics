package task2.dasha;

import java.awt.Graphics2D;
import java.awt.Color;

public class DrawCircle implements Drawable {
    private final CircleAlgorithm algorithm;

    public DrawCircle(CircleAlgorithm algorithm) {
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

    void putPixel(Graphics2D g, double x, double y, Color color) {
        g.setColor(color);
        g.fillRect((int) x, (int) y, 1, 1);
    }
}

