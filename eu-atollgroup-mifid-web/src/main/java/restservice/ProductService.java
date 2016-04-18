package restservice;

import entity.Product;
import handlerinterface.ProductHandlerLocal;
import lookup.EJBLookup;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by u95599 on 2016.04.18.
 */
@Path("/resources/products")
public class ProductService {

    private static final Logger logger = Logger.getLogger(QuestionnaireService.class);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getProducts() {
        logger.info("getProducts() called");
        ProductHandlerLocal handlerBean = EJBLookup.getInstance().getProductHandlerLocal();
        return handlerBean.getProducts();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Product saveProduct(Product product) {
        logger.info("saveProduct() called");
        logger.debug("input Jason object is" + product);
        ProductHandlerLocal handlerBean = EJBLookup.getInstance().getProductHandlerLocal();

        if (product.getId() == null) {
            handlerBean.addProduct(product);
        }
        else {
            handlerBean.editProduct(product);
        }

        return product;
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteProduct(@PathParam("id") Long id) {
        logger.info("deleteProduct() called with ID " + id);
        ProductHandlerLocal handlerBean = EJBLookup.getInstance().getProductHandlerLocal();
        handlerBean.deleteProduct(id);
    }
}

