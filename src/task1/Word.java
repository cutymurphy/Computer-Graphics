package task1;

import java.awt.*;

/**
 * Created by sushkova_d_s on 05.10.2023.
 */
public class Word implements Drawable {
    private int width;
    private int height;

    public Word(final int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics2D gr) {
        Font font = new Font("Georgia", Font.BOLD, 200);
        gr.setColor(Color.ORANGE);
        gr.setFont(font);
        String message = "task1.Pacman";
        FontMetrics metrics = gr.getFontMetrics(font);
        int x = (width) - metrics.stringWidth(message) / 2;
        int y = height / 2;
        gr.drawString(message, x, y);
    }
}
