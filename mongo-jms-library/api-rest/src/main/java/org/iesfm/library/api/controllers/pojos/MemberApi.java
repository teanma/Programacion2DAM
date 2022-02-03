package org.iesfm.library.api.controllers.pojos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class MemberApi {

    private String nif;
    private String name;
    private String surname;
    private String email;
    private String phone;

    @JsonCreator
    public MemberApi(
            @JsonProperty("nif") String nif,
            @JsonProperty("name") String name,
            @JsonProperty("surname") String surname,
            @JsonProperty("email") String email,
            @JsonProperty("phone") String phone) {
        this.nif = nif;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberApi memberApi = (MemberApi) o;
        return Objects.equals(nif, memberApi.nif) && Objects.equals(name, memberApi.name) && Objects.equals(surname, memberApi.surname) && Objects.equals(email, memberApi.email) && Objects.equals(phone, memberApi.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nif, name, surname, email, phone);
    }
}
