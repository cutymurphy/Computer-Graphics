package task2;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    public MainWindow(int width, int height) throws HeadlessException {

        Color mainColor = new Color(255, 0, 0, 255);
        DrawCircleAndSector circle = new DrawCircleAndSector(
                new CircleRenderer(400, 500, 450,
                        0, 90,
                        mainColor, new Color(111, 249, 255), Color.WHITE));

        DrawCircleAndSector circle1 = new DrawCircleAndSector(
                new CircleRenderer(350, 500, 450,
                        90, 180,
                        mainColor, new Color(205, 123, 255), Color.WHITE));

        DrawCircleAndSector circle2 = new DrawCircleAndSector(
                new CircleRenderer(300, 500, 450,
                        180, 270,
                        mainColor, new Color(134, 255, 109), Color.WHITE));

        DrawCircleAndSector circle3 = new DrawCircleAndSector(
                new CircleRenderer(250, 500, 450,
                        270, 360,
                        mainColor, new Color(255, 187, 88), Color.WHITE));

        DrawPanel panel = new DrawPanel(width, height, circle3, circle2, circle1, circle);
        this.add(panel);
    }
}