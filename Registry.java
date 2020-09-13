//Name: Nguyen, Vu Kha - 500977615
import java.util.ArrayList;
import java.util.Collections;

public class Registry {
	private ArrayList < Student > students = new ArrayList < Student > ();
	private ArrayList < ActiveCourse > courses = new ArrayList < ActiveCourse > ();

	public Registry() {
		// Add some students
		// in A2 we will read from a file
		Student s1 = new Student("JohnOliver", "34562");
		Student s2 = new Student("HarryWindsor", "38467");
		Student s3 = new Student("SophieBrown", "98345");
		Student s4 = new Student("FaisalQuereshi", "57643");
		Student s5 = new Student("GenghisKhan", "25347");
		Student s6 = new Student("SherryTu", "46532");
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		students.add(s5);
		students.add(s6);
		Collections.sort(students);
		// sort the students alphabetically - see class Student

		ArrayList < Student > list = new ArrayList < Student > ();

		// Add some active courses with students
		String courseName = "Computer Science II";
		String courseCode = "CPS209";
		String descr = "Learn how to write complex programs!";
		String format = "3Lec 2Lab";
		list.add(s2);
		list.add(s3);
		list.add(s4);
		courses.add(new ActiveCourse(courseName, courseCode, descr, format, "W2020", list));
		// Add course to student list of courses
		s2.addCourse(courseName, courseCode, descr, format, "W2020", 0);
		s3.addCourse(courseName, courseCode, descr, format, "W2020", 0);
		s4.addCourse(courseName, courseCode, descr, format, "W2020", 0);

		// CPS511
		list.clear();
		courseName = "Computer Graphics";
		courseCode = "CPS511";
		descr = "Learn how to write cool graphics programs";
		format = "3Lec";
		list.add(s1);
		list.add(s5);
		list.add(s6);
		courses.add(new ActiveCourse(courseName, courseCode, descr, format, "F2020", list));
		s1.addCourse(courseName, courseCode, descr, format, "W2020", 0);
		s5.addCourse(courseName, courseCode, descr, format, "W2020", 0);
		s6.addCourse(courseName, courseCode, descr, format, "W2020", 0);

		// CPS643
		list.clear();
		courseName = "Virtual Reality";
		courseCode = "CPS643";
		descr = "Learn how to write extremely cool virtual reality programs";
		format = "3Lec 2Lab";
		list.add(s1);
		list.add(s2);
		list.add(s4);
		list.add(s6);
		courses.add(new ActiveCourse(courseName, courseCode, descr, format, "W2020", list));
		s1.addCourse(courseName, courseCode, descr, format, "W2020", 0);
		s2.addCourse(courseName, courseCode, descr, format, "W2020", 0);
		s4.addCourse(courseName, courseCode, descr, format, "W2020", 0);
		s6.addCourse(courseName, courseCode, descr, format, "W2020", 0);

	}

	// Add new student to the registry (students arraylist above) 
	public boolean addNewStudent(String name, String id) {
		// Create a new student object
		// check to ensure student is not already in registry
		// if not, add them and return true, otherwise return false
		// make use of equals method in class Student
		Student student = new Student(name, id);
		Student tempCheck;

		for (int i = 0; i < students.size(); i++) {
			tempCheck = students.get(i);
			if (student.equals(tempCheck)) {
				return false;
			}
		}
		students.add(student);
		return false;
	}

	// Remove student from registry 
	public boolean removeStudent(String studentId) {
		// Find student in students arraylist
		// If found, remove this student and return true
		Student remove, tempCheck;
		ActiveCourse aCourse;
		ArrayList < Student > student;

		for (int i = 0; i < students.size(); i++) {
			remove = students.get(i);
			if ((remove.getId()).equals(studentId)) {
				students.remove(remove);
				for (int j = 0; j < courses.size(); j++) {
					aCourse = courses.get(key);
					student = aCourse.getCurrentStudent();
					for (int k = 0; k < student.size(); k++) {
						tempCheck = student.get(k);
						if (tempCheck.getId().equals(studentId)) {
							student.remove(tempCheck);
						}
					}
				}
				return true;
			}
		}
		return false;
	}

	// Print all registered students
	public void printAllStudents() {
		for (int i = 0; i < students.size(); i++) {
			System.out.println("ID: " + students.get(i).getId() + " Name: " + students.get(i).getName());
		}

	}

	// Given a studentId and a course code, add student to the active course
	public void addCourse(String studentId, String courseCode) {
		// Find student object in registry (i.e. students arraylist)
		// Check if student has already taken this course in the past Hint: look at their credit course list
		// If not, then find the active course in courses array list using course code
		// If active course found then check to see if student already enrolled in this course
		// If not already enrolled
		//   add student to the active course
		//   add course to student list of credit courses with initial grade of 0
		Student student;
		ArrayList < Student > studentArray;
		CreditCourse checkCredit;
		ArrayList < CreditCourse > pastCourse;
		ActiveCourse activeCourse;

		for (int i = 0; i < students.size(); i++) {
			student = students.get(i);
			//System.out.println("This Case1");
			if (student.getId().equalsIgnoreCase(studentId) == true) {
				pastCourse = student.getActiveCourses();
				//System.out.println("This Case2");
				for (int j = 0; j < pastCourse.size(); j++) {
					checkCredit = pastCourse.get(j);
					//System.out.println("This Case3");
					if (checkCredit.getCode().equalsIgnoreCase(courseCode) && checkCredit.getActive() == true) {
						System.out.println("Student already enrolled for this course.");
						break;
					} else if (checkCredit.getCode().equals(courseCode) && checkCredit.getActive() == false) {
						System.out.println("Student already finished this course ");
						break;
					}
				}
				for (int k = 0; k < courses.size(); k++) {
					//System.out.println("This Case5");
					activeCourse = courses.get(k);
					if (activeCourse.getCode().equalsIgnoreCase(courseCode)) {
						studentArray = activeCourse.getCurrentStudent();
						studentArray.add(student);
						student.addCourse(activeCourse.getName(), activeCourse.getCode(), activeCourse.getDescription(), activeCourse.getFormat(), activeCourse.getSemester(), 0);
					}
				}
			}
		}
	}

	// Given a studentId and a course code, drop student from the active course
	public void dropCourse(String studentId, String courseCode) {
		// Find the active course
		// Find the student in the list of students for this course
		// If student found:
		//   remove the student from the active course
		//   remove the credit course from the student's list of credit courses
		ActiveCourse drop;
		Student dropStudent;
		ArrayList < Student > studentList;

		for (int i = 0; i < courses.size(); i++) {
			drop = courses.get(i);
			if (drop.getCode().equalsIgnoreCase(courseCode)) {
				studentList = drop.getCurrentStudent();
				for (int j = 0; j < studentList.size(); j++) {
					dropStudent = studentList.get(j);
					if (dropStudent.getId().equals(studentId)) {
						studentList.remove(dropStudent);
						dropStudent.removeActiveCourse(courseCode);
					}
				}
			}
		}
	}

	// Print all active courses
	public void printActiveCourses() {
		for (int i = 0; i < courses.size(); i++) {
			ActiveCourse ac = courses.get(i);
			System.out.println(ac.getDescription());
		}
	}

	// Print the list of students in an active course
	public void printClassList(String courseCode) {
		ActiveCourse course;
		Student student;
		ArrayList < Student > studentList;

		for (int i = 0; i < courses.size(); i++) {
			course = courses.get(i);
			if (course.getCode().equalsIgnoreCase(courseCode)) {
				studentList = course.getCurrentStudent();
				for (int j = 0; j < studentList.size(); j++) {
					student = studentList.get(j);
					System.out.println(student);
				}
			}
		}
	}

	// Given a course code, find course and sort class list by student name
	public void sortCourseByName(String courseCode) {
		ActiveCourse temp;

		for (int i = 0; i < courses.size(); i++) {
			temp = courses.get(i);
			if (temp.getCode().equalsIgnoreCase(courseCode)) {
				temp.sortByName();;
			}
		}
	}

	// Given a course code, find course and sort class list by student name
	public void sortCourseById(String courseCode) {
		ActiveCourse temp;

		for (int i = 0; i < courses.size(); i++) {
			temp = courses.get(i);
			if (temp.getCode().equalsIgnoreCase(courseCode)) {
				temp.sortById();;
			}
		}
	}

	// Given a course code, find course and print student names and grades
	public void printGrades(String courseCode) {
		ActiveCourse course;
		//Student student;

		for (int i = 0; i < courses.size(); i++) {
			course = courses.get(i);
			if (course.getCode().equalsIgnoreCase(courseCode)) {
				course.printGrades();
			}
		}
	}

	// Given a studentId, print all active courses of student
	public void printStudentCourses(String studentId) throws Exception {
		Student student;
		CreditCourse credit;
		ArrayList < CreditCourse > creditList;
		boolean check = false;

		for (int i = 0; i < students.size(); i++) {
			student = students.get(i);
			if (student.getId().equals(studentId)) {
				creditList = student.getActiveCourses();
				check = true;
				for (int j = 0; j < creditList.size(); j++) {
					credit = creditList.get(j);
					if (credit.getActive() == true) {
						System.out.println(credit.getDescription());
					}
				}
			}
		}

		if (check == false)
			throw new Exception("Please check the student id again");
	}

	// Given a studentId, print all completed courses and grades of student
	public void printStudentTranscript(String studentId) throws Exception {
		Student student;
		ArrayList < CreditCourse > creditList;
		CreditCourse credit;
		boolean check = false;

		for (int i = 0; i < students.size(); i++) {
			student = students.get(i);
			if (student.getId().equals(studentId)) {
				creditList = student.getActiveCourses();
				check = true;
				for (int j = 0; j < creditList.size(); j++) {
					credit = creditList.get(j);
					if (credit.getActive() == false) {
						System.out.println(credit.getCode() + " " + credit.getName() + " " + credit.getSemester() + credit.displayGrade());
					}
				}
			}
		}

		if (check == false)
			throw new Exception("Please check the student id again");
	}
	// Given a course code, student id and numeric grade
	// set the final grade of the student
	public void setFinalGrade(String courseCode, String studentId, double grade) {
		// find the active course
		// If found, find the student in class list
		// then search student credit course list in student object and find course
		// set the grade in credit course and set credit course inactive
		ActiveCourse activeCourse;
		ArrayList < Student > studentList;
		Student student;
		ArrayList < CreditCourse > creditList;
		CreditCourse credit;

		for (int i = 0; i < courses.size(); i++) {
			activeCourse = courses.get(i);
			if (activeCourse.getCode().equalsIgnoreCase(courseCode)) {
				studentList = activeCourse.getCurrentStudent();
				for (int j = 0; j < studentList.size(); j++) {
					student = studentList.get(j);
					if (student.getId().equals(studentId)) {
						creditList = student.getActiveCourses();
						for (int k = 0; k < creditList.size(); k++) {
							credit = creditList.get(k);
							if (credit.getCode().equalsIgnoreCase(courseCode)) {
								credit.setInactive();;
								credit.setGrade(grade);
							}
						}
					}
				}
			}
		}
	}
}