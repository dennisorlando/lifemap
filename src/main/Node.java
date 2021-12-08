package main;

public class Node {
	
	int concept_A_id;
	int concept_B_id;
	
	String description;
	
	public Node(int conceptA_ID, int conceptB_ID, String description) {
		this.concept_A_id = conceptA_ID;
		this.concept_B_id = conceptB_ID;
		this.description = description;
	}
	
	public String toString() {
		return this.concept_A_id+"->"+this.concept_B_id+":'"+this.description+"'";
	}
	
}
