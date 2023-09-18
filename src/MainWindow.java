import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private final DrawPanel panel;
    private final int width;
    private final int height;

    public MainWindow(int width, int height) throws HeadlessException {
        this.width = width;
        this.height = height;
        panel = new DrawPanel(width, height, 100);
        this.add(panel);
    }
}