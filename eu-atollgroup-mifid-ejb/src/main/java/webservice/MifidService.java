package webservice;

import dal.QuestionnaireFacade;
import entity.Questionnaire;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by u95599 on 2016.03.04.
 */

@SuppressWarnings("ALL")
@Stateless
@WebService
public class MifidService {

    @EJB
    QuestionnaireFacade questionnairreFacade;

    @WebMethod
    public void addQuestionnaire()  {
        Questionnaire questionnaire = new Questionnaire();

        questionnairreFacade.create(questionnaire);
    }
}
