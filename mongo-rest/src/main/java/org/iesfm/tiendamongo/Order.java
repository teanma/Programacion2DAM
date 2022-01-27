package org.iesfm.tiendamongo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Document(collection = "orders")
public class Order {

    @Id
    private int id;
    private String nif;
    private double price;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date date;
    private List<Item> items;

    @JsonCreator
    public Order(
            @JsonProperty("id") int id,
            @JsonProperty("nif") String nif,
            @JsonProperty("price") double price,
            @JsonProperty("date") Date date,
            @JsonProperty("items") List<Item> items) {
        this.id = id;
        this.nif = nif;
        this.price = price;
        this.date = date;
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && Double.compare(order.price, price) == 0 && Objects.equals(nif, order.nif) && Objects.equals(date, order.date) && Objects.equals(items, order.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nif, price, date, items);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", nif='" + nif + '\'' +
                ", price=" + price +
                ", date=" + date +
                ", items=" + items +
                '}';
    }
}
