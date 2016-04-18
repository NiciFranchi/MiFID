package dal;

import entity.Product;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by u95599 on 2016.04.18.
 */
@Stateless
public class ProductFacade extends AbstractFacade<Product> {
    @PersistenceContext
    private EntityManager em;

    public ProductFacade() {
        super(Product.class);
    }

    @Override
    protected EntityManager em() {
        return em;
    }
}
