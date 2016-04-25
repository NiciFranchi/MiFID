package handler;

import dal.ProductFacade;
import entity.Product;
import handlerinterface.ProductHandlerLocal;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by u95599 on 2016.04.18.
 */
@Stateless
public class ProductHandler implements ProductHandlerLocal {


    @EJB
    ProductFacade productFacade;

    @Override
    public List<Product> getProducts() {
        return productFacade.findAll();
    }


    @Override
    public void addProduct(Product product) {
        productFacade.create(product);
    }

    @Override
    public Product getProduct(Long id) {
        return productFacade.find(id);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productFacade.find(id);
        productFacade.remove(product);
    }

    @Override
    public void editProduct(Product product) {
        productFacade.edit(product);
    }

    @Override
    public Product getProductByName(String name) {
        return productFacade.findByName(name);
    }
}
