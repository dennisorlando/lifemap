package listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import badstuff.Cursors;
import main.Concept;
import main.FloatingNode;
import main.Main;
import main.Node;
import main.State;
import panel.Selectable;
import panel.Space2D;

public class MouseEvents implements MouseListener, MouseMotionListener, MouseWheelListener{

	private Space2D space;
	
	private int last_x = 0;
	private int last_y = 0;
	
	private FloatingNode fn;
	
	public MouseEvents(Space2D space) {
		this.space = space;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		int canvasX = (int) space.screenToCanvasX(e.getX());
		int canvasY = (int) space.screenToCanvasY(e.getY());
		
		switch(Main.state) {
		case ADDING_NODE_1:
			fn.x2 = canvasX;
			fn.y2 = canvasY;
			
			Selectable c1 = space.clickedObject((int)space.canvasToScreenX(fn.x1), (int)space.canvasToScreenY(fn.y1));
			Selectable c2 = space.clickedObject(e.getX(), e.getY());
			
			if(c1 instanceof Concept && c2 instanceof Concept) {
				Node n = new Node(((Concept) c1).id, ((Concept) c2).id, fn.description);
				space.lifemap.addNode(n);
				space.lifemap.getFloatingNodes().remove(fn);
			}
			
			space.setCursor(Cursors.default_cursor);
			Main.state = State.DEFAULT;
			System.out.println(Main.state);
			break;
		case ADDING_NODE_0:
			fn = new FloatingNode("",canvasX, canvasY, canvasX, canvasY);
			Main.state = State.ADDING_NODE_1;
			space.lifemap.addFloatingNode(fn);
			space.repaint();
			break;
		case EDITING_CONCEPT_TEXT:
			return;
		case CREATING_CONCEPT:
			space.setCursor(Cursors.default_cursor);
			Main.state = State.DEFAULT;
			Concept c = new Concept(canvasX, canvasY, "");
			space.lifemap.createConcept(c);
			space.editConceptText(c);
			space.repaint();
			break;
		case DELETE:
			Selectable s_ = space.clickedObject(e.getX(), e.getY());
			if (s_ != null) {
				if (s_ instanceof Concept) {
					space.lifemap.getConcepts().remove(((Concept) s_).id);
					space.lifemap.save();
				}
			}
			else {
				//asdf
			}
			Main.state = State.DEFAULT;
			space.setCursor(Cursors.default_cursor);
			space.repaint();
			break;
			
		default:
			Selectable s = space.clickedObject(e.getX(), e.getY());
			if (s != null) {
				switch(e.getClickCount()) {
				case 1:
					s.selected = (s.selected) ? false : true;
					space.repaint();
					break;
				case 2:
					s.selected = true;
					if (s instanceof Concept) {
						space.editConceptText((Concept) s);
					}
				}
			}
		}
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		switch(Main.state) {
		default: 
			System.out.println("Unhandled: mouse press");
			break;
		case DEFAULT:
			last_x = e.getX();
			last_y = e.getY();
			Main.state = State.DRAGGING;
			space.setCursor(Cursors.hand);
			break;
		case EDITING_CONCEPT_TEXT:
			break;
		case CREATING_CONCEPT:
			break;
		case DELETE:
			break;
		case ADDING_NODE_0, ADDING_NODE_1:
			break;
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		switch(Main.state) {
		case EDITING_CONCEPT_TEXT:
			break;
		default: 
			System.out.println("Unhandled: mouse release");
			break;
		case DEFAULT:
			break;
		case DRAGGING:
			space.setCursor(Cursors.default_cursor);
			Main.state = State.DEFAULT;
		case DELETE:
			break;
		case ADDING_NODE_0, ADDING_NODE_1:
			break;
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		switch(Main.state) {
		case EDITING_CONCEPT_TEXT:
			break;
		default: 
			System.out.println("Unhandled: mouse drag");
			break;
		case DRAGGING:
			int dx = e.getX()-last_x;
			int dy = e.getY()-last_y;
			space.x_translate += dx/space.scale;
			space.y_translate += dy/space.scale;
			last_y = e.getY();
			last_x = e.getX();
			space.repaint();
			break;
		case CREATING_CONCEPT:
			break;
		case DELETE:
			break;
		case ADDING_NODE_0, ADDING_NODE_1:
			break;
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
		space.x = e.getX();
		space.y = e.getY();
		space.repaint();
		
		int canvasX = (int) space.screenToCanvasX(e.getX());
		int canvasY = (int) space.screenToCanvasY(e.getY());
		
		switch(Main.state) {
		case ADDING_NODE_1:
			fn.x2 = canvasX;
			fn.y2 = canvasY;
			space.repaint();
			break;
		default:
			break;
		}
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		
		space.viewport_center_x -= (space.viewport_center_x-e.getX())/10;
		space.viewport_center_y -= (space.viewport_center_y-e.getY())/10;
		
		space.scale -= e.getWheelRotation()/100f;
		
		//System.out.println(eff_view_center_x+"/"+eff_view_center_y);
		
		
		
		space.repaint();
		
		
		
	}

}
