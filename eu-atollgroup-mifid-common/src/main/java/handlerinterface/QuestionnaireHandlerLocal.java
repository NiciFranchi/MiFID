package handlerinterface;

import entity.Questionnaire;

import javax.ejb.Local;
import java.util.Date;
import java.util.List;

/**
 * Created by abator on 3/13/2016.
 */
@Local
public interface QuestionnaireHandlerLocal {
    List<Questionnaire> getQuestionnaires();

    void addQuestionnaire(String name, String authorFirstName, String authorLastName, Date date);

    void addQuestionnaire(Questionnaire questionnaire);

    Questionnaire getQuestionnaire(Long id);
}