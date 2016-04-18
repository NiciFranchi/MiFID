package lookup;

import handlerinterface.ProductHandlerLocal;
import handlerinterface.QuestionnaireHandlerLocal;
import org.apache.log4j.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Created by abator on 3/13/2016.
 */
public class EJBLookup {

    private static final Logger logger = Logger.getLogger(EJBLookup.class);

    private static final String QUESTIONNAIRE_HANDLER_JNDI = "java:app/eu-atollgroup-mifid-ejb-1.0-SNAPSHOT/QuestionnaireHandler";
    private static final String PRODUCT_HANDLER_JNDI = "java:app/eu-atollgroup-mifid-ejb-1.0-SNAPSHOT/ProductHandler";


    private static EJBLookup instance = new EJBLookup();
    private QuestionnaireHandlerLocal questionnaireHandlerLocal;
    private ProductHandlerLocal productHandlerLocal;


    private Context initialContext;
    private EJBLookup() {
        try {
            logger.debug("Initializing EJBs...");
            initialContext = new InitialContext();

            questionnaireHandlerLocal = (QuestionnaireHandlerLocal) initialContext.lookup(QUESTIONNAIRE_HANDLER_JNDI);
            logger.debug("questionnaireHandlerLocal has been initialized");

            productHandlerLocal = (ProductHandlerLocal) initialContext.lookup(PRODUCT_HANDLER_JNDI);
            logger.debug("productHandlerLocal has been initialized");

            logger.info("All EJBs have been initialized");
        } catch (NamingException ex) {
            logger.error("Exception occurred during the initialization of EJBs!", ex);
        } finally {
            try {
                initialContext.close();
            } catch (Exception ex) {
                logger.error("Exception occurred during closing the initialContext!", ex);
            }
        }

    }
    public static EJBLookup getInstance() {
        return instance;
    }

    public QuestionnaireHandlerLocal getQuestionnaireHandlerLocal() {
        return questionnaireHandlerLocal;
    }
    public ProductHandlerLocal getProductHandlerLocal() {
        return productHandlerLocal;
    }
}
