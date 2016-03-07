package webservice;

import dal.QuestionnaireFacade;
import entity.Questionnaire;

import javax.ejb.EJB;
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

    @EJB
    QuestionnaireFacade questionnaireFacade;

    @WebMethod
    @WebResult(name = "addQuestionnaireResponse")
    public void addQuestionnaire(
            @WebParam(name = "name") String name,
            @WebParam(name = "authorFirstName") String authorFirstName,
            @WebParam(name = "authosLastName") String authorLastName) {
        Questionnaire questionnaire = new Questionnaire(name, authorFirstName, authorLastName, new Date());
        //Questionnaire questionnaire = new Questionnaire();
        questionnaireFacade.create(questionnaire);
        //handlerBean.createQuestionnaire(questionnaire);


    }
}
