package listeners;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import main.Concept;
import main.Main;
import main.State;
import panel.Selectable;
import panel.Space2D;

public class MouseEvents implements MouseListener, MouseMotionListener{

	private Space2D space;
	
	private int last_x = 0;
	private int last_y = 0;
	
	public MouseEvents(Space2D space) {
		this.space = space;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (Main.state == State.EDITING_CONCEPT_TEXT) {
			return;
		}
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
	@Override
	public void mousePressed(MouseEvent e) {
		switch(Main.state) {
		default: 
			System.out.println("Unhandled: mousepressed");
			break;
		case DEFAULT:
			last_x = e.getX();
			last_y = e.getY();
			Main.state = State.DRAGGING;
			space.setCursor(new Cursor(Cursor.HAND_CURSOR));
			break;
		case EDITING_CONCEPT_TEXT:
			break;
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		switch(Main.state) {
		case EDITING_CONCEPT_TEXT:
			break;
		default: 
			System.out.println("Unhandled: mousepressed");
			break;
		case DEFAULT:
			break;
		case DRAGGING:
			space.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			Main.state = State.DEFAULT;
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
			System.out.println("Unhandled: mousepressed");
			break;
		case DRAGGING:
			int dx = e.getX()-last_x;
			int dy = e.getY()-last_y;
			space.x_translate += dx;
			space.y_translate += dy;
			last_y = e.getY();
			last_x = e.getX();
			space.repaint();
			break;
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

}
