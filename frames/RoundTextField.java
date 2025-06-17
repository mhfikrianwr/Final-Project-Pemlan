package frames;
import java.awt.*;
import javax.swing.*;

public class RoundTextField extends JTextField {

    private int arcWidth = 20;  // How round the corners are
    private int arcHeight = 20;

    public RoundTextField(int columns) {
        super(columns);
        setOpaque(false);  // So background can be custom painted
        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));  // Padding
    }

    @Override
    protected void paintComponent(Graphics g) {
        // Convert to 2D
        Graphics2D g2 = (Graphics2D) g.create();

        // Enable anti-aliasing for smooth corners
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Background color
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), arcWidth, arcHeight);

        // Call superclass to paint text
        super.paintComponent(g);

        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Border color
        g2.setColor(Color.GRAY);
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arcWidth, arcHeight);

        g2.dispose();
    }
}
