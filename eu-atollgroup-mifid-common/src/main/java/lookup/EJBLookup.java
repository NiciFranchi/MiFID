package lookup;

import handlerinterface.QuestionHandlerLocal;
import handlerinterface.QuestionnaireHandlerLocal;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Created by abator on 3/13/2016.
 */
public class EJBLookup {

    private static final String QUESTIONNAIRE_HANDLER_JNDI = "java:app/eu-atollgroup-mifid-ejb-1.0-SNAPSHOT/QuestionnaireHandler";
    private static final String QUESTION_HANDLER_JNDI = "java:app/eu-atollgroup-mifid-ejb-1.0-SNAPSHOT/QuestionHandler";


    private static EJBLookup instance = new EJBLookup();

    private QuestionnaireHandlerLocal questionnaireHandlerLocal;
    private QuestionHandlerLocal questionHandlerLocal;


    private Context initialContext;
    private EJBLookup() {
        try {
            //log.debug("Initializing EJBs...");
            initialContext = new InitialContext();

            questionnaireHandlerLocal = (QuestionnaireHandlerLocal) initialContext.lookup(QUESTIONNAIRE_HANDLER_JNDI);
            //log.debug("UserDAO has been initialized");

            questionHandlerLocal = (QuestionHandlerLocal)initialContext.lookup(QUESTION_HANDLER_JNDI);

            //log.info("All EJBs have been initialized");
        } catch (NamingException ex) {
            //log.error("Exception occurred during the initialization of EJBs!", ex);
        } finally {
            try {
                initialContext.close();
            } catch (Exception ex) {
            }
        }

    }
    public static EJBLookup getInstance() {
        return instance;
    }

    public QuestionnaireHandlerLocal getQuestionnaireHandlerLocal() {
        return questionnaireHandlerLocal;
    }
    public QuestionHandlerLocal getQuestionHandlerLocal() { return questionHandlerLocal; }
}
