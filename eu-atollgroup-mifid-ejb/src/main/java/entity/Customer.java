package entity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 * Created by u95599 on 2016.03.08.
 */
@Entity
public class Customer extends Person{

    @ManyToMany
    private List<Product> productList;

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
