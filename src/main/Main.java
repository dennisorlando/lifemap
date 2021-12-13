package main;

import javax.swing.JFrame;

import listeners.DefaultKeyListener;
import listeners.MouseEvents;
import listeners.Window;
import panel.Space2D;

public class Main {

	public static boolean running = true;
	
	public static State state = State.DEFAULT;
	public static JFrame jframe;
	
	public static final int MAX_FRAMERATE = 360;
	public static double delta_time;
	
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
		space.addMouseWheelListener(mousy);
		
		jframe.add(space);
		jframe.addKeyListener(new DefaultKeyListener(space));
		jframe.addWindowListener(new Window(space));
		jframe.setVisible(true);
		
		/*while (running) {
			long start = System.nanoTime();
			space.repaint();

			long middle = System.nanoTime();
			long delta_nano = middle - start;
			
			long min_time_millis = 1000/MAX_FRAMERATE;
			
			try {
				Thread.sleep(Math.max(min_time_millis-delta_nano/1000000, 0));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			long end = System.nanoTime();
			delta_time = (end-start)/1000000000d;
		}*/
		
	}
	
	
	
}
