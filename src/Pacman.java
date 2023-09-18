import java.awt.*;

public class Pacman {

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

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        int eyeX; int eyeY;
        // Рисуем голову Пакмана
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
        // Рисуем глаз Пакмана
        int eyeDiameter = diameter / 5;
        g2d.setColor(Color.black);
        g2d.fillOval(eyeX, eyeY, eyeDiameter, eyeDiameter);
    }
}
