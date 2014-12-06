
public class Item {
    
    public String name;
    public double totalPoints;
    public double earndPoints;
    public boolean incomplete;
    
    public Item(String name) {
	this(name, 0);
    }
    
    public Item(String name, double totalPoints) {
	this(name, totalPoints, 0);
	incomplete = true;
    }
    
    public Item(String name, double totalPoints, double earndPoints) {
	this.name = name;
	this.totalPoints = totalPoints;
	this.earndPoints = earndPoints;
	incomplete = false;
    }

}
