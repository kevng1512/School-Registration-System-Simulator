//Name: Nguyen, Vu Kha - 500977615
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Active University Course

public class ActiveCourse extends Course {
   private ArrayList < Student > students;
   private String semester;


   // Add a constructor method with appropriate parameters
   // should call super class constructor to initialize inherited variables
   // make sure to *copy* students array list being passed in into new arraylist of students
   // see class Registry to see how an ActiveCourse object is created and used
   public ActiveCourse(String name, String code, String descr, String fmt, String semester, ArrayList < Student > students) {
      super(name, code, descr, fmt);
      Student temp;
      ArrayList < Student > activeCourseStudent = new ArrayList < Student > ();
      
      for (int i = 0; i < students.size(); i ++) {
         temp = students.get(i);
         activeCourseStudent.add(temp);
      }

      this.students = activeCourseStudent;
      this.semester = semester;
   }

   public String getSemester() {
      return semester;
   }

   // Prints the students in this course  (name and student id)
   public void printClassList() {
      System.out.println(students);
   }

   // Prints the grade of each student in this course (along with name and student id)
   // 
   public void printGrades() {
      Student temp;

      for (int i = 0; i < students.size(); i++) {
         temp = students.get(i);
         System.out.println(temp.getId() + " " + temp.getName() + " " + getGrade(temp.getId()));
      }
   }

   // Returns the numeric grade in this course for this student
   // If student not found in course, return 0 
   public double getGrade(String studentId) {
      // Search the student's list of credit courses to find the course code that matches this active course
      // see class Student method getGrade() 
      // return the grade stored in the credit course object
      ArrayList <CreditCourse> course;
      CreditCourse courseCredit;
      Student temp;

      for (int i = 0; i < students.size(); i++) {
         temp = students.get(i);
         if (temp.getId().equals(studentId)) {
            course = temp.getActiveCourses();
            for (int j = 0; j < course.size(); j++) {
               courseCredit = course.get(j);
               if (courseCredit.getCode().equals(this.getCode())) {
                  return courseCredit.grade;
               }
            }
         }
      }
      return 0;
   }

   public ArrayList<Student> getCurrentStudent() {
      return students;
   }

   // Returns a String containing the course information as well as the semester and the number of students 
   // enrolled in the course
   // must override method in the superclass Course and use super class method getDescription()
   public String getDescription() {
      return super.getDescription() + " " + this.semester + "Enrollment: " + students.size() + "\n";
   }

   // Sort the students in the course by name using the Collections.sort() method with appropriate arguments
   // Make use of a private Comparator class below
   public void sortByName() {
      Collections.sort(students, new NameComparator());
   }

   // Fill in the class so that this class implement the Comparator interface
   // This class is used to compare two Student objects based on student name
   private class NameComparator implements Comparator <Student> {
      public int compare(Student a, Student b) {
         return a.getName().compareTo(b.getName());
      }
   }

   // Sort the students in the course by student id using the Collections.sort() method with appropriate arguments
   // Make use of a private Comparator class below
   public void sortById() {
      Collections.sort(students, new IdComparator());
   }

   // Fill in the class so that this class implement the Comparator interface
   // This class is used to compare two Student objects based on student id
   private class IdComparator implements Comparator <Student> {
      public int compare (Student a, Student b) {
         return a.getId().compareTo(b.getId());
      }
   }
}