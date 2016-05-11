package webservice;


import entity.Product;
import entity.Questionnaire;
import handler.ProductHandler;
import handlerinterface.ProductHandlerLocal;
import handlerinterface.QuestionnaireHandlerLocal;
import lookup.EJBLookup;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.List;

/**
 * Created by u95599 on 2016.03.04.
 */

//@SuppressWarnings("ALL")
@Stateless(name = "MiFIDService")
@WebService(
        name = "MiFIDService",
        portName = "MiFIDServicePort",
        serviceName = "MiFIDService",
        targetNamespace = "applications/MiFID")
@SOAPBinding(
        style = SOAPBinding.Style.DOCUMENT,
        use = SOAPBinding.Use.LITERAL,
        parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
@Interceptors(LoggingInterceptor.class)
@RolesAllowed("mifid_tech_role")
public class MifidService {

    @WebMethod
    public String getQuestionnaires() {
        QuestionnaireHandlerLocal handlerBean = EJBLookup.getInstance().getQuestionnaireHandlerLocal();
        JAXBContext jaxbContext = null;
        StringWriter sw = new StringWriter();
        try {
            jaxbContext = JAXBContext.newInstance(Questionnaire.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(handlerBean.getQuestionnaires(), sw);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return sw.toString();
    }


    @WebMethod
    public String getProducts() {
        ProductHandlerLocal handlerBean = EJBLookup.getInstance().getProductHandlerLocal();
        JAXBContext jaxbContext = null;
        StringWriter sw = new StringWriter();
        try {
            jaxbContext = JAXBContext.newInstance(Questionnaire.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(handlerBean.getProducts(), sw);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return sw.toString();
    }


    @WebMethod
    public void addProduct(@WebParam(name = "name") String name,
                           @WebParam(name = "description") String description,
                           @WebParam(name = "isQuestionnaireNeeded") boolean isQuestionnaireNeeded){
        ProductHandlerLocal handlerBean = EJBLookup.getInstance().getProductHandlerLocal();
        Product product = new Product(name, description, isQuestionnaireNeeded);
        handlerBean.addProduct(product);
    }
}
