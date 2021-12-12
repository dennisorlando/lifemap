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
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyChar() == 'c') {
			space.setCursor(Cursors.cross);
			Main.state = State.CREATING_CONCEPT;
		}
		if (e.getKeyChar() == 'd') {
			space.setCursor(Cursors.delete);
			Main.state = State.DELETE;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
