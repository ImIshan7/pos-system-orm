package entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_generator")
    @SequenceGenerator(name="item_generator", sequenceName = "item_seq", allocationSize=50)
    @Column(name = "code", updatable = false, nullable = false)

    private int code;

    private String description;
    private BigDecimal unitPrice;
    private int qtyOnHand;

    public Item() {
    }

    public Item(int code, String description, BigDecimal unitPrice, int qtyOnHand) {
        this.setCode(code);
        this.setDescription(description);
        this.setUnitPrice(unitPrice);
        this.setQtyOnHand(qtyOnHand);
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

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    @Override
    public String toString() {
        return "Item{" +
                "code=" + getCode() +
                ", description='" + getDescription() + '\'' +
                ", unitPrice=" + getUnitPrice() +
                ", qtyOnHand=" + getQtyOnHand() +
                '}';
    }
}