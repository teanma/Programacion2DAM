package org.iesfm.airline.pojos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Baggage {

    private int code;
    private String description;

    @JsonCreator
    public Baggage(
            @JsonProperty("code") int code,
            @JsonProperty("description") String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Baggage baggage = (Baggage) o;
        return code == baggage.code && Objects.equals(description, baggage.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, description);
    }
}
