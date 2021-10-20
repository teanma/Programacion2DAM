package org.iesfm.institutoscanner;

import java.util.List;
import java.util.Objects;

public class Group {

    private String letter;
    private int grade;
    private List<Student> students;

    public Group(String letter, int grade, List<Student> students) {
        this.letter = letter;
        this.grade = grade;
        this.students = students;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return grade == group.grade && Objects.equals(letter, group.letter) && Objects.equals(students, group.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(letter, grade, students);
    }

    @Override
    public String toString() {
        return "Group{" +
                "letter='" + letter + '\'' +
                ", grade=" + grade +
                ", students=" + students +
                '}';
    }
}
