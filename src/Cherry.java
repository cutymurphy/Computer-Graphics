import java.awt.*;
import java.awt.Graphics;

public class Cherry {
    private int x;
    private int y;

    public Cherry(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    void draw(Graphics g) {
        // Рисуем круглую вишенку
        g.setColor(Color.RED);
        g.fillOval(x, y, 70, 70);

        // Рисуем черешеньку сверху
        g.setColor(Color.GREEN);
        g.fillArc(x + 5, y - 10, 60, 60, 0, 180);
    }
}
