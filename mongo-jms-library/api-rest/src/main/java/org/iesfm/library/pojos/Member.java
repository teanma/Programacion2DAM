package org.iesfm.library.pojos;

import java.util.Objects;
import java.util.Set;

//@Document(collection = "members")
public class Member {

    //@Id
    private String nif;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private Set<BookLend> bookLends;

    public Member(String nif, String name, String surname, String email, String phone, Set<BookLend> bookLends) {
        this.nif = nif;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.bookLends = bookLends;
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

    public Set<BookLend> getBookLends() {
        return bookLends;
    }

    public void setBookLends(Set<BookLend> bookLends) {
        this.bookLends = bookLends;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(nif, member.nif) && Objects.equals(name, member.name) && Objects.equals(surname, member.surname) && Objects.equals(email, member.email) && Objects.equals(phone, member.phone) && Objects.equals(bookLends, member.bookLends);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nif, name, surname, email, phone, bookLends);
    }
}
