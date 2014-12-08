import java.util.ArrayList;


public class Driver {
    
    private ArrayList<Course> courses;
    
    public Driver() {
	courses = new ArrayList<Course>();
	new GUI(courses);
	
	courses.add(new Course("CSE 310"));
	courses.get(0).addSection(new Section("Homework", .4));
	courses.get(0).addSection(new Section("Tests", .6));
	courses.get(0).addSection(new Section("Extra Credit", .05));
	
	courses.get(0).sections.get(0).addItem(new Item("Assignment1", 30, 29));
	courses.get(0).sections.get(0).addItem(new Item("Assignment2", 30, 0));
	courses.get(0).sections.get(0).addItem(new Item("Assignment3", 30, 28));
	courses.get(0).sections.get(0).addItem(new Item("Assignment4", 30, 19));
	courses.get(0).sections.get(0).addItem(new Item("Assignment5", 30, 30));
	courses.get(0).sections.get(0).addItem(new Item("Assignment6", 30, 30));
	courses.get(0).sections.get(0).addItem(new Item("Assignment7", 30, 28));
	courses.get(0).sections.get(0).addItem(new Item("Assignment8", 30, 30));
	courses.get(0).sections.get(0).dropLowest(1);
	
	courses.get(0).sections.get(1).addItem(new Item("Exam1", 100, 84));
	courses.get(0).sections.get(1).addItem(new Item("Exam2", 100, 95));
	courses.get(0).sections.get(1).addItem(new Item("Exam3", 100, 95));
	courses.get(0).sections.get(1).addItem(new Item("Final", 100, 0));
	courses.get(0).sections.get(1).dropLowest(1);

	courses.get(0).sections.get(2).addItem(new Item("Quiz1", 10, 10));
	courses.get(0).sections.get(2).addItem(new Item("Quiz2", 10, 8.5));
	courses.get(0).sections.get(2).addItem(new Item("Quiz3", 10, 10));
	courses.get(0).sections.get(2).addItem(new Item("Quiz4", 10, 0));
	courses.get(0).sections.get(2).addItem(new Item("Quiz5", 10, 0));
	courses.get(0).sections.get(2).addItem(new Item("Quiz6", 10, 0));
	courses.get(0).sections.get(2).addItem(new Item("Quiz7", 10, 8));
	courses.get(0).sections.get(2).addItem(new Item("Quiz8", 10, 0));
	courses.get(0).sections.get(2).addItem(new Item("Quiz9", 10, 10));
	courses.get(0).sections.get(2).addItem(new Item("Quiz10", 10, 10));
	courses.get(0).sections.get(2).addItem(new Item("Quiz11", 10, 0));
	courses.get(0).sections.get(2).addItem(new Item("Quiz12", 10, 0));
	courses.get(0).sections.get(2).addItem(new Item("Quiz13", 10, 0));
	courses.get(0).sections.get(2).addItem(new Item("Quiz14", 10, 0));
	courses.get(0).sections.get(2).addItem(new Item("Quiz15", 10, 0));
	
	courses.add(new Course("MAT 343"));
	courses.get(1).addSection(new Section("WeBWorK", .2));
	courses.get(1).addSection(new Section("MATLAB", .1));
	courses.get(1).addSection(new Section("Test", .7));
	
	courses.get(1).sections.get(0).addItem(new Item("1.1 & 1.2", 10, 10));
	courses.get(1).sections.get(0).addItem(new Item("1.3 & 1.4", 10, 10));
	courses.get(1).sections.get(0).addItem(new Item("1.5 & 2.1", 10, 10));
	courses.get(1).sections.get(0).addItem(new Item("2.2", 5, 5));
	courses.get(1).sections.get(0).addItem(new Item("3.1", 5, 5));
	courses.get(1).sections.get(0).addItem(new Item("3.2 & 3.3", 10, 10));
	courses.get(1).sections.get(0).addItem(new Item("3.4 & 3.5", 10, 10));
	courses.get(1).sections.get(0).addItem(new Item("3.6 & 4.1", 10, 10));
	courses.get(1).sections.get(0).addItem(new Item("4.2", 5, 5));
	courses.get(1).sections.get(0).addItem(new Item("5.1 & 5.2", 10, 10));
	courses.get(1).sections.get(0).addItem(new Item("5.3 & 5.4", 10, 10));
	courses.get(1).sections.get(0).addItem(new Item("5.5 & 5.6", 10, 8.8));
	courses.get(1).sections.get(0).addItem(new Item("6.1", 5, 5));
	courses.get(1).sections.get(0).addItem(new Item("6.3 & 6.5", 10, 10));

	courses.get(1).sections.get(1).addItem(new Item("MATLAB Lab 1", 12, 12));
	courses.get(1).sections.get(1).addItem(new Item("MATLAB Lab 2", 12, 12));
	courses.get(1).sections.get(1).addItem(new Item("MATLAB Lab 3", 12, 12));
	courses.get(1).sections.get(1).addItem(new Item("MATLAB Lab 4", 12, 12));
	courses.get(1).sections.get(1).addItem(new Item("MATLAB Lab 5", 12, 12));
	courses.get(1).sections.get(1).addItem(new Item("MATLAB Lab 6", 12, 0));
	courses.get(1).sections.get(1).dropLowest(1);

	courses.get(1).sections.get(2).addItem(new Item("Test 1", 60, 59.4));
	courses.get(1).sections.get(2).addItem(new Item("Test 2", 150, 118));
	courses.get(1).sections.get(2).addItem(new Item("Test 3", 60, 60));
	courses.get(1).sections.get(2).addItem(new Item("Final", 150, 128.6));
	
	Course cTemp;
	for(int c = 0; c < courses.size(); c++) {
	    cTemp = courses.get(c);
	    cTemp.updatePoints();
	    for(int s = 0; s < cTemp.sections.size(); s++)
		cTemp.sections.get(s).updatePoints();
	}
    }

}
