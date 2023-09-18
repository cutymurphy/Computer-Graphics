import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DrawPanel extends JPanel implements ActionListener {

    private int PANEL_WIDTH;
    private int PANEL_HEIGHT;
    private int TIMER_DELAY;
    private Timer timer;
    private ArrayList<Pacman> pacmans = new ArrayList<>();
    private ArrayList<Cherry> cherries = new ArrayList<>();


    public DrawPanel(int width, int height, int timerDelay) {
        this.PANEL_WIDTH = width;
        this.PANEL_HEIGHT = height;
        this.TIMER_DELAY = timerDelay;

        this.pacmans.add(new Pacman(0, height / 3, 200, 45, Color.GREEN, false));
        this.pacmans.add(new Pacman(300, height - 300, 200, 45, Color.PINK, false));
        this.pacmans.add(new Pacman(width - 200, 0, 200, 45, Color.CYAN, true));

        this.cherries.add(new Cherry(width / 2 + 450, height / 2 - 100));
        this.cherries.add(new Cherry((width / 10) * 3, height / 5 - 100));
        this.cherries.add(new Cherry(width - 200, height / 5 - 100));
        this.cherries.add(new Cherry((width / 7) * 5, height - 200));
        this.cherries.add(new Cherry(width / 5 + 100, height - 200));

        timer = new Timer(timerDelay, this);
        timer.start();
    }

    @Override
    public void paint(final Graphics gr) {
        gr.setColor(Color.BLACK);
        gr.fillRect(0, 0, getWidth(), getHeight());

        drawBlueRectangles(gr, -10, (getHeight() / 5) * 3 + 10, getWidth() / 5, getWidth() / 5);

        drawBlueRectangles(gr, -10, -10, getWidth() / 5, getHeight() / 5);

        drawBlueLines(gr, 0, getHeight() / 3, getWidth() / 3, getHeight() / 3);
        drawBlueLines(gr, getWidth() / 3, getHeight() / 3, getWidth() / 3, (getHeight() / 3) * 2);

        drawBlueRectangles(gr, getWidth() / 3, getHeight() - 200, getWidth() / 5, getHeight() - 200);

        drawBlueLines(gr, getWidth() / 3 + 200, 0, getWidth() / 3 + 200, (getHeight() / 3) * 2);

        drawBlueRectangles(gr, getWidth() / 2, getHeight() / 4, getWidth() / 5, getWidth() / 5);

        drawBlueLines(gr, getWidth() / 2, 5, (getWidth() / 5) * 4, 5);
        drawBlueLines(gr, (getWidth() / 5) * 4, 5, (getWidth() / 5) * 4, (getHeight() / 3) * 2);

        drawBlueRectangles(gr, (getWidth() / 10) * 9, getHeight() / 4, getWidth() / 5, (getWidth() / 3) * 2);

        drawBlueLines(gr, (getWidth() / 3) * 2, getHeight() - 5, ((getWidth() / 10) * 17) / 2, getHeight() - 5);
        drawBlueLines(gr, (getWidth() / 3) * 2, getHeight() - 5, (getWidth() / 3) * 2, getHeight() - 200);


        for (Cherry cherry: cherries) {
            cherry.draw(gr);
        }

        for (Pacman pacman: pacmans) {
            if (!pacman.isFlipped()) {
                pacman.setX(pacman.getX());
            } else {
                pacman.setX(pacman.getX());
            }
            pacman.draw(gr);
        }

        Font font = new Font("Georgia", Font.BOLD, 200);
        gr.setColor(Color.ORANGE);
        gr.setFont(font);
        String message = "Pacman";
        FontMetrics metrics = gr.getFontMetrics(font);
        int x = (getWidth() - metrics.stringWidth(message)) / 2;
        int y = getHeight() / 2;
        gr.drawString(message, x, y);
    }


    private void drawBlueRectangles(Graphics gr, int x, int y, int width, int height) {
        Graphics2D g2d = (Graphics2D) gr;
        g2d.setStroke(new BasicStroke(7));
        g2d.setColor(Color.BLUE);
        gr.drawRect(x, y, width, height);
    }

    private void drawBlueLines(Graphics gr, int x1, int y1, int x2, int y2) {
        Graphics2D g2d = (Graphics2D) gr;
        g2d.setStroke(new BasicStroke(7));
        g2d.setColor(Color.BLUE);
        gr.drawLine(x1, y1, x2, y2);
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        if (e.getSource() == timer) {
            repaint();
            for (Pacman pacman : pacmans) {
                if (!pacman.isFlipped()) {
                    pacman.setX(pacman.getX() + 1);
                } else {
                    pacman.setX(pacman.getX() - 1);
                }
            }
        }
    }

}
