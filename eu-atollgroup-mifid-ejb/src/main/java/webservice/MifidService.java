package webservice;


import entity.Questionnaire;
import handlerinterface.QuestionnaireHandlerLocal;
import lookup.EJBLookup;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

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
    @WebResult(name = "getQuestionnaires")
    public List<Questionnaire> addQuestionnaire() {
        QuestionnaireHandlerLocal handlerBean = EJBLookup.getInstance().getQuestionnaireHandlerLocal();
        return handlerBean.getQuestionnaires();
    }
}
