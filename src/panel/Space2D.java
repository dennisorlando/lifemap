package panel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

import badstuff.Cursors;
import listeners.TextEditor;
import main.Concept;
import main.FloatingNode;
import main.Lifemap;
import main.Main;
import main.Node;
import main.State;



public class Space2D extends JPanel{

	public double x_translate = 0;
	public double y_translate = 0;
	
	public double viewport_center_x;
	public double viewport_center_y;
	
	public double vcd_x;
	public double vcd_y;
	
	public int x;
	public int y;
	
	private static final long serialVersionUID = -6102397487208146573L;
	private static final int CONCEPT_EDGE_WIDTH = 10;
	private static final int CONCEPT_EDGE_HEIGHT = 6;
	private static final int BACKGROUND_GRID_SPACING = 20;
	private static final int CONCEPT_SELECTED_ADDITIONAL_WIDTH = 5;
	
	public int EDITING_CONCEPT_ID = -1;
	public float scale = 1;
	
	public Lifemap lifemap;
	
	public void loadLifemap(Lifemap lifemap) {
		this.lifemap = lifemap;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);		
		
		Graphics2D g2d = (Graphics2D) g;
		
		drawBackgroundGrid(g2d);
		
		g2d.drawString(scale+"", 0, 50);
		g2d.setColor(Color.BLACK);
		
		
		g2d.scale(scale, scale);
		
		int effective_vc_x = (int) (viewport_center_x/scale);
		int effective_vc_y = (int) (viewport_center_y/scale);
		
		vcd_x = (int) (effective_vc_x - viewport_center_x);
		vcd_y = (int) (effective_vc_y - viewport_center_y);
		
		g2d.translate(x_translate+vcd_x, y_translate+vcd_y);
		
		g2d.setFont(new Font("TimesRoman", Font.PLAIN, 20));
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
		if(c.selected) {
			g.setStroke(new BasicStroke(CONCEPT_SELECTED_ADDITIONAL_WIDTH));
		}
		g.drawRoundRect((int)c.left_x, (int)c.top_y, (int) bounds.getWidth()+CONCEPT_EDGE_WIDTH*2, (int) bounds.getHeight()+CONCEPT_EDGE_HEIGHT*2, 10, 10);
		g.setStroke(new BasicStroke(1));
		int right_x = (int) (c.left_x + bounds.getWidth()+CONCEPT_EDGE_WIDTH*2);
		int bot_y = (int) (c.top_y+(bounds.getHeight()+CONCEPT_EDGE_HEIGHT*2));
		
		if (c.id == EDITING_CONCEPT_ID) {
			g.drawRect(c.left_x+CONCEPT_EDGE_WIDTH, c.top_y+CONCEPT_EDGE_HEIGHT, (int)bounds.getWidth(), (int)bounds.getHeight());
		}
		
		c.addComputedValues(right_x, bot_y);
		
	}
	private void paintNode(Node n, Graphics2D g) {
		
		Concept c1 = lifemap.getConcepts().get(n.concept_A_id);
		Concept c2 = lifemap.getConcepts().get(n.concept_B_id);
		
		float x1 = c1.getCenterX();
		float x2 = c2.getCenterX();
		float y1 = c1.getCenterY();
		float y2 = c2.getCenterY();
		
		g.drawLine((int)x1,(int)y1,(int)x2,(int)y2);
		
	}
	private void paintFloatingNode(FloatingNode n, Graphics2D g) {
		g.setColor(new Color(100,0,50));
		g.drawLine(n.x1, n.y1, n.x2, n.y2);
		g.setColor(Color.BLACK);
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
		for (FloatingNode f : lifemap.getFloatingNodes()) {
			paintFloatingNode(f, g2d);
		}
		clickedbject(x,y,10,g2d);
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

	public Selectable clickedObject(int x_, int y_) {
		
		double x = screenToCanvasX(x_);
		double y = screenToCanvasY(y_);
		
		for (Concept c : lifemap.getConcepts().values()) {
			if (y > c.top_y && y < c.bot_y && x > c.left_x && x < c.right_x) {
				return c;
			}
		}
		return null;
	}
	public void clickedbject(int x_, int y_, double radius, Graphics2D g) {
		double x = screenToCanvasX(x_);
		double y = screenToCanvasY(y_);
		
		for (Node n : lifemap.getNodes()) {

			Concept c1 = lifemap.getConcepts().get(n.concept_A_id);
			Concept c2 = lifemap.getConcepts().get(n.concept_B_id);
			
			float x1 = c1.getCenterX();
			float x2 = c2.getCenterX();
			float y1 = c1.getCenterY();
			float y2 = c2.getCenterX();
			
			float m = (y1-y2)/(x1-x2);
			float mP = -1f/m;
			System.out.println(m);
			float q = y_-mP*x_;
			
			g.drawLine(0, (int)q, 500, (int) (mP*500+q));
			
		}
	}
	
	public double screenToCanvasX(double x) {
		return x/scale - x_translate - vcd_x;
	}
	public double screenToCanvasY(double y) {
		return y/scale - y_translate - vcd_y;
	}
	public double canvasToScreenX(double x) {
		return (x+x_translate+vcd_x)*scale;
	}
	public double canvasToScreenY(double y) {
		return (y+y_translate+vcd_y)*scale;
	}
	public void editConceptText(Concept c) {
		this.setCursor(Cursors.blank);
		Main.state = State.EDITING_CONCEPT_TEXT;
		Main.jframe.removeKeyListener(Main.jframe.getKeyListeners()[0]);
		Main.jframe.addKeyListener(new TextEditor(this, c));
		EDITING_CONCEPT_ID = c.id;
		lifemap.save();
		this.repaint();
	}
	public void save() {
		lifemap.save();
	}
}
