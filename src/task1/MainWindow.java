package task1;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private final DrawPanel panel;

    public MainWindow(int width, int height) throws HeadlessException {
        panel = new DrawPanel(width, height, 100);
        this.add(panel);
    }
}