package org.iesfm.instituto.jdbc;

import java.util.Objects;

public class Enrollment {

    private Integer enrollment_id;
    private String nif;
    private int enrollment_year;
    private int title_id;
    private int group_id;
    private String enrollment_status;

    public Enrollment(Integer enrollment_id, String nif, int enrollment_year, int title_id, int group_id, String enrollment_status) {
        this.enrollment_id = enrollment_id;
        this.nif = nif;
        this.enrollment_year = enrollment_year;
        this.title_id = title_id;
        this.group_id = group_id;
        this.enrollment_status = enrollment_status;
    }

    public Integer getEnrollment_id() {
        return enrollment_id;
    }

    public void setEnrollment_id(Integer enrollment_id) {
        this.enrollment_id = enrollment_id;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public int getEnrollment_year() {
        return enrollment_year;
    }

    public void setEnrollment_year(int enrollment_year) {
        this.enrollment_year = enrollment_year;
    }

    public int getTitle_id() {
        return title_id;
    }

    public void setTitle_id(int title_id) {
        this.title_id = title_id;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public String getEnrollment_status() {
        return enrollment_status;
    }

    public void setEnrollment_status(String enrollment_status) {
        this.enrollment_status = enrollment_status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enrollment that = (Enrollment) o;
        return enrollment_year == that.enrollment_year && title_id == that.title_id && group_id == that.group_id && Objects.equals(enrollment_id, that.enrollment_id) && Objects.equals(nif, that.nif) && Objects.equals(enrollment_status, that.enrollment_status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enrollment_id, nif, enrollment_year, title_id, group_id, enrollment_status);
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "enrollment_id=" + enrollment_id +
                ", nif='" + nif + '\'' +
                ", enrollment_year=" + enrollment_year +
                ", title_id=" + title_id +
                ", group_id=" + group_id +
                ", enrollment_status='" + enrollment_status + '\'' +
                '}';
    }
}
