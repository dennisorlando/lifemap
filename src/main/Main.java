package main;

import javax.swing.JFrame;

public class Main {
	
	public static void main(String[] args) {
		Lifemap lifemap = new Lifemap("/orly/documents/lifemap_prova");
		
		//setup frame
		JFrame jframe = new JFrame();
		jframe.setTitle("LifeMap");
		jframe.setSize(500,500);
		jframe.setLocationRelativeTo(null);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Space2D space = new Space2D();
		space.loadLifemap(lifemap);
		jframe.add(space);
		
		MouseEvents mousy = new MouseEvents(space);
		jframe.addMouseListener(mousy);
		jframe.addMouseMotionListener(mousy);
		
		jframe.setVisible(true);
		
	}
	
	
	
}
