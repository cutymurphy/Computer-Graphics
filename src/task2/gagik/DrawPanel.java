package task2.gagik;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawPanel extends JPanel implements ActionListener {

    private final int PANEL_WIDTH;
    private final int PANEL_HEIGHT;
    private final Timer timer;

    private final CircleArc circleArc;

    public DrawPanel(final int width, final int height, final int timerDelay) {
        this.PANEL_WIDTH = width;
        this.PANEL_HEIGHT = height;

        timer = new Timer(timerDelay, this);
        timer.start();

        circleArc = new CircleArc(275, 300, 200, 0, 360, Color.BLACK, Color.WHITE);
    }

    @Override
    public void paint(final Graphics gr) {
        super.paint(gr);
        Graphics2D g = (Graphics2D) gr;
        g.setColor(Color.ORANGE);
        g.fillRect(0, 0, PANEL_WIDTH, PANEL_HEIGHT);
        g.setColor(Color.BLACK);
        g.setFont(new Font(null, Font.PLAIN, 29));
        g.drawString("Дуга окружности с интерполяцией цвета", 8, 50);
        g.setColor(Color.BLACK);
        circleArc.draw(g);
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        if (e.getSource() == timer) {
            repaint();
        }
    }
}