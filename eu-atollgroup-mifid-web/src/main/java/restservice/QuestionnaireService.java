package restservice;

import com.google.common.collect.ImmutableList;
import entity.Answer;
import entity.Question;
import entity.Questionnaire;
import handlerinterface.QuestionnaireHandlerLocal;
import lookup.EJBLookup;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by abator on 3/15/2016.
 */

@Path("/resources/questionnaires")
public class QuestionnaireService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Questionnaire> getQuestionnaires() {
        QuestionnaireHandlerLocal handlerBean = EJBLookup.getInstance().getQuestionnaireHandlerLocal();
        return handlerBean.getQuestionnaires();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Questionnaire getQuestionnaire(@PathParam("id") Long id) {
        QuestionnaireHandlerLocal handlerBean = EJBLookup.getInstance().getQuestionnaireHandlerLocal();
        return  handlerBean.getQuestionnaire(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Questionnaire saveQuestonnaire(Questionnaire questionnaireFromJSON) {

        QuestionnaireHandlerLocal handlerBean = EJBLookup.getInstance().getQuestionnaireHandlerLocal();

        Questionnaire questionnaireToSave = questionnaireFromJSON;

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

            handlerBean.addQuestionnaire(questionnaireToSave);
        }
        else {
            handlerBean.editQuestionnaire(questionnaireToSave);
        }

        return questionnaireToSave;
    }

    @DELETE
    @Path("{id}")
    //@Consumes(MediaType.APPLICATION_JSON)
    public void deleteQuestionnaire(@PathParam("id") Long id) {
        QuestionnaireHandlerLocal handlerBean = EJBLookup.getInstance().getQuestionnaireHandlerLocal();
        handlerBean.deleteQuestionnaire(id);
        //return id;
    }
}
