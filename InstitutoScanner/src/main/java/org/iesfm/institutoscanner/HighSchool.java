package org.iesfm.institutoscanner;

import java.util.List;
import java.util.Objects;

public class HighSchool {

    private String highSchoolName;
    private List<Group> groups;

    public HighSchool(String highSchoolName, List<Group> groups) {
        this.highSchoolName = highSchoolName;
        this.groups = groups;
    }

    public String getHighSchoolName() {
        return highSchoolName;
    }

    public void setHighSchoolName(String highSchoolName) {
        this.highSchoolName = highSchoolName;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HighSchool that = (HighSchool) o;
        return Objects.equals(highSchoolName, that.highSchoolName) && Objects.equals(groups, that.groups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(highSchoolName, groups);
    }

    @Override
    public String toString() {
        return "HighSchool{" +
                "highSchoolName='" + highSchoolName + '\'' +
                ", groups=" + groups +
                '}';
    }
}
