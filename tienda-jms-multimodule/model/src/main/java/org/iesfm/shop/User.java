package org.iesfm.shop;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class User {

    private String username;
    private int phone;
    private String email;

    @JsonCreator
    public User(
            @JsonProperty("username") String username,
            @JsonProperty("phone") int phone,
            @JsonProperty("email") String email) {
        this.username = username;
        this.phone = phone;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return phone == user.phone && Objects.equals(username, user.username) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, phone, email);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                '}';
    }
}
