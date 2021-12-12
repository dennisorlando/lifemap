package listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import badstuff.Cursors;
import main.Concept;
import main.Main;
import main.State;
import panel.Selectable;
import panel.Space2D;

public class MouseEvents implements MouseListener, MouseMotionListener, MouseWheelListener{

	private Space2D space;
	
	private int last_x = 0;
	private int last_y = 0;
	
	public MouseEvents(Space2D space) {
		this.space = space;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		switch(Main.state) {
		case EDITING_CONCEPT_TEXT:
			return;
		case CREATING_CONCEPT:
			space.setCursor(Cursors.default_cursor);
			Main.state = State.DEFAULT;
			Concept c = new Concept(e.getX()-(int)space.x_translate, e.getY()-(int)space.y_translate, "");
			space.lifemap.createConcept(c);
			space.editConceptText(c);
			space.repaint();
			break;
		case DELETE:
			Selectable s_ = space.clickedObject(e.getX(), e.getY());
			if (s_ != null) {
				if (s_ instanceof Concept) {
					space.lifemap.getConcepts().remove(((Concept) s_).id);
				}
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
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {

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
