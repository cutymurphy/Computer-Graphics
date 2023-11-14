package task2.dasha;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    public MainWindow(int width, int height) throws HeadlessException {
        Color mainColor = new Color(255, 0, 0, 255);
        DrawCircle circle = new DrawCircle(
                new CircleRenderer(600, 600, 650,
                        0, 90,
                        mainColor, new Color(111, 249, 255), Color.BLACK));

        DrawCircle circle1 = new DrawCircle(
                new CircleRenderer(550, 600, 650,
                        90, 180,
                        mainColor, new Color(205, 123, 255), Color.BLACK));

        DrawCircle circle2 = new DrawCircle(
                new CircleRenderer(500, 600, 650,
                        180, 270,
                        mainColor, new Color(134, 255, 109), Color.BLACK));

        DrawCircle circle3 = new DrawCircle(
                new CircleRenderer(450, 600, 650,
                        270, 360,
                        mainColor, new Color(255, 187, 88), Color.BLACK));

        DrawPanel panel = new DrawPanel(width, height, circle3, circle2, circle1, circle);
        this.add(panel);
    }
}