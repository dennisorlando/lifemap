package listeners;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import main.Main;
import panel.Space2D;

public class Window implements WindowListener{

	private Space2D space;
	
	public Window(Space2D space) {
		this.space = space;
	}
	
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		space.lifemap.save();
		Main.running = false;
		System.out.println("Lifemap saved");
	}

	@Override
	public void windowClosed(WindowEvent e) {
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
