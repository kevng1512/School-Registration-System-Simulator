//Name: Nguyen, Vu Kha - 500977615
public class CreditCourse extends Course {
	// add a constructor method with appropriate parameters
	// should call the super class constructor

	private String semester, name, descr, fmt;
	public double grade;
	public boolean active;

	public CreditCourse(String name, String code, String descr, String fmt, String semester, double grade) {
		// add code
		super(name, code, descr, fmt);
		this.semester = semester;
		this.grade = grade;
	}

	public boolean getActive() {
		return active;
	}

	public void setActive() {
		this.active = true;
	}

	public void setInactive() {
		this.active = false;
	}

	public String getSemester() {
		return semester;
	}
	/*
		public String getCoure() {
			return name;
		}
	*/

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public String displayGrade() {
		// Change line below and print out info about this course plus which semester and the grade achieved
		// make use of inherited method in super class
		//CHECK Student.java print transcript method
		return super.convertNumericGrade(grade);
	}

}