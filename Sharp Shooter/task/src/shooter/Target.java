package shooter;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

public class Target {

    private static final int imageWidth = 700;
    private static final int imageHeight = 700;
    private static final int radiusDiff = 30;

    public static final BufferedImage IMAGE = createImage();

    private static BufferedImage createImage() {
        BufferedImage image = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = image.createGraphics();
        Font font = new Font("SansSerif", Font.BOLD, 24);

        Rectangle rect = new Rectangle(0, 0, imageWidth, imageHeight);
        g2.setPaint(Color.DARK_GRAY);
        g2.fill(rect);

        for (int i = 10; i > 0; i--) {
            Ellipse2D ellipse = new Ellipse2D.Double(imageWidth/2 - i*radiusDiff, imageHeight/2 - i*radiusDiff, 2*i*radiusDiff, 2*i*radiusDiff);

            Color innerColor;
            Color borderColor;
            if (i == 4 || i == 3 || i == 2) {
                innerColor = Color.WHITE;
                borderColor = Color.BLACK;
            } else {
                innerColor = Color.BLACK;
                borderColor = Color.WHITE;
            }

            g2.setPaint(innerColor);
            g2.fill(ellipse);

            g2.setPaint(borderColor);
            g2.draw(ellipse);
        }
        return image;
    }
}
