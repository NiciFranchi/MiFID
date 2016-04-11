package webservice;


import handlerinterface.QuestionHandlerLocal;
import handlerinterface.QuestionnaireHandlerLocal;
import lookup.EJBLookup;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.Date;

/**
 * Created by u95599 on 2016.03.04.
 */

@SuppressWarnings("ALL")
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
public class MifidService {

    @WebMethod
    @WebResult(name = "addQuestionnaireResponse")
    public void addQuestionnaire(
            @WebParam(name = "name") String name,
            @WebParam(name = "authorFirstName") String authorFirstName,
            @WebParam(name = "authosLastName") String authorLastName) {
        QuestionnaireHandlerLocal handlerBean = EJBLookup.getInstance().getQuestionnaireHandlerLocal();
        handlerBean.addQuestionnaire(name, authorFirstName, authorLastName, new Date());
    }

    @WebMethod
    @WebResult(name = "addQuestionResponse")
    public void addQuestion(
            @WebParam(name = "questionnaireId") Long questionnaireId,
            @WebParam(name = "name") String name,
            @WebParam(name = "description") String description){
        QuestionHandlerLocal handlerBean = EJBLookup.getInstance().getQuestionHandlerLocal();
        handlerBean.addQuestion(questionnaireId, name, description);
    }
//
}
