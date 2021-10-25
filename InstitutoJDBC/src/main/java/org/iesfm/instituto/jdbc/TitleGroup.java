package org.iesfm.instituto.jdbc;

import java.util.Objects;

public class TitleGroup {

    private Integer group_id;
    private String course;
    private String letter;
    private String title;
    private String group_year;

    public TitleGroup(Integer group_id, String course, String letter, String title, String group_year) {
        this.group_id = group_id;
        this.course = course;
        this.letter = letter;
        this.title = title;
        this.group_year = group_year;
    }

    public Integer getGroup_id() {
        return group_id;
    }

    public void setGroup_id(Integer group_id) {
        this.group_id = group_id;
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

    public String getGroup_year() {
        return group_year;
    }

    public void setGroup_year(String group_year) {
        this.group_year = group_year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TitleGroup that = (TitleGroup) o;
        return Objects.equals(group_id, that.group_id) && Objects.equals(course, that.course) && Objects.equals(letter, that.letter) && Objects.equals(title, that.title) && Objects.equals(group_year, that.group_year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(group_id, course, letter, title, group_year);
    }

    @Override
    public String toString() {
        return "TitleGroup{" +
                "group_id=" + group_id +
                ", course='" + course + '\'' +
                ", letter='" + letter + '\'' +
                ", title='" + title + '\'' +
                ", group_year='" + group_year + '\'' +
                '}';
    }
}
