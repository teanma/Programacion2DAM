package org.iesfm.institutoorm;

import java.util.Objects;

public class TitleGroup {

    private int id;
    private String course;
    private String letter;
    private String title;
    private int year;

    public TitleGroup(int id, String course, String letter, String title, int year) {
        this.id = id;
        this.course = course;
        this.letter = letter;
        this.title = title;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TitleGroup that = (TitleGroup) o;
        return id == that.id && year == that.year && Objects.equals(course, that.course) && Objects.equals(letter, that.letter) && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, course, letter, title, year);
    }

    @Override
    public String toString() {
        return "TitleGroup{" +
                "id=" + id +
                ", course='" + course + '\'' +
                ", letter='" + letter + '\'' +
                ", title='" + title + '\'' +
                ", year=" + year +
                '}';
    }
}
