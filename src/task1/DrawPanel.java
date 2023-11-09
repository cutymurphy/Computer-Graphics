package task1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class DrawPanel extends JPanel implements ActionListener {

    private int PANEL_WIDTH;
    private int PANEL_HEIGHT;
    private int TIMER_DELAY;
    private Timer timer;
    private List<Drawable> objects = new ArrayList<>();
    
    public DrawPanel(int width, int height, int timerDelay) {
        this.PANEL_WIDTH = width;
        this.PANEL_HEIGHT = height;
        this.TIMER_DELAY = timerDelay;

        this.objects.add(new Wall(0, height / 3, width / 3, height / 3, true));
        this.objects.add(new Wall(width / 3, height / 3, width / 3, (height / 3) * 2, true));
        this.objects.add(new Wall(width / 3 + 200, 0, width / 3 + 200, (height / 3) * 2, true));
        this.objects.add(new Wall(width / 2, 5, (width / 5) * 4, 5, true));
        this.objects.add(new Wall((width / 5) * 4, 5, (width / 5) * 4, (height / 3) * 2, true));
        this.objects.add(new Wall((width / 3) * 2, height - 5, ((width / 10) * 17) / 2, height - 5, true));
        this.objects.add(new Wall((width / 3) * 2, height - 5, (width / 3) * 2, height - 200, true));

        this.objects.add(new Wall(-10, (height / 5) * 3 + 10, width / 5, width / 5, false));
        this.objects.add(new Wall(-10, -10, width / 5, height / 5, false));
        this.objects.add(new Wall(width / 3, height - 200, width / 5, height - 200, false));
        this.objects.add(new Wall(width / 2, height / 4, width / 5, width / 5, false));
        this.objects.add(new Wall((width / 10) * 9, height / 4, width / 5, (width / 3) * 2, false));

        this.objects.add(new Cherry(width / 2 + 450, height / 2 - 100));
        this.objects.add(new Cherry((width / 10) * 3, height / 5 - 100));
        this.objects.add(new Cherry(width - 200, height / 5 - 100));
        this.objects.add(new Cherry((width / 7) * 5, height - 200));
        this.objects.add(new Cherry(width / 5 + 100, height - 200));

        this.objects.add(new Pacman(0, height / 3 - 20, 200, 45, Color.GREEN, false));
        this.objects.add(new Pacman(300, height - 300, 200, 45, Color.PINK, false));
        this.objects.add(new Pacman(width - 200, 0, 200, 45, Color.CYAN, true));

        timer = new Timer(timerDelay, this);
        timer.start();
    }

    @Override
    public void paint(final Graphics gr) {
        Graphics2D g = (Graphics2D) gr;

        gr.setColor(Color.BLACK);
        gr.fillRect(0, 0, getWidth(), getHeight());

        for (Drawable object : objects) {
            if (object.getClass() == Pacman.class) {
                Pacman pacman = (Pacman) object;
                if (!pacman.isFlipped()) {
                    pacman.setX(pacman.getX() + 1);
                } else {
                    pacman.setX(pacman.getX() - 1);
                }
            }
            object.draw(g);
        }

        //по-хорошему тоже надо реализовать как реализующего Drawable
        Font font = new Font("Georgia", Font.BOLD, 200);
        gr.setColor(Color.MAGENTA);
        gr.setFont(font);
        String message = "task1.Pacman";
        FontMetrics metrics = gr.getFontMetrics(font);
        int x = (getWidth() - metrics.stringWidth(message)) / 2;
        int y = getHeight() / 2;
        gr.drawString(message, x, y);
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        if (e.getSource() == timer) {
            repaint();
        }
    }

}
