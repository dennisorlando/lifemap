package main;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

import listeners.MouseEvents;
import panel.Space2D;

public class Main {
	
	public static State state = State.DEFAULT;
	public static JFrame jframe;
	
	public static void main(String[] args) {
		Lifemap lifemap = new Lifemap("/orly/documents/lifemap_prova");
		
		//setup frame
		jframe = new JFrame();
		jframe.setTitle("LifeMap");
		jframe.setSize(500,500);
		jframe.setLocationRelativeTo(null);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Space2D space = new Space2D();
		space.loadLifemap(lifemap);
		
		MouseEvents mousy = new MouseEvents(space);
		space.addMouseListener(mousy);
		space.addMouseMotionListener(mousy);
		
		jframe.add(space);
		jframe.setVisible(true);
		
		//autosave
		Timer t = new Timer();
		t.scheduleAtFixedRate(new TimerTask(){

			@Override
			public void run() {
				space.save();
			}
			
		}, 1000, 1000);
	}
	
	
	
}
