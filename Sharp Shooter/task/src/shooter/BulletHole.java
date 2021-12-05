package shooter;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

public class BulletHole {

    private static final int bulletRadius = 5;

    public static final BufferedImage IMAGE = createImage();

    private static BufferedImage createImage() {
        BufferedImage image = new BufferedImage(2*bulletRadius, 2*bulletRadius, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2 = image.createGraphics();
        Ellipse2D ellipse = new Ellipse2D.Double(0, 0, 2*bulletRadius, 2*bulletRadius);
        g2.setPaint(Color.CYAN);
        g2.fill(ellipse);
        g2.setPaint(Color.BLUE);
        g2.draw(ellipse);

        return image;
    }
}
