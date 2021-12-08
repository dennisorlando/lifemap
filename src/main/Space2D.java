package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;



public class Space2D extends JPanel{

	int x_translate = 0;
	int y_translate = 0;
	
	private static final long serialVersionUID = -6102397487208146573L;
	private static final int CONCEPT_EDGE_WIDTH = 10;
	private static final int CONCEPT_EDGE_HEIGHT = 6;
	private static final int BACKGROUND_GRID_SPACING = 20;
	
	private Lifemap lifemap;
	
	public void loadLifemap(Lifemap lifemap) {
		this.lifemap = lifemap;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);		
		
		Graphics2D g2d = (Graphics2D) g;
		
		g.translate(x_translate/10, y_translate/10);
		drawBackgroundGrid(g2d);
		
		g.translate(x_translate, y_translate);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		g2d.setRenderingHint(
			    RenderingHints.KEY_ANTIALIASING,
			    RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(
		        RenderingHints.KEY_TEXT_ANTIALIASING,
		        RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		
		drawMap(g2d);
	}
	
	private void paintConcept(Concept c, Graphics2D g) {
		
		Rectangle2D bounds = g.getFontMetrics().getStringBounds(c.name, g);
		g.setPaint(Color.LIGHT_GRAY);
		g.fillRoundRect((int)c.left_x, (int)c.top_y, (int) bounds.getWidth()+CONCEPT_EDGE_WIDTH*2, (int) bounds.getHeight()+CONCEPT_EDGE_HEIGHT*2, 10, 10);
		g.setPaint(Color.BLACK);
		g.drawString(c.name, c.left_x+CONCEPT_EDGE_WIDTH, c.top_y+(int)bounds.getHeight()+CONCEPT_EDGE_HEIGHT/2);
		g.drawRoundRect((int)c.left_x, (int)c.top_y, (int) bounds.getWidth()+CONCEPT_EDGE_WIDTH*2, (int) bounds.getHeight()+CONCEPT_EDGE_HEIGHT*2, 10, 10);
		
		int right_x = (int) (c.left_x + bounds.getWidth()+CONCEPT_EDGE_WIDTH*2);
		int bot_y = (int) (c.top_y+(bounds.getHeight()+CONCEPT_EDGE_HEIGHT*2));
		
		c.addComputedValues(right_x, bot_y);
		//todo: returns in strings
		
	}
	private void paintNode(Node n, Graphics2D g) {
		
		Concept c1 = lifemap.getConcepts().get(n.concept_A_id);
		Concept c2 = lifemap.getConcepts().get(n.concept_B_id);
		
		g.drawLine(c1.getCenterX(), c1.getCenterY(), c2.getCenterX(), c2.getCenterY());
	}
	
	public void drawMap(Graphics2D g2d) {
		
		if(lifemap == null) {
			System.out.println("no lifemap loaded");
			return;
		}
		
		for (Node n : lifemap.getNodes()) {
			paintNode(n, g2d);
		}
		for (Concept c : lifemap.getConcepts().values()) {
			paintConcept(c, g2d);
		}
		
	}

	public void drawBackgroundGrid(Graphics2D g2d) {
		
		int screen_width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screen_height = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		g2d.setColor(Color.LIGHT_GRAY);
		for (int x = 0; x < 1+screen_width/BACKGROUND_GRID_SPACING; x++) {
			int t_ = x*BACKGROUND_GRID_SPACING;
			g2d.drawLine(t_, 0, t_, screen_height);
		}
		for (int x = 0; x < 1+screen_height/BACKGROUND_GRID_SPACING; x++) {
			int t_ = x*BACKGROUND_GRID_SPACING;
			g2d.drawLine(0, t_, screen_width, t_);
		}
		
	}
}
