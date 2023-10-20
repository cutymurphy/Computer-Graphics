package task1;

import java.awt.*;

public class Cherry implements Drawable {
    private int x;
    private int y;

    public Cherry(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.RED);
        g.fillOval(x, y, 70, 70);

        g.setColor(Color.GREEN);
        g.fillArc(x + 5, y - 10, 60, 60, 0, 180);
    }
}
