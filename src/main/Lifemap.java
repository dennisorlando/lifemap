package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Lifemap {
	
	private HashMap<Integer,Concept> concepts;
	private ArrayList<Node> nodes;
	
	public Lifemap(String path) {
		
		this.concepts = new HashMap<Integer,Concept>();
		this.nodes = new ArrayList<Node>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			
			while ((line = br.readLine()) != null) {
				if(line.equals("Concept:")) {
					int id = Integer.parseInt(br.readLine().substring(2));
					String name = br.readLine().substring(2);
					int x = Integer.parseInt(br.readLine().substring(2));
					int y= Integer.parseInt(br.readLine().substring(2));
					Concept c = new Concept(x,y,name,id);
					concepts.put(c.id, c);
				}
				if(line.equals("Node:")) {
					String description = br.readLine().substring(2);
					int idA = Integer.parseInt(br.readLine().substring(2));
					int idB = Integer.parseInt(br.readLine().substring(2));
					Node n = new Node(idA,idB,description);
					nodes.add(n);
				}
			}
			br.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void writeToFile(String path) {
		//write all concepts and nodes to a file. 
	}
	
	public void addConcept(Concept concept) {
		concepts.put(concept.id, concept);
	}
	public void addNode(Node node) {
		nodes.add(node);
	}
	public HashMap<Integer,Concept> getConcepts(){
		return this.concepts;
	}
	public ArrayList<Node> getNodes(){
		return this.nodes;
	}
	
}
