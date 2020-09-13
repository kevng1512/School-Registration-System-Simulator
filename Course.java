//Name: Nguyen, Vu Kha - 500977615
public class Course {
	private String code;
	private String name;
	private String description;
	private String format;

	public Course() {
		this.code = "";
		this.name = "";
		this.description = "";
		this.format = "";
	}

	public Course(String name, String code, String descr, String fmt) {
		this.code = code;
		this.name = name;
		this.description = descr;
		this.format = fmt;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getFormat() {
		return format;
	}

	public String getDescription() {
		return code + " - " + name + "\n" + description + "\n" + format;
	}

	public String getInfo() {
		return code + " - " + name;
	}

	// static method to convert numeric score to letter grade string 
	// e.g. 91 --> "A+"
	public static String convertNumericGrade(double score) {
		if (score >= 97 && score <= 100) {
			return "A+";
		} else if (score >= 93 && score <= 96) {
			return "A";
		} else if (score >= 90 && score <= 92) {
			return "A-";
		} else if (score >= 87 && score <= 89) {
			return "B+";
		} else if (score >= 83 && score <= 86) {
			return "B";
		} else if (score >= 80 && score <= 82) {
			return "B-";
		} else if (score >= 77 && score <= 79) {
			return "C+";
		} else if (score >= 73 && score <= 76) {
			return "C";
		} else if (score >= 70 && score <= 72) {
			return "C-";
		} else if (score >= 67 && score <= 69) {
			return "D+";
		} else if (score >= 65 && score <= 66) {
			return "D";
		} else if (score >= 61 && score <= 64) {
			return "D-";
		}
		return "F";
	}

}