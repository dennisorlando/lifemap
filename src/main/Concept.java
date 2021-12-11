package main;

import panel.Selectable;

public class Concept extends Selectable {
	
	public int top_y;
	public int bot_y;
	public int right_x;
	public int left_x;
	
	public int id;
	
	public String name;
	
	public Concept(int x, int y, String name) {
		//the coordinates Graphics2D uses are the ones of the top left corner 
		this.left_x = x;
		this.top_y = y;
		this.name = name;
		//if = random;
		this.selected = false;
	}
	public Concept(int x, int y, String name, int id) {
		this.left_x = x;
		this.top_y = y;
		this.name = name;
		this.id = id;
	}
	
	public void addComputedValues(int right_x, int bot_y) {
		this.right_x = right_x;
		this.bot_y = bot_y;
	}
	
	public int getCenterX() {
		return (right_x+left_x)/2;
	}
	public int getCenterY() {
		return (top_y+bot_y)/2;
	}
	
}
