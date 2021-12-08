package main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseEvents implements MouseListener, MouseMotionListener{

	private Space2D space;
	
	private int last_x = 0;
	private int last_y = 0;
	private boolean pressing;
	
	public MouseEvents(Space2D space) {
		this.space = space;
		pressing = false;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}
	@Override
	public void mousePressed(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		pressing = false;
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if(!pressing) {
			last_x = e.getX();
			last_y = e.getY();
			pressing = true;
		}
		else {
			int dx = e.getX()-last_x;
			int dy = e.getY()-last_y;
			space.x_translate += dx;
			space.y_translate += dy;
			last_y = e.getY();
			last_x = e.getX();
			space.repaint();
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

}
