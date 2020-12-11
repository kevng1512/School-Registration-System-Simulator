import java.util.ArrayList;

// Make class Student implement the Comparable interface
// Two student objects should be compared by their name
public class Student implements Comparable < Student > {
  private String name;
  private String id;
  public ArrayList < CreditCourse > courses;


  public Student(String name, String id) {
    this.name = name;
    this.id = id;
    courses = new ArrayList < CreditCourse > ();
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  // add a credit course to list of courses for this student
  public void addCourse(String courseName, String courseCode, String descr, String format, String sem, double grade) {
    CreditCourse credit = new CreditCourse(courseName, courseCode, descr, format, sem, grade);
    credit.setActive();
    courses.add(credit);
  }

  // Prints a student transcript
  // Prints all completed (i.e. non active) courses for this student (course code, course name, 
  // semester, letter grade
  // see class CreditCourse for useful methods
  public void printTranscript() {
    CreditCourse active;

    for (int i = 0; i < courses.size(); i++) {
      active = courses.get(i);
      if (active.getActive() == false) {
        System.out.println(active.getCode() + " " + active.getName() + " " + active.getSemester() + active.displayGrade());
      }
    }
  }

  // Prints all active courses this student is enrolled in
  // see variable active in class CreditCourse
  public void printActiveCourses() {
    CreditCourse active;

    for (int i = 0; i < courses.size(); i++) {
      active = courses.get(i);
      if (active.getActive() == true) {
        System.out.println(active);
      }
    }
  }

  public ArrayList < CreditCourse > getActiveCourses() {
    return courses;
  }

  // Drop a course (given by courseCode)
  // Find the credit course in courses arraylist above and remove it
  // only remove it if it is an active course
  public void removeActiveCourse(String courseCode) {
    CreditCourse active;

    for (int i = 0; i < courses.size(); i++) {
      active = courses.get(i);
      if (active.getCode().equalsIgnoreCase(courseCode) && active.getActive() == true) {
        courses.remove(i);
      }
    }
  }

  public String toString() {
    return "Student ID: " + id + " Name: " + name;
  }

  // override equals method inherited from superclass Object
  // if student names are equal *and* student ids are equal (of "this" student
  // and "other" student) then return true
  // otherwise return false
  // Hint: you will need to cast other parameter to a local Student reference variable
  public boolean equals(Object other) {
    Student otherObject = (Student) other;

    if (this.id.equals(otherObject.id)) {
      return true;
    }
    return false;
  }

  public int compareTo(Student o) {
    return name.compareTo(o.name);
  }

}
