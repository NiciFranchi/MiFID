package handlerinterface;

import entity.Product;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by u95599 on 2016.04.18.
 */
@Local
public interface ProductHandlerLocal {
    List<Product> getProducts();

    void addProduct(Product product);

    Product getProduct(Long id);

    void deleteProduct(Long id);

    void editProduct(Product product);

    Product getProductByName(String name);
}
