package project1.data;

import java.text.DecimalFormat;

public final class Student implements Comparable<Student> {
    private final String name;
    private final double gpa;

    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public int compareTo(Student student) {
        return Double.compare(gpa, student.gpa);
    }

    @Override
    public String toString() {
        String visualGpa = new DecimalFormat("#.###").format(gpa);
        if (!visualGpa.contains(".")) {
            visualGpa += ".0";
        }
        return "Student{" +
                "name='" + name + '\'' +
                ", gpa=" + visualGpa +
                '}';
    }
}
