import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

// Separate static imports (as required)
import static java.lang.Math.random;

public class Exercise8_9 {

    // Line class (replacing MyLine for a self-contained file)
    static class MyLine {
        private int x1, y1, x2, y2;
        private Color color;

        public MyLine(int x1, int y1, int x2, int y2, Color color) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.color = color;
        }

        public void draw(Graphics g) {
            g.setColor(color);
            g.drawLine(x1, y1, x2, y2);
        }
    }

    // Panel class
    static class DrawPanel extends JPanel {

        private MyLine[] lines;

        public DrawPanel() {
            setBackground(Color.WHITE);

            // using Math.random()
            lines = new MyLine[5 + (int)(random() * 5)];

            for (int i = 0; i < lines.length; i++) {

                int x1 = (int)(random() * 300);
                int y1 = (int)(random() * 300);
                int x2 = (int)(random() * 300);
                int y2 = (int)(random() * 300);

                Color color = new Color(
                        (int)(random() * 256),
                        (int)(random() * 256),
                        (int)(random() * 256)
                );

                lines[i] = new MyLine(x1, y1, x2, y2, color);
            }
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            for (MyLine line : lines)
                line.draw(g);
        }
    }

    // Main method (test program)
    public static void main(String[] args) {

        DrawPanel panel = new DrawPanel();
        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}