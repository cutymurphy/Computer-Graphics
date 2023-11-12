package task2;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    public MainWindow(int width, int height) throws HeadlessException {
        DrawCircle circle = new DrawCircle(
                new CircleRenderer(500, 650, 650,
                        900, 900, 750, 200,
                        Color.BLUE, new Color(255, 255, 255), Color.BLACK));

        DrawCircle circle1 = new DrawCircle(
                new CircleRenderer(450, 650, 650,
                        650-450, 650, 900, 900,
                        Color.BLUE, new Color(113, 220, 255), Color.BLACK));

        DrawCircle circle2 = new DrawCircle(
                new CircleRenderer(400, 650, 650,
                        750, 200, 650 - 450, 650,
                        Color.BLUE, new Color(0, 128, 255), Color.BLACK));

        DrawPanel panel = new DrawPanel(width, height, circle2, circle1, circle);
        this.add(panel);
    }
}