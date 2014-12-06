import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class Section {
    
    public String name;
    public double weight;
    public ArrayList<Item> items;
    
    private int dropLowest;
        
    public Section(String name, double weight) {
	this.name = name;
	this.weight = weight;
	items = new ArrayList<Item>();
    }
    
    public void addItem(Item ass) {
	items.add(ass);
    }
    
    public double getGrade() {
	Node[] grades = new Node[items.size()];
	for(int i = 0; i < grades.length; i++)
	    grades[i] = new Node(items.get(i).earndPoints, items.get(i).totalPoints);
	
	Arrays.sort(grades, Collections.reverseOrder());
	
	double earnd = 0;
	double total = 0;
	for(int i = 0; i < grades.length - dropLowest; i++) {
	    earnd += grades[i].earnd;
	    total += grades[i].total;
	}
	return earnd / total;
    }
    
    public double getWeightedGrade() {
	return getGrade() * weight;
    }
    
    public void dropLowest(int n) {
	dropLowest = n;
    }
    
    private class Node implements Comparable<Node> {
	public double grade;
	public double earnd;
	public double total;
	
	public Node(double earnd, double total) {
	    grade = earnd / total;
	    this.earnd = earnd;
	    this.total = total;
	}
	
	public int compareTo(Node node) {
	    if(grade > node.grade)
		return 1;
	    if(grade == node.grade)
		return 0;
	    return -1;
	}
    }

}
