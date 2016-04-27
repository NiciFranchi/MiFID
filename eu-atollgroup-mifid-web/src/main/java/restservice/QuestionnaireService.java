package restservice;

import com.google.common.collect.ImmutableList;
import entity.Answer;
import entity.Product;
import entity.Question;
import entity.Questionnaire;
import handlerinterface.ProductHandlerLocal;
import handlerinterface.QuestionnaireHandlerLocal;
import lookup.EJBLookup;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Date;
import java.util.List;

/**
 * Created by abator on 3/15/2016.
 */

@Path("/resources/questionnaires")
public class QuestionnaireService {

    private static final Logger logger = Logger.getLogger(QuestionnaireService.class);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Questionnaire> getQuestionnaires() {
        logger.info("getQuestionnaires() called");
        QuestionnaireHandlerLocal handlerBean = EJBLookup.getInstance().getQuestionnaireHandlerLocal();
        return handlerBean.getQuestionnaires();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Questionnaire saveQuestonnaire(Questionnaire questionnaireFromJSON) {
        logger.info("saveQuestonnaire() called");
        logger.debug("input Jason object is" + questionnaireFromJSON);
        QuestionnaireHandlerLocal handlerBean = EJBLookup.getInstance().getQuestionnaireHandlerLocal();

        ProductHandlerLocal productHandlerBean = EJBLookup.getInstance().getProductHandlerLocal();

        Questionnaire questionnaireToSave = questionnaireFromJSON;

        Product product = questionnaireFromJSON.getProduct();
        product.setQuestionnaire(questionnaireToSave);
        questionnaireToSave.setProduct(product);

        ImmutableList<Question> questions = ImmutableList.copyOf(questionnaireFromJSON.getQuestions());
        for (Question question: questions) {
            Question questionToSave = question;
            ImmutableList<Answer> answers = ImmutableList.copyOf(question.getAnswers());
            for (Answer answer: answers) {
                questionToSave.addAnswer(answer);
            }
            questionnaireToSave.addQuestion(questionToSave);

        }
        if (questionnaireToSave.getId() == null) {

            questionnaireToSave.setDateOfCreation(new Date());
            questionnaireToSave.setDateOfLastModification(new Date());
            handlerBean.addQuestionnaire(questionnaireToSave);
        }
        else {
            questionnaireToSave.setDateOfLastModification(new Date());
            handlerBean.editQuestionnaire(questionnaireToSave);
        }

        return questionnaireToSave;
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteQuestionnaire(@PathParam("id") Long id) {
        logger.info("deleteQuestionnaire() called with ID " + id);
        QuestionnaireHandlerLocal handlerBean = EJBLookup.getInstance().getQuestionnaireHandlerLocal();
        handlerBean.deleteQuestionnaire(id);
    }
}
