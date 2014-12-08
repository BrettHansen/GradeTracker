import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Element {

    public static final int TYPE_COURSE = 0;
    public static final int TYPE_SECTION = 1;
    public static final int TYPE_ITEM = 2;

    public String name;
    public double earndPoints;
    public double totalPoints;
    public double percentage;

    private Rectangle bounds;
    private Color normalColor;
    private Color highlightColor;
    private Color bgColor;
    private boolean colorCodedOutput;

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

	normalColor = new Color(220, 220, 220);
	highlightColor = new Color(180, 180, 180);
	bgColor = normalColor;
	
	if(type == TYPE_ITEM)
	    colorCodedOutput = true;
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

    public boolean contains(Point p) {
	return bounds.contains(p);
    }

    public void highlight() {
	bgColor = highlightColor;
    }

    public void unhighlight() {
	bgColor = normalColor;
    }

    public BufferedImage getImage() {
	BufferedImage image = new BufferedImage(500, 20, BufferedImage.TYPE_INT_ARGB);
	Graphics2D g2 = (Graphics2D) image.getGraphics();

	g2.setColor(bgColor);
	g2.fillRect(0, 0, image.getWidth() - 1, image.getHeight());
	g2.setColor(highlightColor);
	g2.drawRect(0, 0, image.getWidth(), image.getHeight());
	if (type == TYPE_COURSE || type == TYPE_SECTION) {
	    g2.setColor(Color.black);
	    g2.drawLine(0, 0, image.getWidth(), 0);
	    if (type == TYPE_COURSE)
		g2.drawLine(0, 1, image.getWidth(), 1);
	}
	g2.setColor(Color.darkGray);
	g2.setFont(new Font("Courier", 0, 12));
	g2.drawString(String.format("%.18s", name), 30 * type + 5, 15);

	String p1 = "";
	String p2 = "";
	String p3 = "";

	if (type == TYPE_ITEM || type == TYPE_SECTION) {
	    if (earndPoints != -1)
		p1 = String.format("%6.2f  /  ", earndPoints);
	    if (totalPoints != -1)
		p2 = String.format("%6.2f  =", totalPoints);
	    if (earndPoints != -1 && totalPoints != -1)
		p3 = String.format("  %7.2f %%", earndPoints / totalPoints * 100);
	}

	if (type == TYPE_COURSE) {
	    g2.setFont(new Font("Courier", 1, 12));
	    p3 = String.format("%.2f %%", percentage);
	}

	double perc = earndPoints / totalPoints;
	if (totalPoints != -1 || type == TYPE_COURSE) {
	    if (colorCodedOutput)
		g2.setColor(new Color((perc < .95) ? (int) ((1 - perc / .95) * 240) : 0, (int) (perc * 200), 20));
	    g2.drawString(String.format("%s%s%s", p1, p2, p3), 200, 15);
	}

	g2.dispose();
	return image;
    }

}
