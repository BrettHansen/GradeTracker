import java.util.ArrayList;


public class Course {
    
    public String name;
    public ArrayList<Section> sections;
    
    public Course(String name) {
	this.name = name;
	sections = new ArrayList<Section>();
    }
    
    public void addSection(Section sect) {
	sections.add(sect);
    }
    
    public double getGrade() {
	double grade = 0;
	for(int s = 0; s < sections.size(); s++) {
	    grade += sections.get(s).getWeightedGrade();
	}
	return grade * 100;
    }
    
    public double getNecessaryGrade(int sect, int item, double want) {
	double grade = 0;
	for(int s = 0; s < sections.size(); s++) {
	    if(s != sect)
		grade += sections.get(s).getWeightedGrade();
	}
	grade += sections.get(sect).getWeightedGradeExcluding(item);
	return (want - grade) / (sections.get(sect).items.get(item).totalPoints / sections.get(sect).getTotalPoints() * sections.get(sect).weight);
    }
}
