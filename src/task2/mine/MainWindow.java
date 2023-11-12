package task2.mine;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    public MainWindow(int width, int height) throws HeadlessException {
        CircleArc circleArc = new CircleArc(
                new Bresenham(500, 650, 650), Color.BLUE
        );

        DrawPanel panel = new DrawPanel(width, height, circleArc);
        this.add(panel);
    }
}