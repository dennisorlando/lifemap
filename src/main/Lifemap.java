package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Lifemap {
	
	private HashMap<Integer,Concept> concepts;
	private ArrayList<Node> nodes;
	private String path;
	
	public Lifemap(String path) {
		
		this.path = path;
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
	
	public void save() {
		try {
			BufferedWriter bf = new BufferedWriter(new FileWriter(path));
			for (Concept c : concepts.values()) {
				bf.write("\nConcept:\n  "+c.id+"\n  "+c.name+"\n  "+c.left_x+"\n  "+c.top_y);
			}
			for (Node n : nodes) {
				bf.write("\nNode:\n  "+n.description+"\n  "+n.concept_A_id+"\n  "+n.concept_B_id);
			}
			bf.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void createConcept(Concept concept) {
		concept.id = generateID();
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
	private int generateID() {
		Random r = new Random();
		while(true) {
			int i = r.nextInt();
			for (int id : concepts.keySet()) {
				if(i == id) {
					continue;
				}
			}
			System.out.println(i);
			return i;
		}
	}
	
}
