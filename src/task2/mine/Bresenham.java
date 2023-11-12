package task2.mine;

import java.util.LinkedList;
import java.util.List;

public class Bresenham implements AlgorithmArc {
    private final int centerX, centerY, radius;

    private final List<Point> points = new LinkedList<>();
    
    public Bresenham(int radius, int centerX, int centerY) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }

    @Override
    public List<Point> getPoints() {
        processBresenham();
        return points;
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

    // Метод для проверки и рисования пикселя на основе угла
    private void drawPixel(int x, int y) {
        putPixel(x, y);
    }

    @Override
    public int getCenterX() {
        return centerX;
    }

    @Override
    public int getCenterY() {
        return centerY;
    }

    @Override
    public int getRadius() {
        return radius;
    }

    private void putPixel(int x, int y) {
        this.points.add(new Point(x, y));
    }
}
