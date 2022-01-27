package org.iesfm.institutomongo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Objects;

public class Absence {

    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date date;
    private String module;

    public Absence(Date date, String module) {
        this.date = date;
        this.module = module;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Absence absence = (Absence) o;
        return Objects.equals(date, absence.date) && Objects.equals(module, absence.module);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, module);
    }
}
