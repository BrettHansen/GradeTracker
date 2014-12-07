import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.Timer;

public class GUI extends JPanel {

    private JFrame frame;
    private JPanel container;
    private JScrollPane scrollpane;

    private ArrayList<Course> courses;
    private Timer timer;

    private int width;
    private int height;
    private int lineHeight;

    public GUI(ArrayList<Course> courses) {
	this.courses = courses;
	width = 500;
	height = 500;
	lineHeight = 20;

	frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	container = new JPanel();
	container.setLayout(new BorderLayout());
	container.add(this, BorderLayout.CENTER);
	scrollpane = new JScrollPane(container);
	scrollpane.getVerticalScrollBar().setUnitIncrement(10);
	scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	scrollpane.setPreferredSize(new Dimension(width, height));
	frame.getContentPane().add(scrollpane);
	frame.pack();

	timer = new Timer(30, new TimerListener());
	timer.start();
	frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
	int h = 1;
	for(int c = 0; c < courses.size(); c++) {
	    h++;
	    for(int s = 0; s < courses.get(c).sections.size(); s++)
		h += courses.get(c).sections.get(s).items.size() + 1;
	}
	setPreferredSize(new Dimension(width, h * lineHeight));
	revalidate();
		
	BufferedImage image = new BufferedImage(width, h * lineHeight, BufferedImage.TYPE_INT_ARGB);
	Graphics2D g2 = image.createGraphics();
	
	drawCourses(g2);

	g.clearRect(0, 0, frame.getWidth(), h * lineHeight);
	g.drawImage(image, 0, 0, null);
	g.dispose();
	g2.dispose();
    }

    private void drawCourses(Graphics2D g2) {
	int position = 0;
	Course cTemp;
	Section sTemp;
	Item iTemp;
	for (int c = 0; c < courses.size(); c++) {
	    cTemp = courses.get(c);
	    cTemp.element.setPosition(new Point(0, position += 20));
	    g2.drawImage(cTemp.element.getImage(), 0, position, null);
	    for (int s = 0; s < cTemp.sections.size(); s++) {
		sTemp = cTemp.sections.get(s);
		sTemp.element.setPosition(new Point(0, position += 20));
		g2.drawImage(sTemp.element.getImage(), 0, position, null);
		for (int i = 0; i < sTemp.items.size(); i++) {
		    iTemp = sTemp.items.get(i);
		    iTemp.element.setPosition(new Point(0, position += 20));
		    g2.drawImage(iTemp.element.getImage(), 0, position, null);
		}
	    }
	}
    }

    private class TimerListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
	    repaint();
	}

    }

}