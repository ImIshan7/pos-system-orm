package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_generator")
    @SequenceGenerator(name="customer_generator", sequenceName = "customer_seq", allocationSize=1)
    @Column(name = "id", updatable = false, nullable = false)


    private  int id;
    private String name;
    private String address;

    public Customer() {
    }

    public Customer(int id, String name, String address) {
        this.setId(id);
        this.setName(name);
        this.setAddress(address);
    }

    public  int getId() {
        return id;
    }

    public void setId(int id) {
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
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", address='" + getAddress() + '\'' +
                '}';
    }
}
