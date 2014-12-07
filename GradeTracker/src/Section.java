import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class Section {
    
    public String name;
    public double weight;
    public ArrayList<Item> items;
    public Element element;
    
    private double earndPoints;
    private double totalPoints;
    
    private int dropLowest;
        
    public Section(String name, double weight) {
	this.name = name;
	this.weight = weight;
	items = new ArrayList<Item>();
	updatePoints();
    }
    
    public void addItem(Item ass) {
	items.add(ass);
	updatePoints();
    }
    
    public double getWeightedGrade() {
	return getGrade() * weight;
    }
    
    public double getGrade() {
	Node[] grades = new Node[items.size()];
	for(int i = 0; i < grades.length; i++)
	    grades[i] = new Node(items.get(i).earndPoints, items.get(i).totalPoints);
	
	Arrays.sort(grades, Collections.reverseOrder());
	
	double earnd = 0;
	for(int i = 0; i < grades.length - dropLowest; i++)
	    earnd += grades[i].earnd;
	return earnd / getTotalPoints();
    }
    
    public double getTotalPoints() {
	Node[] grades = new Node[items.size()];
	for(int i = 0; i < grades.length; i++)
	    grades[i] = new Node(items.get(i).earndPoints, items.get(i).totalPoints);
	
	Arrays.sort(grades, Collections.reverseOrder());
	
	double total = 0;
	for(int i = 0; i < grades.length - dropLowest; i++)
	    total += grades[i].total;
	
	return total;
    }
    
    public double getWeightedGradeExcluding(int item) {
	Item temp = items.remove(item);
	boolean dropped = false;
	if(dropLowest != 0) {
	    dropLowest--;
	    dropped = true;
	}
	double ret = getWeightedGrade();
	if(dropped)
	    dropLowest++;
	items.add(item, temp);
	return ret;
    }
    
    public void dropLowest(int n) {
	dropLowest = n;
    }
    
    public void updatePoints() {
	earndPoints = totalPoints = 0;
	for(int i = 0; i < items.size(); i++) {
	    earndPoints += items.get(i).earndPoints;
	    totalPoints += items.get(i).totalPoints;
	}
	element = new Element(Element.TYPE_SECTION, name, totalPoints, earndPoints);
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
