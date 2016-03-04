package webservice;

import dal.QuestionnairreFacade;
import entity.Questionnaire;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.rmi.RemoteException;

/**
 * Created by u95599 on 2016.03.04.
 */

@SuppressWarnings("ALL")
@Stateless
@WebService
public class MifidService {

    @EJB
    QuestionnairreFacade questionnairreFacade;

    @WebMethod
    public void addQuestionnaire() throws RemoteException {
        try {
            Questionnaire questionnaire = new Questionnaire();

            questionnairreFacade.create(questionnaire);


        } catch (Exception e) {
            throw new RemoteException("Hiba történt.", e);
        }
    }
}
