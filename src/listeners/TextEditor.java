package listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import badstuff.Cursors;
import main.Concept;
import main.Main;
import main.State;
import panel.Space2D;

public class TextEditor implements KeyListener{

	private Space2D space;
	private Concept concept;
	
	public TextEditor(Space2D space, Concept c) {
		this.space = space;
		this.concept = c;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case 10:
			Main.jframe.removeKeyListener(this);
			Main.state = State.DEFAULT;
			space.setCursor(Cursors.default_cursor);
			space.EDITING_CONCEPT_ID = -1;
			Main.jframe.addKeyListener(new DefaultKeyListener(space));
			space.repaint();
		case 20,16,17,18:
			break;
		case 8:
			concept.name = concept.name.substring(0, Math.max(concept.name.length()-1, 0));
			break;
		default:
			concept.name += e.getKeyChar();
			break;
		}
		space.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
	
	
}
