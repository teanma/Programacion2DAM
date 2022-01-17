package org.iefm.mongo;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Document(collection = "emails")
public class Email {

    private List<String> to;
    private String title;
    private String body;

    public Email(List<String> to, String title, String body) {
        this.to = to;
        this.title = title;
        this.body = body;
    }

    public List<String> getTo() {
        return to;
    }

    public void setTo(List<String> to) {
        this.to = to;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return Objects.equals(to, email.to) && Objects.equals(title, email.title) && Objects.equals(body, email.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(to, title, body);
    }

    @Override
    public String toString() {
        return "Email{" +
                "to=" + to +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
