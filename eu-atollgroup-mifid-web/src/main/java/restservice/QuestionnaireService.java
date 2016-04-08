package restservice;

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

        Questionnaire questionnaireReturn = null;
        if (questionnaireFromJSON.getId() == null) {
            QuestionnaireHandlerLocal handlerBean = EJBLookup.getInstance().getQuestionnaireHandlerLocal();
            
            Questionnaire questionnaireToSave = new Questionnaire();
            questionnaireToSave.setName(questionnaireFromJSON.getName());
            questionnaireToSave.setDescription(questionnaireFromJSON.getDescription());

            Question questionToSave;
            for (Question question: questionnaireFromJSON.getQuestions()) {
                questionToSave = question;

//                List<Answer> answers = question.getAnswers();
//                for(Answer answer : answers){
//                    questionToSave.addAnswer(answer);
//                }

                questionnaireToSave.addQuestion(questionToSave);
            }

            questionnaireReturn = questionnaireToSave;
            handlerBean.addQuestionnaire(questionnaireToSave);

//            Questionnaire questionnaire2 = new Questionnaire("Közvetlen", "András", "Bátor", new Date());
//            Question question = new Question("Kérdés", "valami");
//            question.setQuestionnaire(questionnaire2);
//            questionnaire2.getQuestions().add(question);
//            handlerBean.addQuestionnaire(questionnaire2);
//            Person personToSave = new Person();
//            personToSave.setName(person.getName());
//            personToSave.setDescription(person.getDescription());
//            personToSave.setImageUrl(person.getImageUrl());
//            entityManager.persist(person);
        }
//        } else {
//            Person personToUpdate = getPerson(person.getId());
//            personToUpdate.setName(person.getName());
//            personToUpdate.setDescription(person.getDescription());
//            personToUpdate.setImageUrl(person.getImageUrl());
//            person = entityManager.merge(personToUpdate);
//        }

        return questionnaireReturn;
    }
}
