import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Element {

    public static final int TYPE_COURSE = 0;
    public static final int TYPE_SECTION = 1;
    public static final int TYPE_ITEM = 2;

    private String name;
    private double earndPoints;
    private double totalPoints;

    private Rectangle bounds;

    private int type;

    public Element(int type, String name) {
	this(type, name, -1);
    }

    public Element(int type, String name, double totalPoints) {
	this(type, name, totalPoints, -1);
    }

    public Element(int type, String name, double totalPoints, double earndPoints) {
	this.type = type;

	this.name = name;
	this.totalPoints = totalPoints;
	this.earndPoints = earndPoints;
    }

    public void setPosition(Point pos) {
	bounds = new Rectangle(pos);
	bounds.setSize(400, 20);

	switch (type) {
	case TYPE_COURSE:
	    break;
	case TYPE_SECTION:
	    break;
	case TYPE_ITEM:
	    break;
	}
    }

    public BufferedImage getImage() {
	BufferedImage image = new BufferedImage(400, 20, BufferedImage.TYPE_INT_ARGB);
	Graphics2D g2 = (Graphics2D) image.getGraphics();

	g2.setColor(Color.black);
	g2.drawRect(0, 0, 399, 20);
	g2.drawString(name, 15 * type + 5, 15);
	
	if (earndPoints != -1)
	    g2.drawString(String.format("%-7.2f", earndPoints), 200, 15);
	
	if (totalPoints != -1)
	    g2.drawString(String.format("/"), 240, 15);
	
	if (totalPoints != -1)
	    g2.drawString(String.format("%-7.2f =", totalPoints), 250, 15);
	
	if (earndPoints != -1 && totalPoints != -1)
	    g2.drawString(String.format("%-7.2f%%", earndPoints / totalPoints * 100), 300, 15);

	g2.dispose();
	return image;
    }

}
