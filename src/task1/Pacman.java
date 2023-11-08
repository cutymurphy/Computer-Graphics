package task1;

import java.awt.*;

public class Pacman implements Drawable {

    private int x;
    private int y;
    private int diameter;
    private int mouthAngle;
    private Color bodyColor;
    private boolean flipped;

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public boolean isFlipped() {
        return flipped;
    }

    public Pacman(int x, int y, int diameter, int mouthAngle, Color color, boolean toFlip) {
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        this.mouthAngle = mouthAngle;
        this.bodyColor = color;
        this.flipped = toFlip;
    }

    @Override
    public void draw(Graphics2D g) {
        Graphics2D g2d = g;

        int eyeX; int eyeY;

        g2d.setColor(bodyColor);
        if (flipped) {
            g2d.fillArc(x, y, diameter, diameter, -mouthAngle - 90, 360 - (2 * mouthAngle));
            eyeX = x + diameter - diameter / 3 - 30;
            eyeY = y + diameter / 5;
        } else {
            g2d.fillArc(x, y, diameter, diameter, mouthAngle, 360 - (2 * mouthAngle));
            eyeX = x + diameter / 3;
            eyeY = y + diameter / 5;
        }

        int eyeDiameter = diameter / 5;
        g2d.setColor(Color.black);
        g2d.fillOval(eyeX, eyeY, eyeDiameter, eyeDiameter);
    }
}
