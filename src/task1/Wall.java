package task1;

import java.awt.*;

/**
 * Created by sushkova_d_s on 05.10.2023.
 */
public class Wall implements Drawable {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private boolean ifLine;

    public Wall(final int x1, final int y1, final int x2, final int y2, boolean ifLine) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.ifLine = ifLine;
    }

    @Override
    public void draw(Graphics2D gr) {
        gr.setStroke(new BasicStroke(7));
        gr.setColor(Color.BLUE);
        if (ifLine) {
            gr.drawLine(x1, y1, x2, y2);
        } else {
            gr.drawRect(x1, y1, x2, y2);
        }
    }

}
