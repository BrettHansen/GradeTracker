
public class Item {
    
    public String name;
    public double totalPoints;
    public double earndPoints;
    public boolean incomplete = false;
    public Element element;
    
    public Item(String name) {
	this(name, 0);
	
	element = new Element(Element.TYPE_ITEM, name);
    }
    
    public Item(String name, double totalPoints) {
	this(name, totalPoints, 0);
	incomplete = true;
	
	element = new Element(Element.TYPE_ITEM, name, totalPoints);
    }
    
    public Item(String name, double totalPoints, double earndPoints) {
	this.name = name;
	this.totalPoints = totalPoints;
	this.earndPoints = earndPoints;
	incomplete = false;
	
	element = new Element(Element.TYPE_ITEM, name, totalPoints, earndPoints);
    }

}
