package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GenericGenerator(name = "String_based",strategy = "lk.ijse.pos.CustomerIDGenerator")
    @GeneratedValue(generator = "String_based")

    @Column(name = "Customer_Id",length = 50)
    private String id;

    @Column(name = "Customer_name")
    private String name;

    @Column(name = "Customer_address")
    private String address;

    public Customer() {
    }

    public Customer(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

