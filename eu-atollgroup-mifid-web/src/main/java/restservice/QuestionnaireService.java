package restservice;

import entity.Questionnaire;
import handlerinterface.QuestionnaireHandlerLocal;
import lookup.EJBLookup;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by abator on 3/15/2016.
 */
@Path("/resources")
public class QuestionnaireService {

    @GET
    @Path("/questionnaires")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Questionnaire> getQuestionnaires() {
        QuestionnaireHandlerLocal handlerBean = EJBLookup.getInstance().getQuestionnaireHandlerLocal();
        return handlerBean.getQuestionnaires();
    }
}
