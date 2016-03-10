package restservice;

import entity.Questionnaire;
import handler.HandlerBean;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by u95599 on 2016.03.08.
 */
@Stateless
@ApplicationPath("/resources")
@Path("questionnaries")
public class QuestionnaireRestService extends Application {
    @EJB
    HandlerBean handlerBean;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Questionnaire> getAllQuestionaries() {
        return handlerBean.getAllQuestionaries();
    }
}
