import java.util.ArrayList;


public class Driver {
    
    private ArrayList<Course> courses;
    
    public Driver() {
	courses = new ArrayList<Course>();
	
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
	courses.get(0).sections.get(0).addItem(new Item("Assignment8", 30));
	courses.get(0).sections.get(0).dropLowest(1);
	
	courses.get(0).sections.get(1).addItem(new Item("Exam1", 100, 84));
	courses.get(0).sections.get(1).addItem(new Item("Exam2", 100, 95));
	courses.get(0).sections.get(1).addItem(new Item("Exam3", 100, 95));
	courses.get(0).sections.get(1).addItem(new Item("Final", 100, 0));
	courses.get(0).sections.get(1).dropLowest(1);

	courses.get(0).sections.get(2).addItem(new Item("Quiz1", 10, 10));
	courses.get(0).sections.get(2).addItem(new Item("Quiz2", 10, 8.5));
	courses.get(0).sections.get(2).addItem(new Item("Quiz3", 10, 10));
	courses.get(0).sections.get(2).addItem(new Item("Quiz4", 10));
	courses.get(0).sections.get(2).addItem(new Item("Quiz5", 10));
	courses.get(0).sections.get(2).addItem(new Item("Quiz6", 10));
	courses.get(0).sections.get(2).addItem(new Item("Quiz7", 10, 8));
	courses.get(0).sections.get(2).addItem(new Item("Quiz8", 10));
	courses.get(0).sections.get(2).addItem(new Item("Quiz9", 10, 10));
	courses.get(0).sections.get(2).addItem(new Item("Quiz10", 10, 10));
	courses.get(0).sections.get(2).addItem(new Item("Quiz11", 10));
	courses.get(0).sections.get(2).addItem(new Item("Quiz12", 10));
	courses.get(0).sections.get(2).addItem(new Item("Quiz13", 10));
	courses.get(0).sections.get(2).addItem(new Item("Quiz14", 10));
	courses.get(0).sections.get(2).addItem(new Item("Quiz15", 10));

	System.out.println(courses.get(0).getGrade());
    }

}
