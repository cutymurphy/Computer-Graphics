package task2.mine;

import java.awt.Graphics2D;
import java.awt.Color;

public class CircleArc implements Drawable {

    // Определение переменных для координат центра окружности, радиуса
    private final AlgorithmArc algorithm;
    private final Color pointColor;

    // Конструктор класса CircleArc
    public CircleArc(AlgorithmArc algorithm, Color pointColor) {
        this.algorithm = algorithm;
        this.pointColor = pointColor;
    }

    @Override
    public void draw(Graphics2D gr) {
        gr.drawLine(algorithm.getCenterX() - algorithm.getRadius() - 100,
                algorithm.getCenterY(),
                algorithm.getCenterX() + algorithm.getRadius() + 100,
                algorithm.getCenterY());
        gr.drawLine(algorithm.getCenterX(),
                algorithm.getCenterY() - algorithm.getRadius() - 100,
                algorithm.getCenterX(),
                algorithm.getCenterY() + algorithm.getRadius() + 100);

        for (Point point:algorithm.getPoints()) {
            putPixel(gr, point.getX(), point.getY(), pointColor);
        }
    }

    private void putPixel(Graphics2D g, int x, int y, Color color) {
        g.setColor(color);
        g.fillRect(x, y, 1, 1);
    }
}

