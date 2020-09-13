//Name: Nguyen, Vu Kha - 500977615
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StudentRegistrySimulator {
	public static void main(String[] args) throws Exception {
		Registry registry = new Registry();

		Scanner scanner = new Scanner(System.in);
		System.out.print(">");

		while (scanner.hasNextLine()) {
			String inputLine = scanner.nextLine();
			if (inputLine == null || inputLine.equals("")) continue;

			Scanner commandLine = new Scanner(inputLine);
			String command = commandLine.next();

			if (command == null || command.equals("")) continue;

			else if (command.equalsIgnoreCase("L") || command.equalsIgnoreCase("LIST")) {
				registry.printAllStudents();
			} else if (command.equalsIgnoreCase("Q") || command.equalsIgnoreCase("QUIT"))
				System.exit(0);

			else if (command.equalsIgnoreCase("REG")) {
				// register a new student in registry
				// get name and student id string 
				// e.g. reg JohnBoy 74345
				// Checks:
				//  ensure name is all alphabetic characters
				//  ensure id string is all numeric characters
				String name, id;

				try {
					name = commandLine.next();
					id = commandLine.next();

					if (isStringOnlyAlphabet(name) == false)
						System.out.println("Name should be String only.");
					else if (isNumeric(id) == false)
						System.out.println("ID should be digits only.");
					else if (name == "" || id == "")
						System.out.println("Name/ID field was leave blanked");
					else
						registry.addNewStudent(name, id);
				} catch (NoSuchElementException f) {
					System.out.println("Please check the input filed for name/ID.");
				}

			} else if (command.equalsIgnoreCase("DEL")) {
				// delete a student from registry
				// get student id
				// ensure numeric
				// remove student from registry
				String id;

				try {
					id = commandLine.next();
					if (isNumeric(id) == false)
						System.out.println("ID should be digits only.");
					else
						registry.removeStudent(id);
				} catch (NoSuchElementException f) {
					System.out.println("The ID field was leave blanked");
				}

			} else if (command.equalsIgnoreCase("ADDC")) {
				// add a student to an active course
				// get student id and course code strings
				// add student to course (see class Registry)
				String id, code;

				try {
					id = commandLine.next();
					code = commandLine.next();

					if (isNumeric(id) == false)
						System.out.println("ID should be digits only.");
					else {
						registry.addCourse(id, code);
						//System.out.println("Add student succeed");
					}
				} catch (NoSuchElementException f) {
					System.out.println("The ID/code field was leave blanked");
				}

			} else if (command.equalsIgnoreCase("DROPC")) {
				// get student id and course code strings
				// drop student from course (see class Registry)
				String id, code;

				try {
					id = commandLine.next();
					code = commandLine.next();

					if (isNumeric(id) == false)
						System.out.println("ID should be digits only.");
					else
						registry.dropCourse(id, code);
				} catch (NoSuchElementException f) {
					System.out.println("The ID/code field was leave blanked");
				}

			} else if (command.equalsIgnoreCase("PAC")) {
				// print all active courses
				registry.printActiveCourses();

			} else if (command.equalsIgnoreCase("PCL")) {
				// get course code string
				// print class list (i.e. students) for this course
				String code;

				try {
					code = commandLine.next();
				} catch (NoSuchElementException f) {
					System.out.println("The course code field was leave blanked.");
					continue;
				}

				try {
					registry.printClassList(code);
				} catch (Exception f) {
					System.out.println("Exception Error.");
					continue;
				}

			} else if (command.equalsIgnoreCase("PGR")) {
				// get course code string
				// print name, id and grade of all students in active course

				String code;

				try {
					code = commandLine.next();
				} catch (NoSuchElementException f) {
					System.out.println("The course code field was leave blanked.");
					continue;
				}

				try {
					registry.printGrades(code);
				} catch (Exception f) {
					System.out.println("Exception Error.");
					continue;
				}

			} else if (command.equalsIgnoreCase("PSC")) {
				// get student id string
				// print all credit courses of student
				String id;
				//boolean temp = true;

				try {
					id = commandLine.next();
					if (isNumeric(id) == false)
						System.out.println("ID should be digits only.");
					else
						registry.printStudentCourses(id);
				} catch (NoSuchElementException f) {
					//temp = false;
					System.out.println("The ID field was leave blanked");
				}

			} else if (command.equalsIgnoreCase("PST")) {
				// get student id string
				// print student transcript
				String id;
				//boolean checker = true;

				try {
					id = commandLine.next();
					if (isNumeric(id) == false)
						System.out.println("ID should be digits only.");
					else
						registry.printStudentTranscript(id);
				} catch (NoSuchElementException f) {
					//checker = false;
					System.out.println("The ID field was leave blanked");
				}

			} else if (command.equalsIgnoreCase("SFG")) {
				// set final grade of student
				// get course code, student id, numeric grade
				// use registry to set final grade of this student (see class Registry)
				String code, id;
				double grade;
				//boolean checker = true;

				try {
					code = commandLine.next();
					id = commandLine.next();
					grade = commandLine.nextDouble();
					if (isNumeric(id) == false)
						System.out.println("ID should be digits only.");
					else
						registry.setFinalGrade(code, id, grade);
				} catch (NoSuchElementException f) {
					System.out.println("The ID/code/grade field was leave blanked");
				}

			} else if (command.equalsIgnoreCase("SCN")) {
				// get course code
				// sort list of students in course by name (i.e. alphabetically)
				// see class Registry
				String code;

				try {
					code = commandLine.next();
					registry.sortCourseByName(code);
				} catch (NoSuchElementException f) {
					System.out.println("The course code field was leave blanked.");
				}

			} else if (command.equalsIgnoreCase("SCI")) {
				// get course code
				// sort list of students in course by student id
				// see class Registry
				String code;

				try {
					code = commandLine.next();
					registry.sortCourseById(code);
				} catch (NoSuchElementException f) {
					System.out.println("The course code field was leave blanked.");
				}
			}
			System.out.print("\n>");
		}
	}

	private static boolean isStringOnlyAlphabet(String str) {
		// write method to check if string str contains only alphabetic characters 

		char[] temp = str.toCharArray();

		for (char character: temp) {
			if (Character.isLetter(character) == false) {
				return false;
			}
		}
		return true;
	}


	public static boolean isNumeric(String str) {
		// write method to check if string str contains only numeric characters

		char[] temp = str.toCharArray();

		for (char character: temp) {
			if (Character.isDigit(character) == false) {
				return false;
			}
		}
		return true;
	}
}