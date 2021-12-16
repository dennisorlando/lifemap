package listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import badstuff.Cursors;
import main.Main;
import main.State;
import panel.Space2D;

public class DefaultKeyListener implements KeyListener{

	private Space2D space;
	
	public DefaultKeyListener(Space2D space) {
		this.space = space;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		switch (Main.state) {
		case DEFAULT:
			if (e.getKeyChar() == ' ') {
				Main.state = State.MOVING;
				space.setCursor(Cursors.blank);
			}
			break;
		case MOVING:
			if (e.getKeyChar() == ' ') {
				Main.state = State.DEFAULT;
				MouseEvents.recalculate = true;
				space.setCursor(Cursors.default_cursor);
			}
			break;
		default:
			break;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyChar()) {
		case 'c':
			space.setCursor(Cursors.cross);
			Main.state = State.CREATING_CONCEPT;
			break;
		case 'd':
			space.setCursor(Cursors.delete);
			Main.state = State.DELETE;
			break;
		case 'n':
			space.setCursor(Cursors.node);
			Main.state = State.ADDING_NODE_0;
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

}
