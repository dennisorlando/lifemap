package main;

import panel.Selectable;

public class Node extends Selectable{
	
	public int concept_A_id;
	public int concept_B_id;
	
	public int x1, x2, y1, y2;
	
	public boolean floating;
	
	public String description;
	
	public Node(int conceptA_ID, int conceptB_ID, String description, int x1, int y1, int x2, int y2) {
		this.concept_A_id = conceptA_ID;
		this.concept_B_id = conceptB_ID;
		this.description = description;
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	
	
	
	public void calculateCoords(Lifemap lifemap) {
		Concept c1 = lifemap.getConcepts().get(this.concept_A_id);
		Concept c2 = lifemap.getConcepts().get(this.concept_B_id);
		
		this.x1 = c1.getCenterX();
		this.x2 = c2.getCenterX();
		this.y1 = c1.getCenterY();
		this.y2 = c2.getCenterY();
	}
	
	public String toString() {
		return this.concept_A_id+"->"+this.concept_B_id+":'"+this.description+"'";
	}
	
	public double distanceFrom(Lifemap lifemap, int canvasX, int canvasY) {
		Concept c1 = lifemap.getConcepts().get(concept_A_id);
		Concept c2 = lifemap.getConcepts().get(concept_B_id);
		
		float x1,x2,y1,y2;
		
		try {
			x1 = c1.getCenterX();
			x2 = c2.getCenterX();
			y1 = c1.getCenterY();
			y2 = c2.getCenterY();
		}
		catch (NullPointerException e) {
			x1 = this.x1;
			x2 = this.x2;
			y1 = this.y1;
			y2 = this.y2;
		}
		
		float m = (y1-y2)/(x1-x2);
		float q = y1-m*x1;
		
		float m2 = -1f/m;
		float q2 = canvasY-m2*canvasX;
		
		float xi = (q2-q)/(m-m2);
		
		double distance0 = Math.sqrt(Math.pow(m2*xi+q2-canvasY, 2)+Math.pow(xi-canvasX, 2));
		
		double distance1 = Math.sqrt(Math.pow(canvasY-y1, 2)+Math.pow(canvasX-x1, 2));
		double distance2 = Math.sqrt(Math.pow(canvasY-y2, 2)+Math.pow(canvasX-x2, 2));
		
		if ((x1 < xi && x2 > xi) || (x1 > xi && x2 < xi)) {
			return distance0;
		}
		else {
			if (distance1 < distance2 ) {
				return distance1;
			}
			else {
				return distance2;
			}
		}
		
	}
}
