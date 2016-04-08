package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 * Created by u95599 on 2016.03.08.
 */
@Entity
@javax.persistence.Table(name = "PRODUCTS")
public class Product {
    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String description;

    @ManyToMany
    private List<Customer> customerList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}
