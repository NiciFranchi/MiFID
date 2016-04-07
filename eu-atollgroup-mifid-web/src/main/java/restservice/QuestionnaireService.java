package restservice;

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
    public Questionnaire getQuestionnaire(@PathParam("id") Long id) {
        QuestionnaireHandlerLocal handlerBean = EJBLookup.getInstance().getQuestionnaireHandlerLocal();
        return  handlerBean.getQuestionnaire(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Questionnaire saveQuestonnaire(Questionnaire questionnaire) {
        if (questionnaire.getId() == null) {
            QuestionnaireHandlerLocal handlerBean = EJBLookup.getInstance().getQuestionnaireHandlerLocal();
            handlerBean.addQuestionnaire(questionnaire);
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

        return questionnaire;
    }
}
