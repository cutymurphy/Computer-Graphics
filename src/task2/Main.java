package task2;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        MainWindow window = new MainWindow(1000, 1000);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setSize(1000, 1000);
        window.setVisible(true);
    }
}