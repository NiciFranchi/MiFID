package restservice;

import entity.Questionnaire;
import handlerinterface.QuestionnaireHandlerLocal;
import lookup.EJBLookup;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by abator on 3/15/2016.
 */

@Path("/resources/questionnaires")
public class QuestionnaireService {

    @GET
    //@Path("/questionnaires")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Questionnaire> getQuestionnaires() {
        QuestionnaireHandlerLocal handlerBean = EJBLookup.getInstance().getQuestionnaireHandlerLocal();
        return handlerBean.getQuestionnaires();
    }

//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Questionnaire saveQuestonnaire(Questionnaire questionnaire) {
//        if (questionnaire.getId() == null) {
//            Person personToSave = new Person();
//            personToSave.setName(person.getName());
//            personToSave.setDescription(person.getDescription());
//            personToSave.setImageUrl(person.getImageUrl());
//            entityManager.persist(person);
//        }
////        } else {
////            Person personToUpdate = getPerson(person.getId());
////            personToUpdate.setName(person.getName());
////            personToUpdate.setDescription(person.getDescription());
////            personToUpdate.setImageUrl(person.getImageUrl());
////            person = entityManager.merge(personToUpdate);
////        }
//
//        return questionnaire;
//    }
}
