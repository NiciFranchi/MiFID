package restservice;

import entity.Question;
import handler.HandlerBean;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by u95599 on 2016.03.08.
 */
@Path("/QuestionRestService")
public class QuestionRestService {
    @EJB
    HandlerBean handlerBean;

    @GET
    @Path("/questions")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Question> getAllQuestions() {
        return handlerBean.getAllQuestions();
    }
}
