package shooter;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;

public class Sight {

    private static final int sightRadius = 40;
    private static final int sightInset = (int) (0.8 * sightRadius);
    public static final BufferedImage IMAGE = createImage();

    private static BufferedImage createImage() {
        BufferedImage image = new BufferedImage(2*sightRadius, 2*sightRadius, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2 = image.createGraphics();

        Ellipse2D ellipse = new Ellipse2D.Double(2, 2, 2*sightRadius - 4, 2*sightRadius - 4);
        g2.setPaint(Color.RED);
        g2.setStroke(new BasicStroke(5));
        g2.draw(ellipse);

        g2.setStroke(new BasicStroke(2));
        Line2D line = new Line2D.Double(0, sightRadius, sightInset, sightRadius);
        g2.draw(line);
        line = new Line2D.Double(2 * sightRadius - sightInset, sightRadius, 2 * sightRadius, sightRadius);
        g2.draw(line);
        line = new Line2D.Double(sightRadius, 0, sightRadius, sightInset);
        g2.draw(line);
        line = new Line2D.Double(sightRadius, 2 * sightRadius - sightInset, sightRadius, 2 * sightRadius);
        g2.draw(line);

        return image;
    }
}
